package view;

import models.Database;
import models.Option;
import models.Patient;
import models.User;

import java.util.Scanner;

public class ViewPatientUserData implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {

        System.out.println("----------------------------------------------------\n");
        System.out.println("Patient ID\t\t"+u.getID());
        System.out.println("Patient first name\t\t"+u.getFirstName());
        System.out.println("Patient last name\t\t"+u.getLastName());
        System.out.println("Patient Email\t\t"+u.getEmail());
        System.out.println("Patient Password\t\t"+u.getPassword());
        System.out.println("Patient Phone number\t\t"+u.getPhoneNumber());
        System.out.println("Patient blood type\t\t"+((Patient)u).getBloodGroup());
        System.out.println("----------------------------------------------------\n");
    }

    @Override
    public String getName() {
        return "View My info";
    }
}
