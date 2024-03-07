package com.withoutss.lwr.dto;

import com.withoutss.lwr.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String email;
    private String password;
    private String name;
    private int flat;
    private long mobile;
    private String wing;
    private Role role;
}
