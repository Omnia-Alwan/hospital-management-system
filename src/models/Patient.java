package models;

import view.*;

import java.util.ArrayList;

public class Patient extends User{
    private String bloodGroup;
    private ArrayList<Operation> operations;
    private ArrayList<Report> reports;
    private ArrayList<Operation> unpaidOperations;
    private ArrayList<Report> unpaidReports;

    public Patient(){
        super();
        this.Options= new Option[]{
                new ChangePatientPassword(),
                new ViewPatientUserData(),
                new viewPatientUserOperations(),
                new viewPatientUserReport(),
                new viewPatientUnpaidReports(),
                new viewPatientUnpaidOperations(),
                new viewPatientReciepts()
        };
    }



    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ArrayList<Operation> getUnpaidOperations() {
        return unpaidOperations;
    }

    public void setUnpaidOperations(ArrayList<Operation> unpaidOperations) {
        this.unpaidOperations = unpaidOperations;
    }

    public ArrayList<Report> getUnpaidReports() {
        return unpaidReports;
    }

    public void setUnpaidReports(ArrayList<Report> unpaidReports) {
        this.unpaidReports = unpaidReports;
    }
}
