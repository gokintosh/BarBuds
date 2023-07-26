package com.barbuds.userservice.controller;


import com.barbuds.userservice.model.UserInfo;
import com.barbuds.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }


}
