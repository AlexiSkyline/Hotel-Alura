package com.skyline.hotelalura.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Builder
@Getter @Setter
public class Guest {
    private Integer id;
    private String name;
    private String surname;
    private Date birthDate;
    private String nationality;
    private String phoneNumber;
    private BigInteger reservationId;
}
