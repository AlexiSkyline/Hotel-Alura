package com.skyline.hotelalura.controllers;

import com.skyline.hotelalura.models.User;
import com.skyline.hotelalura.services.interfaces.IUserService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.Optional;

public class AuthController {
    private final IUserService userService;

    @Inject
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    public boolean login(String userName, String password) throws SQLException {
        Optional<User> user = this.userService.login(userName, password);
        return user.isPresent();
    }
}
