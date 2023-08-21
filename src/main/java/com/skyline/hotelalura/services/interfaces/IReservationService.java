package com.skyline.hotelalura.services.interfaces;

import com.skyline.hotelalura.models.Guest;
import com.skyline.hotelalura.models.Reservation;

import java.sql.SQLException;

public interface IReservationService {
    void makeReservation(Reservation reservation, Guest guest) throws SQLException;
}
