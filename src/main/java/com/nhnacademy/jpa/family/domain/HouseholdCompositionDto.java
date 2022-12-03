package com.nhnacademy.jpa.family.domain;

import com.nhnacademy.jpa.family.entity.code.CompositionReason;
import com.nhnacademy.jpa.family.entity.code.Relationship;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Value;

import java.time.LocalDate;

@Value
public class HouseholdCompositionDto {
    private final Relationship relationship;
    private final String name;
    private final String registrationNumber;
    private final LocalDate reportDate;
    private final CompositionReason reason;

    @QueryProjection
    public HouseholdCompositionDto(Relationship relationship, String name, String registrationNumber, LocalDate reportDate, CompositionReason reason) {
        this.relationship = relationship;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.reportDate = reportDate;
        this.reason = reason;
    }
}