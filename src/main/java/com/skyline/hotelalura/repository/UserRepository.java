package com.skyline.hotelalura.repository;

import com.skyline.hotelalura.models.User;
import com.skyline.hotelalura.repository.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> login(String username, String password) throws SQLException {
        String sqlQuery = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = User.builder()
                            .id(resultSet.getInt( 1 ))
                            .username(resultSet.getString( 2 ))
                            .password(resultSet.getString( 3 ))
                            .build();

                    return Optional.of(user);
                }

                return Optional.empty();
            }
        }
    }
}
