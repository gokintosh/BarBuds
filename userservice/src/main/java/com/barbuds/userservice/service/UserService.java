package com.barbuds.userservice.service;

import com.barbuds.userservice.model.UserInfo;
import com.barbuds.userservice.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public String createUser(UserInfo userInfo) {

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        UserInfo user = userRepository.save(userInfo);

        return String.format("User with username %s created!!",user.getName());


    }
}
