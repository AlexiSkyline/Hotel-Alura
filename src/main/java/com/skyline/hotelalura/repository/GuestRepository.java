package com.skyline.hotelalura.repository;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.repository.interfaces.IGuestRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GuestRepository implements IGuestRepository {
    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Guest> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Guest> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void create(Guest guest) throws SQLException {
        String sqlQuery = "INSERT INTO guests (`name`, `surname`, `birth_date`, `nationality`, `phone_number`, `Reservation_Id`) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getSurname());
            preparedStatement.setDate(3, new java.sql.Date(guest.getBirthDate().getTime()));
            preparedStatement.setString(4, guest.getNationality());
            preparedStatement.setString(5, guest.getPhoneNumber());
            preparedStatement.setLong(6, guest.getReservationId().longValue());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Guest guest) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
