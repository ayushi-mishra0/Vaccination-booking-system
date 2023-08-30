package com.example.vaccinationbookingsystem.Dtos.Requestdtos;

import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseCentre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE )

public class ResponseDoctor {
    String dtname;
    String msg;
    ResponseCentre response;
}
