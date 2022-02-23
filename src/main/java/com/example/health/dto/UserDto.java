package com.example.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.example.health.entity.User;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String userid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    private boolean sex;

    private int height;

    private Set<AuthorityDto> authorityDtoSet;
    // User Entity로 UserDto Build
    public static UserDto from(User user) {
        if(user == null) return null;

        return UserDto.builder()
                .userid(user.getUserid())
                .sex(user.isSex())
                .height(user.getHeight())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}