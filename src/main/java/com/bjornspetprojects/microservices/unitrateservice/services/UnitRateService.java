package com.bjornspetprojects.microservices.unitrateservice.services;

import com.bjornspetprojects.microservices.unitrateservice.model.UnitConversionRate;

public interface UnitRateService {
    UnitConversionRate findByFromAndToIgnoresCase(String from, String to);
}
