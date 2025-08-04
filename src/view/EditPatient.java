package view;

import Controller.ReadPatient;
import Controller.ReadPatients;
import Controller.UpdatePatient;
import models.Database;
import models.Option;
import models.Patient;
import models.User;

import java.util.Scanner;

public class EditPatient implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        Patient patient;
        System.out.println("------------------------------------------\n");
        int ID;
        do {
            System.out.println("Enter patient ID:\n(-1 to show all patients)");
            ID = s.nextInt();
            if (ID < 0) {
                new ViewAllPatients().operation(s, database, u);
            }
        } while (ID < 0);
        patient= new ReadPatient(ID,database).getPatient();

        System.out.println("Enter new first name or -1 to pass");
        String firstName =s.next();
        if(!firstName.equals("-1")) patient.setFirstName(firstName);
        System.out.println("Enter new last name or -1 to pass");
        String lastName =s.next();
        if(!lastName.equals("-1")) patient.setLastName(lastName);
        System.out.println("Enter new Email or -1 to pass");
        String email =s.next();
        if(!email.equals("-1")) patient.setEmail(email);
        System.out.println("Enter password or -1 to pass");
        String password =s.next();
        if(!password.equals("-1")) patient.setPassword(password);
        System.out.println("Enter new phone number or -1 to pass");
        String phoneNumber =s.next();
        if(!phoneNumber.equals("-1")) patient.setPhoneNumber(phoneNumber);
        System.out.println("Enter new blood type or -1 to pass");
        String bloodType =s.next();
        if(!bloodType.equals("-1")) patient.setBloodGroup(bloodType);
        if(new UpdatePatient(patient,database).isUpdated()){
            System.out.println("Patient Updated successfully!");
        }
    }

    @Override
    public String getName() {
        return "Edit Patient info";
    }
}
