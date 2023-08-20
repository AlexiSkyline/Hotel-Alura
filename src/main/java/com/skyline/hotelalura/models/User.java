package com.skyline.hotelalura.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class User {
    private Integer id;
    private String username;
    private String password;
}
