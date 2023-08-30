package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Enum.Gender;
import com.example.vaccinationbookingsystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
    @Query(value = "select * from person where age>:age",nativeQuery = true)
    public List<Person> getPersonGreaterAge(int age);

    @Query(value = "select p fromm Person p where p.age>age & p.gender==MALE",nativeQuery = true)
    public List<Person>  getMaleGreaterThanAge(int age);

    List<Person> findByGender(Gender gender);
    List<Person> findByDose1TakenAndDose2Taken(boolean isdose1,boolean isdose2);
}