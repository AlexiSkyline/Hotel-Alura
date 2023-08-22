package com.skyline.hotelalura.repository.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    void setConnection(Connection connection);
    List<T> findAll() throws SQLException;
    void create(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
}
