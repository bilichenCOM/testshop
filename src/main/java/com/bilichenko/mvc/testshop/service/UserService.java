package com.bilichenko.mvc.testshop.service;

import com.bilichenko.mvc.testshop.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> save(User user);
}
