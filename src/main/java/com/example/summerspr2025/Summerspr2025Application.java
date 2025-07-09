package com.example.summerspr2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Summerspr2025Application {

    public static void main(String[] args) {
        SpringApplication.run(Summerspr2025Application.class, args);
    }

}
