package com.example.health.repository;

import com.example.health.entity.User;
import com.example.health.entity.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserHealthRepository extends JpaRepository<UserHealth, Integer> {
    List<UserHealth> findByUser(User user);
}
