package com.example.vaccinationbookingsystem.services;

import com.example.vaccinationbookingsystem.Dtos.Requestdtos.AddpersonDto;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.PersonResponse;
import com.example.vaccinationbookingsystem.Enum.Gender;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.repository.DoctorRepo;
import com.example.vaccinationbookingsystem.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private DoctorRepo doctorRepo;
    public PersonResponse addPerson(AddpersonDto addperson) {
        Person p=new Person();
        p.setAge(addperson.getAge());
        p.setName(addperson.getName());
        p.setCertificate(null);
        p.setEmailId(addperson.getEmailId());
        p.setGender(addperson.getGender());

        Person saved= personRepo.save(p);
        PersonResponse response=new PersonResponse();
        response.setName((saved.getName()));
        response.setAge(saved.getAge());
        response.setEmailId(saved.getEmailId());
        response.setMessage("person added successfully Id no is"+saved.getId());
        return response;
    }

    public List<PersonResponse> getPersonsgreaterAge(int age) {
        List<Person> persons=personRepo.getPersonGreaterAge(age);
        List<PersonResponse> responses=new ArrayList<>();
        for(Person person:persons){
            PersonResponse pr=new PersonResponse();
            pr.setName(person.getName());
            pr.setEmailId(person.getEmailId());
            pr.setAge(person.getAge());
            pr.setMessage("i am greater than "+age);
            responses.add(pr);
        }
        return responses;
    }

    public List<PersonResponse> getMalesgreaterAge(int age) {
        List<Person> persons=personRepo.getPersonGreaterAge(age);
        List<PersonResponse> responses=new ArrayList<>();
        int count=1;
        for(Person P:persons){
            Person curr=P;
            if(P.getGender().equals(Gender.MALE)) {
                PersonResponse res = new PersonResponse();
                res.setName(curr.getName());
                res.setAge(curr.getAge());
                res.setEmailId(curr.getEmailId());
                res.setMessage("" + count);
                count++;
                responses.add(res);
            }
        }
        List<Doctor> doctors=doctorRepo.getDoctorsGreaterThanAge(age);
        for(Doctor d:doctors){
            if(d.getGender().equals(Gender.MALE)){
                PersonResponse res = new PersonResponse();
                res.setName(d.getName());
                res.setEmailId(d.getEmailId());
                res.setAge(d.getAge());
                res.setMessage(""+count);
                count++;
                responses.add(res);
            }
        }
        return responses;
    }

    public List<PersonResponse> getAllFemalesDose1() {
        List<Person> persons=personRepo.findByGender(Gender.FEMALE);
        List<PersonResponse> responses=new ArrayList<>();
        int count=1;
        for(Person p:persons){
            if(p.isDose1Taken() && p.isDose2Taken()==false){
                PersonResponse res=new PersonResponse();
                res.setName(p.getName());
                res.setEmailId(p.getEmailId());
                res.setAge(p.getAge());
                res.setMessage(""+count);
                count++;
                responses.add(res);
            }
        }
        return responses;
    }

    public List<PersonResponse> getFullyVaccinated() {
        List<Person> persons=personRepo.findAll();
        List<PersonResponse> responses=new ArrayList<>();
        int count=1;
        for(Person p:persons){
            if(p.isDose1Taken() && p.isDose2Taken()){
                PersonResponse res=new PersonResponse();
                res.setName(p.getName());
                res.setEmailId(p.getEmailId());
                res.setAge(p.getAge());
                res.setMessage(""+count);
                count++;
                responses.add(res);
            }
        }
        return responses;
    }

    public List<PersonResponse> getNoneDose() {
        List<Person> persons=personRepo.findByDose1TakenAndDose2Taken(false,false);
        List<PersonResponse> responses=new ArrayList<>();
        int count=1;
        for(Person p:persons){

            PersonResponse res=new PersonResponse();
            res.setName(p.getName());
            res.setEmailId(p.getEmailId());
            res.setAge(p.getAge());
            res.setMessage(""+count);
            count++;
            responses.add(res);

        }
        return responses;
    }
}