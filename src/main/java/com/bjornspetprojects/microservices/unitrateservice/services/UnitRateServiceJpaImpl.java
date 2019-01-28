package com.bjornspetprojects.microservices.unitrateservice.services;

import com.bjornspetprojects.microservices.unitrateservice.configuration.Configuration;
import com.bjornspetprojects.microservices.unitrateservice.model.UnitConversionRate;
import com.bjornspetprojects.microservices.unitrateservice.model.UnitToMMRate;
import com.bjornspetprojects.microservices.unitrateservice.repositories.UnitToMMRateRepository;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Service
public class UnitRateServiceJpaImpl implements UnitRateService {

    private final UnitToMMRateRepository unitToMMRateRepository;
    private Configuration configuration;

    public UnitRateServiceJpaImpl(UnitToMMRateRepository unitToMMRateRepository, Configuration configuration) {
        this.unitToMMRateRepository = unitToMMRateRepository;
        this.configuration = configuration;
    }

    @Override
    public UnitConversionRate findByFromAndToIgnoresCase(String from, String to) {
        UnitToMMRate unitToMMRateFrom = unitToMMRateRepository.findUnitRateByUnitType(from.toUpperCase());
        UnitToMMRate unitToMMRateTo = unitToMMRateRepository.findUnitRateByUnitType(to.toUpperCase());
        int divisionPrecision = configuration.getDivisionprecision();
        System.out.println("Div PREC = "+divisionPrecision);
        return new UnitConversionRate(
                from,
                to,
                unitToMMRateFrom.getAmountOfMM().divide(unitToMMRateTo.getAmountOfMM(),divisionPrecision, RoundingMode.HALF_DOWN));
    }
}
