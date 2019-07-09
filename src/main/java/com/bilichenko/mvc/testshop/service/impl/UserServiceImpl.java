package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.dao.UserRepository;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> save(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getName(),
                        u.getPassword(),
                        authorityList(u)
                ))
                .orElseThrow(() -> new UsernameNotFoundException("user this email not found"));
    }

    public List<GrantedAuthority> authorityList(User user) {
        return user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }
}