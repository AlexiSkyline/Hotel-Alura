package com.skyline.hotelalura.config.modules;

import com.skyline.hotelalura.controllers.ReservationController;
import com.skyline.hotelalura.repository.GuestRepository;
import com.skyline.hotelalura.repository.ReservationRepository;
import com.skyline.hotelalura.services.ReservationService;
import dagger.Module;
import dagger.Provides;

@Module
public class ReservationModule {
    @Provides
    public ReservationRepository reservationRepository() {
        return new ReservationRepository();
    }

    @Provides
    public GuestRepository guestRepository() {
        return new GuestRepository();
    }

    @Provides
    public ReservationService reservationService(ReservationRepository reservationRepository, GuestRepository guestRepository) {
        return new ReservationService(reservationRepository, guestRepository);
    }

    @Provides
    public ReservationController reservationController(ReservationService service) {
        return new ReservationController(service);
    }
}
