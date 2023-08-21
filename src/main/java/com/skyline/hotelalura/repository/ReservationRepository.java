package com.skyline.hotelalura.repository;

import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.repository.interfaces.IReservationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReservationRepository implements IReservationRepository {
    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Reservation> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Reservation> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void create(Reservation reservation) throws SQLException {
        String sqlQuery = "INSERT INTO reservations (`id`, `date_entry`, `date_departure`, `value`, `payment_method`) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, reservation.getId().longValue());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDateEntry().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(reservation.getDateDeparture().getTime()));
            preparedStatement.setBigDecimal(4, reservation.getValue());
            preparedStatement.setString(5, reservation.getPaymentMethod());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Reservation reservation) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
