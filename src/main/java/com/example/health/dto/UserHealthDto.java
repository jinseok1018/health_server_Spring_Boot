package com.example.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.example.health.entity.User_Health;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHealthDto {

    @NotNull
    private int num;

    @NotNull
    private String userid;

    @NotNull
    private String date;

    @NotNull
    private float weight;

    private float body_fat;

    private float body_muscle;

    private String menu_planner;

    private String exercise_method;


    public static UserHealthDto from(User_Health user_health) {
        return UserHealthDto.builder()
                .num(user_health.getNum())
                .date(user_health.getDate())
                .weight(user_health.getWeight())
                .body_fat(user_health.getBody_fat())
                .body_muscle(user_health.getBody_muscle())
                .menu_planner(user_health.getMenu_planner())
                .exercise_method(user_health.getExercise_method())
                .build();
    }
}
