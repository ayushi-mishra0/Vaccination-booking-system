package com.example.vaccinationbookingsystem.Exceptions;

public class DoctorNotPresent extends RuntimeException{
    public DoctorNotPresent(String msg){
        super(msg);
    }
}
