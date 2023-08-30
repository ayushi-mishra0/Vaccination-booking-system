package com.example.vaccinationbookingsystem.Exceptions;

public class PersonNotPresent extends RuntimeException{
    public PersonNotPresent(){
        super("person not present with this id");
    }


}
