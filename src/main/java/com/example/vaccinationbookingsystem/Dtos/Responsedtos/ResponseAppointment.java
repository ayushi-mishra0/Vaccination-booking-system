package com.example.vaccinationbookingsystem.Dtos.Responsedtos;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ResponseAppointment {
    String personName;

    // @CreationTimestamp
    Date date;

    String appointId;
    String doctorName;

    ResponseCentre centre;
}