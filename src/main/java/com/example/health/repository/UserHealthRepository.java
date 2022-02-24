package com.example.health.repository;

import com.example.health.entity.User;
import com.example.health.entity.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserHealthRepository extends JpaRepository<UserHealth, Integer> {

//    Optional<UserHealth> findAll(String userid);
    List<UserHealth> findByUser(User user);
//
//    @Query("SELECT p FROM UserHealth p WHERE p.userid = :userid")
//    UserHealth findByPriceWithParameterNaming(@Param("userid") String userid);
}
