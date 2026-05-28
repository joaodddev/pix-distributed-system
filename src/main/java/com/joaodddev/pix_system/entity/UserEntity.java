package com.joaodddev.pix_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
}
