package com.skyline.hotelalura.services.interfaces;

import com.skyline.hotelalura.models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface IUserService {
    Optional<User> login(String userName, String password ) throws SQLException;
}
