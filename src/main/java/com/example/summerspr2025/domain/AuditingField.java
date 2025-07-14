package com.example.summerspr2025.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

// 필요한 필드만을 모아서 생성해준 클래스
@Getter
@ToString
@MappedSuperclass // extends 해도 똑같이 설정해달라는 뜻
@EntityListeners(AuditingEntityListener.class)
public class AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 아이디값이 자동으로 올라가게 만들어줌
    Long id;

    @Column(nullable = false)
    @Setter
    protected Boolean deleted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt;

    @PrePersist
    public void onPrePersist(){this.deleted = false;}
}
