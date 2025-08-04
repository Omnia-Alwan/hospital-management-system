package view;

import Controller.readPatientOperations;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientUnpaidOperations implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        ArrayList<Operation>operations= new readPatientOperations(database,u.getID()).getOperations();
        if(operations.size()>0){
            for (Operation operation : operations) {
                if (!operation.isPaid()) {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Operation ID\t\t" + operation.getID());
                    System.out.println("Doctor's name who performed the operation\t\t" + operation.getDoctor().getName());
                    System.out.println("Patient's name\t\t" + operation.getPatient().getName());
                    System.out.println("Operation diagnosis\t\t" + operation.getDiagnosis());
                    System.out.println("Has operation been paid?\t\t" + operation.isPaid());
                    System.out.println("Operation date\t\t" + operation.getDateTime());
                    System.out.println("------------------------------------------------------");
                }
            }
        }else{
            System.out.println("No scheduled operations");
        }
    }

    @Override
    public String getName() {
        return "View unpaid operations";
    }
}
