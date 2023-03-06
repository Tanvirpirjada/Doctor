package com.example.Doctor.Service;

import com.example.Doctor.Dao.IPatientRepository;
import com.example.Doctor.DoctorApplication;
import com.example.Doctor.Model.Doctor;
import com.example.Doctor.Model.Patient;
import jdk.security.jarsigner.JarSigner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepository repo;

    public void savepatient(Patient savepatient) {
         repo.save(savepatient);
    }

    public JSONArray getpatient(String patientid, String doctorId) {
        List<Patient> patients;
        JSONArray patientarray=new JSONArray();
        if(patientid==null && doctorId==null){
           patients=repo.findAll();

           for(Patient patient: patients){
               JSONObject newobject=getobject(patient);
               patientarray.put(newobject);
           }
        }
        else if(doctorId!=null ){
           patients=new ArrayList<>();
            List<Patient> newpatient=repo.findAll();
            for(Patient p: newpatient){
                if(p.getDoctor_id().getDoctor_id().equals(Integer.valueOf(doctorId))){
                    patients.add(p);
                }
            }
            for(Patient patient: patients) {
                JSONObject newobject = getobject(patient);
                patientarray.put(newobject);
            }
        }
        else if(patientid !=null) {
            patients=new ArrayList<>();
            patients.add(repo.findById(Integer.valueOf(patientid)).get());
            for(Patient patient: patients){
                JSONObject newobject=getobject(patient);
                patientarray.put(newobject);
            }

        }
        else{
            return null;
        }
        return patientarray;
    }

    public JSONObject getobject(Patient patient){
        JSONObject object=new JSONObject();


            object.put("patient_id", patient.getPatient_id());
            object.put("patient_name", patient.getPatient_name());
            object.put("age", patient.getAge());
            object.put("phone_number", patient.getPhone_number());
            object.put("diacease_type", patient.getDiacease_type());
            object.put("gender", patient.getGender());
            object.put("admit_date", patient.getAdmit_date());
            object.put("doctor_id", patient.getDoctor_id().getDoctor_id());
        return object;
    }

    public JSONArray getpatients() {
        JSONArray patientarray=new JSONArray();
        List<Patient> patients=repo.findAll();
        for(Patient patient: patients){
           JSONObject newobject=getobject(patient);
             patientarray.put(newobject);
        }
        return patientarray;
    }
}
