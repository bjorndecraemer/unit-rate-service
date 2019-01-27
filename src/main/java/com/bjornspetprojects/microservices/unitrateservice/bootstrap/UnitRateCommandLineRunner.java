package com.bjornspetprojects.microservices.unitrateservice.bootstrap;

import com.bjornspetprojects.microservices.unitrateservice.model.UnitToMMRate;
import com.bjornspetprojects.microservices.unitrateservice.repositories.UnitToMMRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UnitRateCommandLineRunner implements CommandLineRunner {

    private final UnitToMMRateRepository unitToMMRateRepository;

    public UnitRateCommandLineRunner(UnitToMMRateRepository unitToMMRateRepository) {
        this.unitToMMRateRepository = unitToMMRateRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        unitToMMRateRepository.save(new UnitToMMRate("MM",new BigDecimal(1)));
        unitToMMRateRepository.save(new UnitToMMRate("CM",new BigDecimal(10)));
        unitToMMRateRepository.save(new UnitToMMRate("DM",new BigDecimal(100)));
        unitToMMRateRepository.save(new UnitToMMRate("M",new BigDecimal(1000)));
        unitToMMRateRepository.save(new UnitToMMRate("KM",new BigDecimal(1000000)));
        unitToMMRateRepository.save(new UnitToMMRate("IN",new BigDecimal(25.4)));
        unitToMMRateRepository.save(new UnitToMMRate("FE",new BigDecimal(304.8)));
        unitToMMRateRepository.save(new UnitToMMRate("MI",new BigDecimal(1609000)));
        unitToMMRateRepository.save(new UnitToMMRate("YA",new BigDecimal(914.4)));


    }
}
