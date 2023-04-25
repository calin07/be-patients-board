package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient_History_Details")
public class PatientHistoryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "heredo_collateral_antecedents",length = 50)
    private String heredoCollateralAntecedents;

    @Column(name="living_conditions",length = 50)
    private String livingConditions;

    @Column(name="behaviors",length = 50)
    private String behaviors;

    @Column(name="background_medication",length = 50)
    private String backgroundMedication;

    @Column(name="disease_history",length = 50)
    private String diseaseHistory;

    @Column(name="general_clinical_examination",length = 50)
    private String generalClinicalExamination;


    public PatientHistoryDetails() {
    }

    public PatientHistoryDetails(String heredoCollateralAntecedents, String livingConditions, String behaviors, String backgroundMedication, String diseaseHistory, String generalClinicalExamination) {
        this.heredoCollateralAntecedents = heredoCollateralAntecedents;
        this.livingConditions = livingConditions;
        this.behaviors = behaviors;
        this.backgroundMedication = backgroundMedication;
        this.diseaseHistory = diseaseHistory;
        this.generalClinicalExamination = generalClinicalExamination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeredoCollateralAntecedents() {
        return heredoCollateralAntecedents;
    }

    public void setHeredoCollateralAntecedents(String heredoCollateralAntecedents) {
        this.heredoCollateralAntecedents = heredoCollateralAntecedents;
    }

    public String getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(String livingConditions) {
        this.livingConditions = livingConditions;
    }

    public String getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(String behaviors) {
        this.behaviors = behaviors;
    }

    public String getBackgroundMedication() {
        return backgroundMedication;
    }

    public void setBackgroundMedication(String backgroundMedication) {
        this.backgroundMedication = backgroundMedication;
    }

    public String getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public String getGeneralClinicalExamination() {
        return generalClinicalExamination;
    }

    public void setGeneralClinicalExamination(String generalClinicalExamination) {
        this.generalClinicalExamination = generalClinicalExamination;
    }
}
