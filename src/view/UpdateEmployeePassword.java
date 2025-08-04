package view;

import models.Database;
import models.Employee;
import models.Option;
import models.User;

import java.util.Scanner;

public class UpdateEmployeePassword implements Option {

    @Override
    public void operation(Scanner s, Database database, User u) {
        String oldPassword;
        do {
            System.out.println("Enter old password");
            oldPassword = s.next();
        }while(!oldPassword.equals(u.getPassword()));
        System.out.println("Enter new password");
        String newPassword=s.next();
        String confirmPassword;
        do {
            System.out.println("confirm new passwrod");
            confirmPassword=s.next();
        }while(!confirmPassword.equals(newPassword));
        u.setPassword(newPassword);
        u.setPassword(newPassword);
        if(new Controller.UpdateEmployeePassword(((Employee)u),database).isUpdated()){
            System.out.println("Password changed successfully >w<!");
        }
    }

    @Override
    public String getName() {
        return "Change password";
    }
}
