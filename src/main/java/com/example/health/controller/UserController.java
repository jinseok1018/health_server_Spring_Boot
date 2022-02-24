package com.example.health.controller;

import com.example.health.dto.UserDto;
import com.example.health.dto.UserHealthDto;
import com.example.health.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/user/{userid}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(userid));
    }

    @PostMapping("/user/health")
    public ResponseEntity<UserHealthDto> postUserHealth(@Valid @RequestBody UserHealthDto userHealthDto) {
        return ResponseEntity.ok(userService.postUserHealth(userHealthDto));
    }

    @GetMapping("/user/health/{userid}")
    public ResponseEntity<ArrayList<UserHealthDto>> getMyUserHealth(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getMyUserHealth(userid));
    }




}
