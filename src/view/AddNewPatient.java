package view;

import Controller.CreatePatient;
import models.Database;
import models.Option;
import models.Patient;
import models.User;

import java.util.Scanner;

public class AddNewPatient implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        Patient patient=new Patient();
        System.out.println("Enter first name");
        patient.setFirstName(s.next());
        System.out.println("Enter last name");
        patient.setLastName(s.next());
        System.out.println("Enter email");
        patient.setEmail(s.next());
        System.out.println("Enter password");
        String password=s.next();
        String ConfirmPassword;
        do{
            System.out.println("Confirm password");
            ConfirmPassword=s.next();
        }while(!password.equals(ConfirmPassword));
        patient.setPassword(password);
        System.out.println("Enter phone number");
        patient.setPhoneNumber(s.next());
        System.out.println("Enter blood group");
        patient.setBloodGroup(s.next());

        if(new CreatePatient(patient,database).isCreated()){
            System.out.println("patient added successfully!");
        }
    }

    @Override
    public String getName() {
        return "Add new patient";
    }
}
