package com.example.summerspr2025.repository;

import com.example.summerspr2025.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
