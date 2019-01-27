package com.bjornspetprojects.microservices.unitrateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "unit_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitToMMRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "unit_type")
    private String unitType;
    @Column(name = "amount_of_mm")
    private BigDecimal amountOfMM;

    public UnitToMMRate(String unitType, BigDecimal amountOfMM) {
        this.unitType = unitType;
        this.amountOfMM = amountOfMM;
    }
}
