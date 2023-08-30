package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {

}