package view;

import Controller.CreateReport;
import Controller.ReadPatient;
import models.*;

import java.util.Scanner;

public class AddNewReport implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        Report report= new Report();
        report.setDoctor((Doctor) u);
        int id;
        do{
            System.out.println("Enter patient ID or -1 to view all patients");
            id=s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);
        report.setPatient(new ReadPatient(id,database).getPatient());
        report.setPaid(false);
        System.out.println("Enter report date in format "+report.getDateTimeFormatter());
        String date=s.next();
        report.setDateTime(date);
        s.nextLine();
        System.out.println("Enter patient treatment");
        String treatment=s.nextLine();
        report.setTreatment(treatment);
        System.out.println("Enter patient diagnosis");
        String diagnosis=s.nextLine();
        report.setDiagnosis(diagnosis);

        System.out.println("Report Details");
        System.out.println("\nDoctor\t\t"+report.getDoctor().getName());
        System.out.println("Patient\t\t"+report.getPatient().getName());
        System.out.println("Operation date\t\t"+report.getDateTime());
        System.out.println("Paid\t\t"+report.isPaid());
        System.out.println("Diagnosis\t\t"+report.getDiagnosis());
        System.out.println("Treatment\t\t"+report.getTreatment());

        if(new CreateReport(database,report).isCreated()){
            System.out.println("Report created successfully!");
        }
    }

    @Override
    public String getName() {
        return "Add new report";
    }
}
