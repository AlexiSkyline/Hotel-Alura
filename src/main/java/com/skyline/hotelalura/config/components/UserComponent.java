package com.skyline.hotelalura.config.components;

import com.skyline.hotelalura.config.modules.UserModule;
import com.skyline.hotelalura.controllers.AuthController;
import dagger.Component;

@Component(modules = {UserModule.class})
public interface UserComponent {
    AuthController buildSellerController();
}
