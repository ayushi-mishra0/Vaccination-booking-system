package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<Certificate,Integer> {
}