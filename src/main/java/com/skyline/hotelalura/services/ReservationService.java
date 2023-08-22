package com.skyline.hotelalura.services;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.repository.interfaces.IGuestRepository;
import com.skyline.hotelalura.repository.interfaces.IReservationRepository;
import com.skyline.hotelalura.services.interfaces.IReservationService;
import com.skyline.hotelalura.utils.DataBaseConnection;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReservationService implements IReservationService {
    private final IReservationRepository reservationRepository;
    private final IGuestRepository guestRepository;

    @Inject
    public ReservationService(IReservationRepository reservationRepository, IGuestRepository guestRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public void makeReservation(Reservation reservation, Guest guest) throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            this.reservationRepository.setConnection(connection);
            this.guestRepository.setConnection(connection);

            this.reservationRepository.create(reservation);
            this.guestRepository.create(guest);
        }
    }

    @Override
    public List<Reservation> findAllReservations() throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            this.reservationRepository.setConnection(connection);
            return this.reservationRepository.findAll();
        }
    }

    @Override
    public List<Guest> findAllGuests() throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            this.guestRepository.setConnection(connection);
            return this.guestRepository.findAll();
        }
    }
}
