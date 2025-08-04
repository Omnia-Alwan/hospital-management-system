package view;

import Controller.ReadPatient;
import Controller.createReciept;
import models.*;

import java.util.Scanner;

public class addNewReciept implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        Reciept reciept= new Reciept();
        reciept.setCashier((Cashier) u);
        int id;
        do {
            System.out.println("Enter patient ID or -1 to view all patients");
            id=s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);
        reciept.setPatient(new ReadPatient(id, database).getPatient());
        System.out.println("Enter the amount paid (DOUBLE)");
        reciept.setAmount(s.nextDouble());
       // s.nextLine();
        System.out.println("Enter receipt type 0.for operation 1.for report");
        reciept.setType(s.nextInt());
        int itemID;
        if(reciept.getType()==0){
            do{
                System.out.println("Enter operation ID or -1 to view all operations");
                itemID=s.nextInt();
                if(itemID<0)
                    new viewPatientUnpaidOperations().operation(s,database,new ReadPatient(id,database).getPatient());
            }while(itemID<0);
        } else{
            do {
                System.out.println("Enter report ID or -1 to view all reports");
                itemID = s.nextInt();
                if (itemID < 0)
                    new viewPatientUnpaidReports().operation(s, database, new ReadPatient(id,database).getPatient());
            }while (itemID<0);
        }
        reciept.setItemID(itemID);
        System.out.println("-----------------------------------");
        System.out.println("Receipt type\t"+ reciept.toString(reciept.getType()));
        System.out.println(reciept.toString(reciept.getType())+" ID\t"+reciept.getItemID());
        System.out.println("Patient name\t"+reciept.getPatient().getName());
        System.out.println("Cashier name\t"+reciept.getCashier().getName());
        System.out.println("Amount paid\t"+reciept.getAmount());
        System.out.println("-----------------------------------");
        if(new createReciept(reciept, database).isCreated())
            System.out.println("Receipt created successfully!!");
    }

    @Override
    public String getName() {
        return "Add new receipt";
    }
}
