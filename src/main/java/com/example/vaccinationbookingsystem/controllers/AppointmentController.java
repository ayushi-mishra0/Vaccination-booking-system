package com.example.vaccinationbookingsystem.controllers;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseAppointment;
import com.example.vaccinationbookingsystem.Exceptions.DoctorNotPresent;
import com.example.vaccinationbookingsystem.Exceptions.PersonNotPresent;
import com.example.vaccinationbookingsystem.services.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book-appointment")
    public ResponseEntity bookAppointment(@RequestParam int personId, @RequestParam int doctorId){
        try {
            ResponseAppointment responseAppointment = appointmentService.bookAppointment(personId, doctorId);
            return new ResponseEntity<>(responseAppointment, HttpStatus.OK);
        }
        catch(PersonNotPresent ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(DoctorNotPresent ex)   {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}