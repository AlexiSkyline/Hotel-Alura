package com.skyline.hotelalura.repository.interfaces;

import com.skyline.hotelalura.models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface IUserRepository {
    void setConnection(Connection connection);
    Optional<User> login(String username, String password) throws SQLException;
}
