package view;
import Controller.ReadPatients;
import models.Database;
import models.Option;
import models.Patient;
import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAllPatients implements Option{

    @Override
    public void operation(Scanner s, Database database, User u) {
        ArrayList<Patient> patients= new ReadPatients(database).getPatients();
        System.out.println("\n----------------------------------------------------\n");
        for( Patient p: patients){
            System.out.println("Patient ID\t\t"+p.getID());
            System.out.println("Patient first name\t\t"+p.getFirstName());
            System.out.println("Patient last name\t\t"+p.getLastName());
            System.out.println("Patient Email\t\t"+p.getEmail());
            System.out.println("Patient Password\t\t"+p.getPassword());
            System.out.println("Patient Phone number\t\t"+p.getPhoneNumber());
            System.out.println("Patient blood type\t\t"+p.getBloodGroup());
            System.out.println("----------------------------------------------------\n");
        }
    }

    @Override
    public String getName() {
        return "View all patients";
    }
}
