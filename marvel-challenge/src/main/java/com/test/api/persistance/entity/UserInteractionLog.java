package com.test.api.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserInteractionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String url;

    private String httpMethod;

    private String username;

    private LocalDateTime timestamp;

    private String remoteAddress;
}
