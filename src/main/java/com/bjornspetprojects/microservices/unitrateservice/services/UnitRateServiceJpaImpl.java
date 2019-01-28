package com.bjornspetprojects.microservices.unitrateservice.services;

import com.bjornspetprojects.microservices.unitrateservice.configuration.Configuration;
import com.bjornspetprojects.microservices.unitrateservice.model.UnitConversionRate;
import com.bjornspetprojects.microservices.unitrateservice.model.UnitToMMRate;
import com.bjornspetprojects.microservices.unitrateservice.repositories.UnitToMMRateRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.Objects;

@Service
public class UnitRateServiceJpaImpl implements UnitRateService {

    private final UnitToMMRateRepository unitToMMRateRepository;
    private Configuration configuration;
    private Environment environment;

    public UnitRateServiceJpaImpl(UnitToMMRateRepository unitToMMRateRepository, Configuration configuration, Environment environment) {
        this.unitToMMRateRepository = unitToMMRateRepository;
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    public UnitConversionRate findByFromAndToIgnoresCase(String from, String to) {
        UnitToMMRate unitToMMRateFrom = unitToMMRateRepository.findUnitRateByUnitType(from.toUpperCase());
        UnitToMMRate unitToMMRateTo = unitToMMRateRepository.findUnitRateByUnitType(to.toUpperCase());
        int divisionPrecision = configuration.getDivisionprecision();
        return new UnitConversionRate(
                from,
                to,
                unitToMMRateFrom.getAmountOfMM().divide(unitToMMRateTo.getAmountOfMM(),divisionPrecision, RoundingMode.HALF_DOWN),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")))
                );
    }
}
