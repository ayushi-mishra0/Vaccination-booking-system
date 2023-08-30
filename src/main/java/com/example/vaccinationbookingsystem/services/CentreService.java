package com.example.vaccinationbookingsystem.services;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.RequestCentre;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseCentre;
import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import com.example.vaccinationbookingsystem.repository.CentreRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service

public class CentreService {
    @Autowired
    CentreRepo centreRepo;
    public ResponseCentre addCentre(RequestCentre centre) {
        VaccinationCenter curcentre=new VaccinationCenter();
        curcentre.setCentreType(centre.getCentreType());
        curcentre.setAdress(centre.getAdress());
        curcentre.setCentreName(centre.getCentreName());
        VaccinationCenter savedCentre=  centreRepo.save(curcentre);


        ResponseCentre response=new ResponseCentre();
        response.setCentreType(savedCentre.getCentreType());
        response.setName(savedCentre.getCentreName());
        response.setMsg("centre added successfully");

        return response;
    }
}