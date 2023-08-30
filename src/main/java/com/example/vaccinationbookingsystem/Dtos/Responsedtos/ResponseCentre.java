package com.example.vaccinationbookingsystem.Dtos.Responsedtos;

import com.example.vaccinationbookingsystem.Enum.CenterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ResponseCentre {
    String Name;
    @Enumerated(EnumType.STRING)
    CenterType centreType;
    String msg;

}