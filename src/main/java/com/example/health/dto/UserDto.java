package com.example.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.example.health.entity.User;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
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
    // User Entity에서 UserDto
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

    public static ArrayList<UserDto> fromList(List<User> listUser) {
        ArrayList<UserDto> listUserDto= new ArrayList<>();
        int i = 0;
        while(i < listUser.size()){
            UserDto userDto = UserDto.builder()
                    .userid(listUser.get(i).getUserid())
                    .sex(listUser.get(i).isSex())
                    .height(listUser.get(i).getHeight())
                    .build();
            listUserDto.add(userDto);
            i++;
        }
        return listUserDto;
    }
}