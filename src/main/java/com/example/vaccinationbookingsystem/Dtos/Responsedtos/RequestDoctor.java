package com.example.vaccinationbookingsystem.Dtos.Responsedtos;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE )
public class RequestDoctor {
    String name;
    int age;
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
    int centre_Id;
}