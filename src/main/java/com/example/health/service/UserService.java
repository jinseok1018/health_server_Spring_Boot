package com.example.health.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.health.dto.UserDto;
import com.example.health.dto.UserHealthDto;
import com.example.health.entity.Authority;
import com.example.health.entity.User;
import com.example.health.entity.UserHealth;
import com.example.health.exception.DuplicateMemberException;
import com.example.health.repository.UserHealthRepository;
import com.example.health.repository.UserRepository;
import com.example.health.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserHealthRepository userHealthRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository, UserHealthRepository userHealthRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userHealthRepository = userHealthRepository;
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

    // 회원가입
    @Transactional
    public UserHealthDto postUserHealth(UserHealthDto userHealthDto) {
        UserHealth userHealth = UserHealth.builder()
                .user(SecurityUtil.getCurrentUserid().flatMap(userRepository::findOneWithAuthoritiesByUserid).orElse(null))
                .date(userHealthDto.getDate())
                .weight(userHealthDto.getWeight())
                .body_fat(userHealthDto.getBody_fat())
                .body_muscle(userHealthDto.getBody_muscle())
                .menu_planner(userHealthDto.getMenu_planner())
                .exercise_method(userHealthDto.getExercise_method())
                .build();
        return UserHealthDto.from(userHealthRepository.save(userHealth));
    }

    @Transactional
    public ArrayList<UserHealthDto> getMyUserHealth(String userid) {
        return UserHealthDto.fromList(userHealthRepository.findByUser(SecurityUtil.getCurrentUserid().flatMap(userRepository::findOneWithAuthoritiesByUserid).orElse(null)));
    }
}