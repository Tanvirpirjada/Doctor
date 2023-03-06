package com.example.Doctor.Controller;

import com.example.Doctor.Dao.IDoctorrepository;
import com.example.Doctor.Model.Doctor;
import com.example.Doctor.Model.Patient;
import com.example.Doctor.Service.PatientService;
import jakarta.annotation.Nullable;
import jakarta.persistence.Id;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class PatientController {


    @Autowired
    PatientService  newservice;

    @Autowired
    IDoctorrepository repo;

    @PostMapping("/Patient")
   public String SavePatient(@Nullable @RequestBody String PatientRequest){
        JSONObject json=new JSONObject(PatientRequest);
        newservice.savepatient(Savepatient(json));

        return "Patient save";
    }

    public Patient  Savepatient(JSONObject json){


        Patient patient=new Patient();

        Integer patient_id= json.getInt("patient_id");
        patient.setPatient_id(patient_id);

        String patient_name= json.getString("patient_name");
        patient.setPatient_name(patient_name);

        String phone_number= json.getString("phone_number");
        patient.setPhone_number(phone_number);

        Integer age= json.getInt("age");
        patient.setAge(age);

        String diecease_type=json.getString("diecease_type");
        patient.setDiacease_type(diecease_type);

        String gender= json.getString("gender");
        patient.setGender(gender);

        Timestamp admit_date=new Timestamp(System.currentTimeMillis());
        patient.setAdmit_date(admit_date);

        String  doctor_id= json.getString("doctor_id");
        Doctor doctor=repo.findById(Integer.valueOf(doctor_id)).get();
        patient.setDoctor_id(doctor);

        return patient;



    }


    @GetMapping("getpatient")
    public ResponseEntity getpatient(@Nullable @RequestParam String Patientid,@Nullable @RequestParam String doctor_id){
         JSONArray patientdetails=newservice.getpatient(Patientid,doctor_id);
        return new ResponseEntity(patientdetails.toString(),HttpStatus.OK);
    }

    @GetMapping("getpateintswithRespose")
    public ResponseEntity getpatients(){
        JSONArray prtientdetails=newservice.getpatients();
        return new ResponseEntity(prtientdetails.toString(), HttpStatus.OK);
    }
}
