package com.bjornspetprojects.microservices.unitrateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitConversionRate {
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private int port;

    public UnitConversionRate(String from, String to, BigDecimal conversionRate) {
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
    }
}
