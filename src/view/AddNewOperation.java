package view;

import Controller.CreateOperation;
import Controller.ReadPatient;
import models.*;

import java.util.Scanner;

public class AddNewOperation implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {

        Operation operation= new Operation();
        operation.setDoctor((Doctor)u);
        int id;
        do{
            System.out.println("Enter patient ID or -1 to view all patients");
            id=s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);
        operation.setPatient(new ReadPatient(id, database).getPatient());
        System.out.println("Enter date time with format("+operation.getDateTimeFormatter()+")");
        operation.setDateTime(s.next());
        s.nextLine();
        operation.setPaid(false);
        System.out.println("Enter patient diagnosis");
        operation.setDiagnosis(s.nextLine());

        System.out.println("\nDoctor\t\t"+operation.getDoctor().getName());
        System.out.println("Patient\t\t"+operation.getPatient().getName());
        System.out.println("Operation date\t\t"+operation.getDateTime());
        System.out.println("Paid\t\t"+operation.isPaid());
        System.out.println("Diagnosis\t\t"+operation.getDiagnosis());

        if(new CreateOperation(database,operation).isCreated()){
                System.out.println("operation created successfully!");
            }


    }

    @Override
    public String getName() {
        return "Add new operation";
    }
}
