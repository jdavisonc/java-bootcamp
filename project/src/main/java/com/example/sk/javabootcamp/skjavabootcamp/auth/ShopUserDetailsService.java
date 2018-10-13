package com.example.sk.javabootcamp.skjavabootcamp.auth;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.UserNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.ShopUser;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ShopUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ShopUser user = userRepository.findByUsername(s).orElseThrow(() -> new UserNotFoundException(s));
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
