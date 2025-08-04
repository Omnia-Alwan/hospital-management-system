package view;

import Controller.employeeLogin;
import models.Database;

import java.util.Scanner;

public class EmployeeLogin {
    public EmployeeLogin(Scanner s, Database database){
        System.out.println("Welcome to our hospital management system");
        System.out.println("Enter Email:");
        String email= s.next();
        System.out.println("Enter Password");
        String password=s.next();

        Controller.PatientLogin patientLogin=new Controller.PatientLogin(password,email,database);
        employeeLogin login= new employeeLogin(email,password,database);
        if(login.isLoggedIn()){
            login.getUser().showList(s,database);
        }else if(patientLogin.isLoggedIn()){
            patientLogin.getPatient().showList(s,database);
        }else{
            System.out.println("Invalid Email or Password");
        }
    }
}
