package com.skyline.hotelalura.repository.interfaces;

import com.skyline.hotelalura.models.Guest;

import java.sql.SQLException;

public interface IGuestRepository extends ICrudRepository<Guest> {
    void delete(int id) throws SQLException;
}
