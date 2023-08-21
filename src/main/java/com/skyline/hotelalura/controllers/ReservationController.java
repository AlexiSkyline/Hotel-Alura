package com.skyline.hotelalura.controllers;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.services.interfaces.IReservationService;

import javax.inject.Inject;
import java.sql.SQLException;

public class ReservationController {
    private final IReservationService reservationService;

    @Inject
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void makeReservation(Reservation reservation, Guest guest) throws SQLException {
        this.reservationService.makeReservation(reservation, guest);
    }
}
