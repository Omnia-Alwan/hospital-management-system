package view;

import Controller.ReadEmployees;
import models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewEmployees implements Option {

    @Override
    public void operation(Scanner s, Database database, User u) {
        try {
            ArrayList<Employee>employees= new ReadEmployees(database).getEmployees();
            System.out.println("----------------------------------------------------");
            for(Employee e:employees){
                System.out.println("ID:\t\t"+e.getID());
                System.out.println("First:\t\t"+e.getFirstName()+" "+e.getLastName());
                System.out.println("Email:\t\t"+e.getEmail());
                System.out.println("Password\t\t"+e.getPassword());
                System.out.println("Phone Number:\t\t"+e.getPhoneNumber());
                System.out.println("Salary:\t\t"+e.getSalary()+"$");
                if(e.getTitle()==0){
                    System.out.println("Specialization:\t\t"+((Doctor)e).getSpecialization());
                }
                System.out.println("----------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "View all employees";
    }
}
