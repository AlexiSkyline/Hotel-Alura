package com.skyline.hotelalura.services.interfaces;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public interface IReservationService {
    void makeReservation(Reservation reservation, Guest guest) throws SQLException;
    List<Reservation> findAllReservations() throws SQLException;
    List<Guest> findAllGuests() throws SQLException;
    void deleteReservationById(BigInteger id) throws SQLException;
    void deleteGuestById(int id) throws SQLException;
}
