package com.example.health.entity;

import com.example.health.dto.AuthorityDto;
import com.example.health.dto.UserDto;
import com.example.health.dto.UserHealthDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "userid", length = 50, unique = true)
    private String userid;
    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "sex", length = 50)
    private boolean sex;
    @Column(name = "height", length = 50)
    private int height;
    @Column(name = "activated")
    private boolean activated;
    @ManyToMany // user와 authority 다대다 관계를 일대다, 다대일 관계의 조인테이블로 정의
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;


}
