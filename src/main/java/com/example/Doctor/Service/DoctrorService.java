package com.example.Doctor.Service;

import com.example.Doctor.Dao.IDoctorrepository;
import com.example.Doctor.DoctorApplication;
import com.example.Doctor.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctrorService {


    @Autowired
    IDoctorrepository repo;


    public List<Doctor> getAllDoctor(Integer id) {
        List<Doctor> doctor;
        if (id == null) {
            doctor = repo.findAll();
        } else {
            doctor = new ArrayList<>();
            doctor.add(repo.findById(id).get());
        }
 return doctor;

    }

    public Doctor save(Doctor doctor) {
        String Doctorname= doctor.getDoctor_name();
        Doctorname="mr"+Doctorname;
        doctor.setDoctor_name(Doctorname);
        return repo.save(doctor);
    }
}
