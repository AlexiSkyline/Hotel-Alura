package com.skyline.hotelalura.config.modules;

import com.skyline.hotelalura.controllers.AuthController;
import com.skyline.hotelalura.repository.UserRepository;
import com.skyline.hotelalura.services.UserService;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Provides
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }

    @Provides
    public AuthController authController(UserService service) {
        return new AuthController(service);
    }
}
