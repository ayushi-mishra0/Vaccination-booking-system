package com.example.vaccinationbookingsystem.Dtos.Responsedtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)



public class PersonResponse {
    String name;
    String emailId;
    int age;
    String message;
}