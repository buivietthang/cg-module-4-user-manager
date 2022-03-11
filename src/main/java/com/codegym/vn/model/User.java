package com.codegym.vn.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Not Empty")
    @Size (min = 6, max = 12, message = "Min = 6, Max = 12")
    private String username;

    @NotEmpty(message = "Not Empty")
    private String password;

    @NotEmpty(message = "Not Empty")
    private String fullName;

    @NotEmpty(message = "Not Empty")
    private String phone;

    @NotEmpty(message = "Not Empty")
    private String email;
    private String avatar;

    @ManyToOne
    private Role role;
}
