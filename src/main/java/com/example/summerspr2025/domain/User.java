package com.example.summerspr2025.domain;

import com.example.summerspr2025.dto.DefaultDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends AuditingField{
    String title;
    String username; // spring 기본값
    String password; // spring 기본값
    String name;
    String phone;
}
