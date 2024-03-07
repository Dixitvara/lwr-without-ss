package com.withoutss.lwr.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private long mobile;
    @Column(nullable = false)
    private String wing;
    @Column(nullable = false)
    private String flat;
    @Enumerated(EnumType.STRING)
    private Role role;
}
