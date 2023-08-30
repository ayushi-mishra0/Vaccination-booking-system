package com.example.vaccinationbookingsystem.Dtos.Requestdtos;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)

public class AddpersonDto {
    String name;
    int age;
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
}