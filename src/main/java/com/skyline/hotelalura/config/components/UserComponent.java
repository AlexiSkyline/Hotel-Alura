package com.skyline.hotelalura.config.components;

import com.skyline.hotelalura.config.modules.UserModule;
import com.skyline.hotelalura.controllers.AuthController;
import com.skyline.hotelalura.views.Login;
import dagger.Component;

@Component(modules = {UserModule.class})
public interface UserComponent {
    AuthController buildSellerController();
}
