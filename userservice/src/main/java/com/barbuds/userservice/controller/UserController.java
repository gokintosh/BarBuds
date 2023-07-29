package com.barbuds.userservice.controller;


import com.barbuds.userservice.model.LoginDto;
import com.barbuds.userservice.model.UserInfo;
import com.barbuds.userservice.service.JwtService;
import com.barbuds.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/create")
    public String createUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(loginDto.getUsername());
        }else{
            throw new UsernameNotFoundException(String.format("Username with %s username not found!!",loginDto.getUsername()));
        }

    }


}
