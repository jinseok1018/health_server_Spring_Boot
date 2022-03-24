package com.example.health.controller;

import com.example.health.dto.UserDto;
import com.example.health.dto.UserHealthDto;
import com.example.health.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }
    // 자신의 정보 가져오기
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }
    // 모든 유저 정보 가져오기
    @GetMapping("/user-all")
    public ResponseEntity<ArrayList<UserDto>> getUserAll() {
        return ResponseEntity.ok(userService.getUserAll());
    }
    // 선택한 유저정보 가져오기
    @GetMapping("/user/{userid}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(userid));
    }
    // 유저 헬스 정보 작성
    @PostMapping("/user/health")
    public ResponseEntity<UserHealthDto> postUserHealth(@Valid @RequestBody UserHealthDto userHealthDto) {
        return ResponseEntity.ok(userService.postUserHealth(userHealthDto));
    }
    // 자신의 헬스 정보 가져오기
    @GetMapping("/user/health")
    public ResponseEntity<ArrayList<UserHealthDto>> getMyUserHealth() {
        return ResponseEntity.ok(userService.getMyUserHealth());
    }
    // 다른 유저의 헬스 정보 가져오기.
    @GetMapping("/user/health/{userid}")
    public ResponseEntity<ArrayList<UserHealthDto>> getOtherUserHealth(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getOtherUserHealth(userid));
    }
    //test
    @GetMapping("/user/health/test")
    public ResponseEntity<ArrayList<UserHealthDto>> test(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getOtherUserHealth(userid));
    }
}
