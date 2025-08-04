package view;

import Controller.readPatientOperations;
import Controller.readPatientReport;
import models.Database;
import models.Operation;
import models.Option;
import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientUserOperations implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        ArrayList<Operation> operations=new readPatientOperations(database,u.getID()).getOperations();
        if(operations.size()>0) {
            for (Operation operation : operations) {
                System.out.println("------------------------------------------------------");
                System.out.println("Operation ID\t\t" + operation.getID());
                System.out.println("Doctor's name who performed the operation\t\t" + operation.getDoctor().getName());
                System.out.println("Patient's name\t\t" + operation.getPatient().getName());
                System.out.println("Operation diagnosis\t\t" + operation.getDiagnosis());
                System.out.println("Has operation been paid?\t\t" + operation.isPaid());
                System.out.println("Operation date\t\t" + operation.getDateTime());
                System.out.println("------------------------------------------------------");
            }
        }else{
            System.out.println("No operations scheduled for you");
        }
    }

    @Override
    public String getName() {
        return "View my operations";
    }
}
