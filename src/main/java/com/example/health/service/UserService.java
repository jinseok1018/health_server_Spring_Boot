package com.example.health.service;

import java.util.Collections;

import com.example.health.dto.UserDto;
import com.example.health.entity.Authority;
import com.example.health.entity.User;
import com.example.health.exception.DuplicateMemberException;
import com.example.health.repository.UserRepository;
import com.example.health.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUserid(userDto.getUserid()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }
        // 권한 정보를 만듦
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        // 권한정보도 넣어서 User 정보를 만듦
        User user = User.builder()
                .userid(userDto.getUserid())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .sex(userDto.isSex())
                .height(userDto.getHeight())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return UserDto.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String userid) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByUserid(userid).orElse(null));
    }


    // SecurityContext에 저장된 username의 정보만 가져옴옴
   @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(SecurityUtil.getCurrentUserid().flatMap(userRepository::findOneWithAuthoritiesByUserid).orElse(null));
    }
}