package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CentreRepo extends JpaRepository<VaccinationCenter,Integer> {
}