package com.example.health.dto;

import com.example.health.entity.User;
import lombok.*;
import com.example.health.entity.UserHealth;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHealthDto {
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

    public static UserHealthDto from(UserHealth userHealth) {
        return UserHealthDto.builder()
                .userid(userHealth.getUser().getUserid())
                .date(userHealth.getDate())
                .weight(userHealth.getWeight())
                .body_fat(userHealth.getBody_fat())
                .body_muscle(userHealth.getBody_muscle())
                .menu_planner(userHealth.getMenu_planner())
                .exercise_method(userHealth.getExercise_method())
                .build();
    }

    public static ArrayList<UserHealthDto> fromList(List<UserHealth> listUserHealth) {
        ArrayList<UserHealthDto> listUserHealthDto= new ArrayList<>();
        int i = 0;
        while(i < listUserHealth.size()){
            UserHealthDto userHealthDto = UserHealthDto.builder()
                    .userid(listUserHealth.get(i).getUser().getUserid())
                    .date(listUserHealth.get(i).getDate())
                    .weight(listUserHealth.get(i).getWeight())
                    .body_fat(listUserHealth.get(i).getBody_fat())
                    .body_muscle(listUserHealth.get(i).getBody_muscle())
                    .menu_planner(listUserHealth.get(i).getMenu_planner())
                    .exercise_method(listUserHealth.get(i).getExercise_method())
                    .build();
            listUserHealthDto.add(userHealthDto);
            i++;
        }
        return listUserHealthDto;
    }
}
