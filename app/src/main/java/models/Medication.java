package com.example.medicationreminder.models;

public class Medication {

    private String medicationName;  // Nama obat
    private String dose;            // Dosis obat
    private String time;            // Waktu pengingat untuk obat

    // Constructor
    public Medication(String medicationName, String dose, String time) {
        this.medicationName = medicationName;
        this.dose = dose;
        this.time = time;
    }

    // Getter dan Setter untuk medicationName
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    // Getter dan Setter untuk dose
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    // Getter dan Setter untuk time
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationName='" + medicationName + '\'' +
                ", dose='" + dose + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
