package com.skyline.hotelalura.config.components;

import com.skyline.hotelalura.config.modules.ReservationModule;
import com.skyline.hotelalura.controllers.ReservationController;
import dagger.Component;

@Component(modules = {ReservationModule.class})
public interface ReservationComponent {
    ReservationController buildReservationController();
}
