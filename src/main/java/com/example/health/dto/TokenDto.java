package com.example.health.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto { // 토큰정보를 response할 때 사용
    private String token;
}