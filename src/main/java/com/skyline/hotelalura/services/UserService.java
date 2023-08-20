package com.skyline.hotelalura.services;

import com.skyline.hotelalura.models.User;
import com.skyline.hotelalura.repository.interfaces.IUserRepository;
import com.skyline.hotelalura.services.interfaces.IUserService;
import com.skyline.hotelalura.utils.DataBaseConnection;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepository repository;

    @Inject
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> login(String userName, String password) throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            this.repository.setConnection(connection);
            return this.repository.login(userName, password);
        }
    }
}
