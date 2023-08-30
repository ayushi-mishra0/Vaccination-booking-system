package com.example.vaccinationbookingsystem.Exceptions;

public class AppointmentNotPresent extends RuntimeException{
    public AppointmentNotPresent(String msg){
        super(msg);
    }
}