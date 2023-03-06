package com.example.Doctor.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    private String patient_name;
    private String phone_number;
    private String diacease_type;
    private Integer age;
    private String gender;
    private Timestamp admit_date;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor_id;
}
