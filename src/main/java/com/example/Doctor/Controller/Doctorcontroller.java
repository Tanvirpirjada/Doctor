package com.example.Doctor.Controller;

import com.example.Doctor.Model.Doctor;
import com.example.Doctor.Service.DoctrorService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class Doctorcontroller {



    @Autowired
    DoctrorService service;


    @GetMapping("getdoctor")
    public List<Doctor> findalldoctor(@Nullable @RequestParam Integer id){
        return  service.getAllDoctor(id);
    }


    @PostMapping("/savedoctors")
    public ResponseEntity<String> validater(@RequestBody String requestdoctor){

        JSONObject json=new JSONObject(requestdoctor);

        if(Dostorvalidator(json).isEmpty()){
            Doctor doctor=savedoctor(json);
            service.save(doctor);
            return new ResponseEntity("Doctor saved",HttpStatus.CREATED);
        }
        else{
            String[] answer = Arrays.copyOf(
                    Dostorvalidator(json).toArray(), Dostorvalidator(json).size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }

    }


    public List<String> Dostorvalidator(JSONObject json){

        List<String> errorlist=new ArrayList<>();
        if(!json.has("doctor_id")){
            errorlist.add("doctor_id");
        }
         if(!json.has("specialization")){
            errorlist.add("specialization");
        }
  return errorlist;
    }

    public Doctor savedoctor(JSONObject json){
        Doctor doctor=new Doctor();

        String doctor_id= json.getString("doctor_id");
        doctor.setDoctor_id(Integer.valueOf(doctor_id));

        String specialization= json.getString("specialization");
        doctor.setSpecialization(specialization);

        if(json.has("doctor_name")){
            String doctor_name=json.getString("doctor_name");
            doctor.setDoctor_name(doctor_name);
        }

     if(json.has("experience")){
         String experience= json.getString("experience");
          doctor.setExperience(Integer.valueOf(experience));
     }


        return doctor;
    }
}
