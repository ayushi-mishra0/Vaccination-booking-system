package com.example.vaccinationbookingsystem.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ceid;

    String cerificateId;
    @OneToOne
    @JoinColumn
    Person person;
}
