package com.barbuds.userservice.service;

import com.barbuds.userservice.config.UserInfoUserDetails;
import com.barbuds.userservice.model.UserInfo;
import com.barbuds.userservice.respository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> user=userRepository.findByName(username);

        return user.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException(String.format("User with username %s not exists!!",username)));

    }
}
