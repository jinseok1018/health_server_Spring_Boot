package com.example.health.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_health")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHealth {
    @ManyToOne
    @JoinColumn(name ="userid")
    private User user;
    @Id
    @Column(name = "num")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private int num;
    @Column(name = "date")
    private String date;
    @Column(name = "weight")
    private float weight;
    @Column(name = "body_fat")
    private float body_fat;
    @Column(name = "body_muscle")
    private float body_muscle;
    @Column(name = "menu_planner")
    private String menu_planner;
    @Column(name = "exercise_method")
    private String exercise_method;
}