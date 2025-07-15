package com.example.summerspr2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 구동하는 파일에 항상달아줘야함 auditing field에서 사용하고 있으므로
@SpringBootApplication
public class Summerspr2025Application {

    public static void main(String[] args) {
        SpringApplication.run(Summerspr2025Application.class, args);
    }

}
