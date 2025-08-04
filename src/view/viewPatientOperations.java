package view;

import Controller.readPatientOperations;
import models.Database;
import models.Operation;
import models.Option;
import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientOperations implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        int id;
        do {
            System.out.println("Enter patient's ID or -1 to view all patients");
            id=s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);

        ArrayList<Operation>operations= new readPatientOperations(database,id).getOperations();
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
            System.out.println("Patient has no scheduled operations");
        }

    }

    @Override
    public String getName() {
        return "View patient's operations";
    }
}
