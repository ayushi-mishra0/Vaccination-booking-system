package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepo extends JpaRepository<Dose,Integer> {
}