package com.example.medicationreminder.models;

public class Notification {

    private int id;                    // ID notifikasi
    private String medicationName;      // Nama obat
    private String notificationTime;    // Waktu notifikasi
    private boolean isNotified;         // Status apakah notifikasi sudah ditampilkan

    // Constructor
    public Notification(int id, String medicationName, String notificationTime, boolean isNotified) {
        this.id = id;
        this.medicationName = medicationName;
        this.notificationTime = notificationTime;
        this.isNotified = isNotified;
    }

    // Getter dan Setter untuk id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk medicationName
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    // Getter dan Setter untuk notificationTime
    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    // Getter dan Setter untuk isNotified
    public boolean isNotified() {
        return isNotified;
    }

    public void setNotified(boolean notified) {
        isNotified = notified;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", medicationName='" + medicationName + '\'' +
                ", notificationTime='" + notificationTime + '\'' +
                ", isNotified=" + isNotified +
                '}';
    }
}
