package com.skyline.hotelalura.repository.interfaces;


import com.skyline.hotelalura.models.Reservation;

import java.math.BigInteger;
import java.sql.SQLException;

public interface IReservationRepository extends ICrudRepository<Reservation> {
    void delete(BigInteger id) throws SQLException;
}
