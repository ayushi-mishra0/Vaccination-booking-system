package com.example.vaccinationbookingsystem.services;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.ResponseDoctor;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.RequestDoctor;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseCentre;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import com.example.vaccinationbookingsystem.repository.CentreRepo;
import com.example.vaccinationbookingsystem.repository.DoctorRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class DoctorService {
    @Autowired
    CentreRepo centreRepo;
    @Autowired
    DoctorRepo doctorRepo;

    public ResponseDoctor addDoctor(RequestDoctor requestDoctor) {
        Optional<VaccinationCenter> centre=centreRepo.findById(requestDoctor.getCentre_Id());
        if(centre.isEmpty()){
            throw new RuntimeException("centre not present");
        }
        VaccinationCenter currCentre=centre.get();
        Doctor dt=new Doctor();
        dt.setName(requestDoctor.getName());
        dt.setAge(requestDoctor.getAge());
        dt.setGender(requestDoctor.getGender());
        dt.setEmailId(requestDoctor.getEmailId());
        dt.setCentre(currCentre);
        currCentre.getDoctors().add(dt);
        VaccinationCenter vcs=centreRepo.save(currCentre);

        ResponseDoctor rd=new ResponseDoctor();
        rd.setDtname(dt.getName());
        rd.setMsg("doctor added successfully");
        ResponseCentre rs=new ResponseCentre();
        rs.setName(vcs.getCentreName());
        rs.setCentreType(vcs.getCentreType());
        rs.setMsg("My centre");
        rd.setResponse(rs);
        return rd;
    }
}