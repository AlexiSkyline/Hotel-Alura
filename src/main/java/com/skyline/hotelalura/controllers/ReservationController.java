package com.skyline.hotelalura.controllers;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;
import com.skyline.hotelalura.services.interfaces.IReservationService;

import javax.inject.Inject;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public void deleteReservation(BigInteger id) throws SQLException {
        Optional<Guest> guest = this.reservationService
                .findAllGuests()
                .stream()
                .filter(g -> g.getReservationId().equals(id))
                .findFirst();

        if (guest.isPresent()) {
            this.reservationService.deleteGuestById(guest.get().getId());
        }

        this.reservationService.deleteReservationById(id);
    }

    public void deleteGuest(int id) throws SQLException {
        this.reservationService.deleteGuestById(id);
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        this.reservationService.updateReservation(reservation);
    }

    public void updateGuest(Guest guest) throws SQLException {
        this.reservationService.updateGuest(guest);
    }
}
