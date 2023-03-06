package com.example.Doctor.Dao;

import com.example.Doctor.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorrepository  extends JpaRepository<Doctor,Integer> {
}
