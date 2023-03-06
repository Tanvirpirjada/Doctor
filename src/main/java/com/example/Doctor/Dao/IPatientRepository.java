package com.example.Doctor.Dao;

import com.example.Doctor.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
}
