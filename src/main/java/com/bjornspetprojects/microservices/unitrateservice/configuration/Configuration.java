package com.bjornspetprojects.microservices.unitrateservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("unit-rate-service")
public class Configuration {
    private int divisionprecision;

    public int getDivisionprecision() {
        return divisionprecision;
    }

    public void setDivisionprecision(int divisionprecision) {
        this.divisionprecision = divisionprecision;
    }
}
