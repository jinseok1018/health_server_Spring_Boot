package com.example.health.repository;

import com.example.health.entity.User_Health;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHealthRepository extends JpaRepository<User_Health, Long> {
}
