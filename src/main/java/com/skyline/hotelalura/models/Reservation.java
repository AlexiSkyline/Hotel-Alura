package com.skyline.hotelalura.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Builder
@Getter @Setter
public class Reservation {
    private BigInteger id;
    private Date dateEntry;
    private Date dateDeparture;
    private BigDecimal value;
    private String paymentMethod;
}
