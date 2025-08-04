package view;

import Controller.readPatientOperations;
import Controller.readPatientReport;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientUnpaidReports implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        ArrayList<Report> reports= new readPatientReport(u.getID(),database).getReports();
        if(!reports.isEmpty()) {
            for (Report report : reports) {
                if (!report.isPaid()) {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Report ID\t\t" + report.getID());
                    System.out.println("Doctor's name\t\t" + report.getDoctor().getName());
                    System.out.println("Patient's name\t\t" + report.getPatient().getName());
                    System.out.println("Diagnosis\t\t" + report.getDiagnosis());
                    System.out.println("Treatment\t\t" + report.getTreatment());
                    System.out.println("Has operation been paid?\t\t" + report.isPaid());
                    System.out.println("Report date\t\t" + report.getDateTime());
                    System.out.println("------------------------------------------------------");
                }
            }
        }
        else {
            System.out.println("No reports submitted");
        }
    }

    @Override
    public String getName() {
        return "view unpaid reports";
    }
}
