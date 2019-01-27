package com.bjornspetprojects.microservices.unitrateservice.repositories;

import com.bjornspetprojects.microservices.unitrateservice.model.UnitToMMRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitToMMRateRepository extends JpaRepository<UnitToMMRate,Long> {
    UnitToMMRate findUnitRateByUnitType(String from);
}
