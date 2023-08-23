package com.skyline.hotelalura.repository;

import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.repository.interfaces.IReservationRepository;

import java.math.BigInteger;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReservationRepository implements IReservationRepository {
    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Reservation> findAll() throws SQLException {
        String sqlQuery = "SELECT * FROM reservations;";
        List<Reservation> reservations = new LinkedList<>();

        try (Statement statement = this.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            while (resultSet.next()) {
                Reservation reservation = Reservation.builder()
                        .id(BigInteger.valueOf(resultSet.getLong("id")))
                        .dateEntry(resultSet.getDate("date_entry"))
                        .dateDeparture(resultSet.getDate("date_departure"))
                        .value(resultSet.getBigDecimal("value"))
                        .paymentMethod(resultSet.getString("payment_method"))
                        .build();
                reservations.add(reservation);
            }
        }

        return reservations;
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
        String sqlQuery = "UPDATE reservations SET date_entry = ?, date_departure = ?, value = ?, payment_method = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setDate(1, new java.sql.Date(reservation.getDateEntry().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDateDeparture().getTime()));
            preparedStatement.setBigDecimal(3, reservation.getValue());
            preparedStatement.setString(4, reservation.getPaymentMethod());
            preparedStatement.setLong(5, reservation.getId().longValue());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(BigInteger id) throws SQLException {
        String sqlQuery = "DELETE FROM reservations WHERE id = ?;";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, id.longValue());
            preparedStatement.executeUpdate();
        }
    }
}
