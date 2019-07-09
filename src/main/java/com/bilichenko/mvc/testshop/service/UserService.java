package com.bilichenko.mvc.testshop.service;

import com.bilichenko.mvc.testshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> getByEmail(String email);
}
