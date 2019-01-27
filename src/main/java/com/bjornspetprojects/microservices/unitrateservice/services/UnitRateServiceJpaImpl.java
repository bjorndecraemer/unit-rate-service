package com.bjornspetprojects.microservices.unitrateservice.services;

import com.bjornspetprojects.microservices.unitrateservice.model.UnitConversionRate;
import com.bjornspetprojects.microservices.unitrateservice.model.UnitToMMRate;
import com.bjornspetprojects.microservices.unitrateservice.repositories.UnitToMMRateRepository;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Service
public class UnitRateServiceJpaImpl implements UnitRateService {

    private final UnitToMMRateRepository unitToMMRateRepository;

    public UnitRateServiceJpaImpl(UnitToMMRateRepository unitToMMRateRepository) {
        this.unitToMMRateRepository = unitToMMRateRepository;
    }

    @Override
    public UnitConversionRate findByFromAndToIgnoresCase(String from, String to) {
        UnitToMMRate unitToMMRateFrom = unitToMMRateRepository.findUnitRateByUnitType(from.toUpperCase());
        UnitToMMRate unitToMMRateTo = unitToMMRateRepository.findUnitRateByUnitType(to.toUpperCase());
        return new UnitConversionRate(
                from,
                to,
                unitToMMRateFrom.getAmountOfMM().divide(unitToMMRateTo.getAmountOfMM(),20, RoundingMode.HALF_DOWN));
    }
}