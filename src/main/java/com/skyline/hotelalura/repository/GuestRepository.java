package com.skyline.hotelalura.repository;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.repository.interfaces.IGuestRepository;

import java.math.BigInteger;
import java.sql.*;
import java.util.LinkedList;
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
        String sqlQuery = "SELECT * FROM guests;";
        List<Guest> guests = new LinkedList<>();

        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            while (resultSet.next()) {
                Guest guest = Guest.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .birthDate(resultSet.getDate(4))
                        .nationality(resultSet.getString(5))
                        .phoneNumber(resultSet.getString(6))
                        .reservationId(BigInteger.valueOf(resultSet.getLong(7)))
                        .build();
                guests.add(guest);
            }
        }

        return guests;
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
        String sqlQuery = "UPDATE guests SET name = ?, surname = ?, birth_date = ?, nationality = ?, phone_number = ?, Reservation_Id = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getSurname());
            preparedStatement.setDate(3, new java.sql.Date(guest.getBirthDate().getTime()));
            preparedStatement.setString(4, guest.getNationality());
            preparedStatement.setString(5, guest.getPhoneNumber());
            preparedStatement.setLong(6, guest.getReservationId().longValue());
            preparedStatement.setInt(7, guest.getId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sqlQuery = "DELETE FROM guests WHERE id = ?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
