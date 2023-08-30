package com.example.vaccinationbookingsystem.controllers;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.RequestCentre;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseCentre;
import com.example.vaccinationbookingsystem.services.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centre")
public class CentreController {
    @Autowired
    CentreService centreService;

    @PostMapping("/add-centre")
    public ResponseCentre addCentre(@RequestBody RequestCentre centre){
        ResponseCentre response=centreService.addCentre(centre);
        return response;
    }
}