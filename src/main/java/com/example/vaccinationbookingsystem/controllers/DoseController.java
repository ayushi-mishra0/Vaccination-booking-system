package com.example.vaccinationbookingsystem.controllers;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.RequestDose;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseDose;
import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Exceptions.PersonNotPresent;
import com.example.vaccinationbookingsystem.repository.DoseRepo;
import com.example.vaccinationbookingsystem.services.DoseService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("take-dose-1")
    public ResponseEntity addDose(@RequestBody RequestDose requestDose){
        try {
            ResponseDose response = doseService.addDose(requestDose);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch(PersonNotPresent ex){
            return new ResponseEntity("invalid person Id",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-all-doses")
    public List<DoseType> getAlldosesById(@RequestParam int id){
        try {
            List<DoseType> types = doseService.getAlldoses(id);
            return types;
        }
        catch(RuntimeException ex){
            return new ArrayList<>();
        }
    }

    @PostMapping("/get-dose-2")
    public ResponseEntity getDose2(@RequestBody RequestDose requestDose){
        try{
            ResponseDose dose2=doseService.getDose2(requestDose);
            return new ResponseEntity(dose2,HttpStatus.OK);
        }
        catch(PersonNotPresent ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (RuntimeException ex){
            return new ResponseEntity("take dose 1 first",HttpStatus.FORBIDDEN);
        }
    }
}