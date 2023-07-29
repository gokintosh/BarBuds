package com.barbuds.userservice.model;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
