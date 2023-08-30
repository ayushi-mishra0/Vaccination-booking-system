package com.example.vaccinationbookingsystem.Dtos.Requestdtos;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RequestDose {
    int personId;
    @Enumerated(EnumType.STRING)
    DoseType doseType;
}