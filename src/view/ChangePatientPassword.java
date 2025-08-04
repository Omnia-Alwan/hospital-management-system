package view;

import Controller.ReadPatient;
import Controller.UpdatePatientPassword;
import models.Database;
import models.Option;
import models.Patient;
import models.User;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class ChangePatientPassword implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {

        String oldPassword;
        do{
            System.out.println("Enter old patient password");
            oldPassword= s.next();
        }while(!oldPassword.equals(u.getPassword()));
        System.out.println("Enter new patient password");
        String newPassword=s.next();
        String confirmPassword;
        do{
            System.out.println("confirm patient new password");
            confirmPassword= s.next();
        }while(!newPassword.equals(confirmPassword));
        u.setPassword(newPassword);
        if(new Controller.UpdatePatientPassword((Patient) u, database).isUpdated())
            System.out.println("Password Updated Successfully!");
    }


    @Override
    public String getName() {
        return "Change patient password";
    }
}
