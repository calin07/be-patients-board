package com.example.demo.entity;

import com.example.demo.model.Speciality;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName", length = 50,nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50,nullable = false)
    private String lastName;

    @Column(name = "birthDate",nullable = false)
    private Date birthDate;

    @Column(name = "address", length = 50,nullable = false)
    private String address;

    @Column(name = "personalNumericCode", unique = true,nullable = false)
    private double personalNumericCode;

    @Column(name = "idSeriesAndNumber",nullable = false)
    private double idSeriesAndNumber;

    @ManyToOne
    @JoinColumn(name = "typeOfInsuranceId")
    private InsuranceStatus typeOfInsurance;

    @ManyToOne
    @JoinColumn(name = "insuranceStatusId")
    private InsuranceStatus insuranceStatus;

    @ManyToOne
    @JoinColumn(name = "typeOfAdmissionId")
    private AdmissionType admissionType;

    @ManyToOne
    @JoinColumn(name = "specialityId")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @OneToOne
    @JoinColumn(name = "diagnosisId")
    private Diagnosis diagnosis;

    @OneToOne
    @JoinColumn(name = "surgeryDetailsId")
    private PatientSurgeryDetails surgeryDetails;


    @OneToOne
    @JoinColumn(name = "historyDetailsId")
    private PatientHistoryDetails patientHistoryDetails;

    @OneToMany
    @JoinColumn(name = "evolutionId")
    private List<PatientEvolution> evolution = new ArrayList<>();

    public void addEvolution(PatientEvolution patientEvolution){
        evolution.add(patientEvolution);
    }

    public Patient() {
    }

    public Patient(String firstName, String lastName, Date birthDate, String address, double personalNumericCode, double idSeriesAndNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.personalNumericCode = personalNumericCode;
        this.idSeriesAndNumber = idSeriesAndNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(double personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public double getIdSeriesAndNumber() {
        return idSeriesAndNumber;
    }

    public void setIdSeriesAndNumber(double idSeriesAndNumber) {
        this.idSeriesAndNumber = idSeriesAndNumber;
    }

    public InsuranceStatus getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(InsuranceStatus typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public InsuranceStatus getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public AdmissionType getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(AdmissionType admissionType) {
        this.admissionType = admissionType;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public PatientSurgeryDetails getSurgeryDetails() {
        return surgeryDetails;
    }

    public void setSurgeryDetails(PatientSurgeryDetails surgeryDetails) {
        this.surgeryDetails = surgeryDetails;
    }

    public PatientHistoryDetails getPatientHistoryDetails() {
        return patientHistoryDetails;
    }

    public void setPatientHistoryDetails(PatientHistoryDetails patientHistoryDetails) {
        this.patientHistoryDetails = patientHistoryDetails;
    }

    public List<PatientEvolution> getEvolution() {
        return evolution;
    }

    public void setEvolution(List<PatientEvolution> evolution) {
        this.evolution = evolution;
    }
}
