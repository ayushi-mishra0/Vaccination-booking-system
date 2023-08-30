package com.example.vaccinationbookingsystem.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String appointmentId;

    @CreationTimestamp
    Date appointmentDate;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @ManyToOne
    @JoinColumn
    Person person;

}
