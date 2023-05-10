package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false, columnDefinition = "DATE")
    private Date birthDate;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "personal_numeric_code", unique = true, nullable = false)
    private String personalNumericCode;

    @Column(name = "id_series_and_number", nullable = false)
    private String idSeriesAndNumber;

    @ManyToOne
    @JoinColumn(name = "type_of_insurance_id")
    private InsuranceStatus typeOfInsurance;

    @ManyToOne
    @JoinColumn(name = "insurance_status_id")
    private InsuranceStatus insuranceStatus;

    @ManyToOne
    @JoinColumn(name = "type_of_admission_id")
    private AdmissionType admissionType;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @OneToOne
    @JoinColumn(name = "surgery_details_id")
    private PatientSurgeryDetails surgeryDetails;


    @OneToOne
    @JoinColumn(name = "history_details_id")
    private PatientHistoryDetails patientHistoryDetails;

    @OneToMany
    @JoinColumn(name = "evolution_id")
    private List<PatientEvolution> evolution = new ArrayList<>();

    @Column(name = "admission_date", nullable = false, columnDefinition = "DATE")
    private Date admissionDate;

    public void addEvolution(PatientEvolution patientEvolution) {
        evolution.add(patientEvolution);
    }

    public Patient() {
    }

    public Patient(String firstName,
                   String lastName,
                   Date birthDate,
                   String address,
                   String personalNumericCode,
                   String idSeriesAndNumber,
                   Date admissionDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.personalNumericCode = personalNumericCode;
        this.idSeriesAndNumber = idSeriesAndNumber;
        this.admissionDate = admissionDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
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

    public String getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(String personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public String getIdSeriesAndNumber() {
        return idSeriesAndNumber;
    }

    public void setIdSeriesAndNumber(String idSeriesAndNumber) {
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
