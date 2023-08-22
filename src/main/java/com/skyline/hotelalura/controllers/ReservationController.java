package com.skyline.hotelalura.controllers;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.services.interfaces.IReservationService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class ReservationController {
    private final IReservationService reservationService;

    @Inject
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void makeReservation(Reservation reservation, Guest guest) throws SQLException {
        this.reservationService.makeReservation(reservation, guest);
    }

    public List<Reservation> findAllReservations() throws SQLException {
        return this.reservationService.findAllReservations();
    }

    public List<Guest> findAllGuests() throws SQLException {
        return this.reservationService.findAllGuests();
    }
}
