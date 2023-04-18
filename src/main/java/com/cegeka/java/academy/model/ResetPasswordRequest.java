package com.cegeka.java.academy.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ResetPasswordRequest")
public class ResetPasswordRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "requestId")
    private String requestId = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}