package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String centreName;
    @Enumerated(EnumType.STRING)
    CenterType centreType;

    String adress;

    @OneToMany(mappedBy="centre",cascade = CascadeType.ALL)
    List<Doctor> doctors=new ArrayList<>();

}
