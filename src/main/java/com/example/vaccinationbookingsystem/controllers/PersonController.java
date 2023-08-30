package com.example.vaccinationbookingsystem.controllers;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.AddpersonDto;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.PersonResponse;
import com.example.vaccinationbookingsystem.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddpersonDto addperson){
        try{
            PersonResponse response=personService.addPerson(addperson);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(RuntimeException ex)  {
            return new ResponseEntity<>("email already exists",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getperson-GreaterThan")
    public List<PersonResponse> getPersonGreaterAge(@RequestParam int age){
        List<PersonResponse> names=personService.getPersonsgreaterAge(age);
        return names;
    }

    @GetMapping("/get-Males-greater-than-age")
    public List<PersonResponse> MalesGreaterthanAge(@RequestParam int age){
        List<PersonResponse> persons=personService.getMalesgreaterAge(age);
        return persons;
    }

    @GetMapping("/getAll-females-dose1")
    public List<PersonResponse> getAllfemalesWithdose1(){
        return personService.getAllFemalesDose1();
    }

    @GetMapping("get-fully-vaccinated")
    public List<PersonResponse> getFullvaccinated(){
        return personService.getFullyVaccinated();
    }

    @GetMapping("/get-none-doseTaken")
    public List<PersonResponse> getNoneDose(){
        return personService.getNoneDose();
    }
}