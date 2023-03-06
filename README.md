# Doctor

This is a java and springboot doctor Booking project. In this  project we simply create Doctor save The doctor.. And also we create patients Which Map with doctor(Many to One) And assign patient to doctor.


# Flow of data

* Cotroller

Request made from postman or host in come in controller layer and based on annotation and endpoints the methods of cotroller are called. From Cotroleer service layer methods are called.

* service
In service layer we simply write our buisness logic. Inservice layer mathod we use JPA repositoies inbuild methods for sav e and get doctor and patients.

* Repository

Repository interface is exctends JPS repository which methods we use in service layer.

# Datastructur and database used in project
 * List
 * H2 database
 
 # Request Methods (Request urls with end points)
 
 
 Create Doctor-> http://localhost:8080/Doctor/savedoctors
 
 
 Get Doctor->  http://localhost:8080/Doctor/getdoctor  requestparam id, nullable


Create patient-> http://localhost:8080/Doctor/savepatient


 get patient-> http://localhost:8080/Doctor/getpatient request params->patient_id,doctor_id @Nulaable
