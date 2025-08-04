package models;

import java.time.format.DateTimeFormatter;

public class Operation {
    private int ID;
    private Doctor doctor;
    private Patient patient;
    private boolean paid;
    private String dateTime;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm:ss");
    private String diagnosis;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String localDate) {
        this.dateTime=localDate;
    }

    public String getDateTimeFormatter() {
        return "MM/dd/yyyy-HH:mm:ss";
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
