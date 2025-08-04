package view;

import Controller.ReadPatient;
import Controller.readPatientReciepts;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class viewPatientReciepts implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {

        ArrayList<Reciept> reciepts= new readPatientReciepts(database,(Patient) u).getReciepts();
        if(reciepts.size()>0){
            for (Reciept reciept : reciepts) {
                System.out.println("-----------------------------------");
                System.out.println("Receipt ID\t"+reciept.getID());
                System.out.println("Receipt type\t" + reciept.toString(reciept.getType()));
                System.out.println(reciept.toString(reciept.getType()) + " ID\t" + reciept.getItemID());
                System.out.println("Patient name\t" + reciept.getPatient().getName());
                System.out.println("Cashier name\t" + reciept.getCashier().getName());
                System.out.println("Amount paid\t" + reciept.getAmount());
                System.out.println("-----------------------------------");
            }
        }else {
            System.out.println("No receipts so far");
        }
    }

    @Override
    public String getName() {
        return "View patient receipts";
    }
}
