package com.example.vaccinationbookingsystem.services;

import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseAppointment;
import com.example.vaccinationbookingsystem.Dtos.Responsedtos.ResponseCentre;
import com.example.vaccinationbookingsystem.Exceptions.DoctorNotPresent;
import com.example.vaccinationbookingsystem.Exceptions.PersonNotPresent;
import com.example.vaccinationbookingsystem.Model.Appointment;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.repository.AppointmentRepo;
import com.example.vaccinationbookingsystem.repository.DoctorRepo;
import com.example.vaccinationbookingsystem.repository.PersonRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service

public class AppointmentService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    PersonRepo personRepo;
    @Autowired
    DoctorRepo doctorRepo;
    public ResponseAppointment bookAppointment(int personId, int doctorId) {
        Optional<Person> isPerson=personRepo.findById(personId);
        if(isPerson.isEmpty()){
            throw new PersonNotPresent();
        }
        Optional<Doctor> isDoctor=doctorRepo.findById(doctorId);
        if(isDoctor.isEmpty()){
            throw new DoctorNotPresent("doctor not present with this id"+doctorId);
        }
        Person person =isPerson.get();
        Doctor doctor=isDoctor.get();

        Appointment appointment=new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        appointmentRepo.save(appointment);

        person.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);
        Person savedPerson= personRepo.save(person);
        Doctor savedDoctor=doctorRepo.save(doctor);
        Appointment savedAppointment=doctor.getAppointments().get(doctor.getAppointments().size()-1);

        String text="congratulations " +savedPerson.getName()+" we are offering you Work from home with 4.7LPA ctc "+savedDoctor.getName()
                + " will be your team head contact him with in 7 days his emai Id is "+savedDoctor.getEmailId()+" meet him on this adress "
                +savedDoctor.getCentre().getCentreName()+" "+savedDoctor.getCentre().getAdress()+
                " you are Recruited for the post ManageMent Associate Applied by st477099@gmail.com reff by Shushant tiwari";

        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setFrom("acciojobteamrecruiter184@gmail.com");
        mail.setTo(savedPerson.getEmailId());
        mail.setSubject("congrats!! you are hired");
        mail.setText(text);
        mailSender.send(mail);

        ResponseAppointment responseAppointment= new ResponseAppointment();
        responseAppointment.setAppointId(savedAppointment.getAppointmentId());
        responseAppointment.setPersonName(savedPerson.getName());
        responseAppointment.setDoctorName(savedDoctor.getName());
        responseAppointment.setDate(savedAppointment.getAppointmentDate());

        ResponseCentre centre=new ResponseCentre();
        centre.setCentreType(savedDoctor.getCentre().getCentreType());
        centre.setName(savedDoctor.getCentre().getCentreName());
        centre.setMsg(" please visit on allocated date");

        responseAppointment.setCentre(centre);

        return responseAppointment;
    }
}