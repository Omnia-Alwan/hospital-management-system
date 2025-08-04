package view;

import Controller.readPatientReport;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientReport implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        int id;
        do {
            System.out.println("Enter patient id or -1 to view all patients");
            id=s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);
        ArrayList<Report> reports= new readPatientReport(id,database).getReports();
        if(reports.size()>0) {
            for (Report report : reports) {
                System.out.println("------------------------------------------------------");
                System.out.println("Report ID\t\t" + report.getID());
                System.out.println("Doctor's name\t\t" + report.getDoctor().getName());
                System.out.println("Patient's name\t\t" + report.getPatient().getName());
                System.out.println("Diagnosis\t\t" + report.getDiagnosis());
                System.out.println("Treatment\t\t"+ report.getTreatment());
                System.out.println("Has report been paid?\t\t" + report.isPaid());
                System.out.println("Report date\t\t" + report.getDateTime());
                System.out.println("------------------------------------------------------");
            }
        }else{
            System.out.println("Patient has no reports");
        }


    }

    @Override
    public String getName() {
        return "View patient reports";
    }
}
