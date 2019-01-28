package com.bjornspetprojects.microservices.unitrateservice.controllers;

import com.bjornspetprojects.microservices.unitrateservice.model.UnitConversionRate;
import com.bjornspetprojects.microservices.unitrateservice.services.UnitRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitRateController {

    private final UnitRateService unitRateService;

    public UnitRateController(UnitRateService unitRateService) {
        this.unitRateService = unitRateService;
    }

    @GetMapping("/unit-rate/from/{from}/to/{to}")
    public UnitConversionRate findUnitRate(@PathVariable String from,
                                           @PathVariable String to){
        return unitRateService.findByFromAndToIgnoresCase(from, to);
    }
}
