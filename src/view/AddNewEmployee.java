package view;

import Controller.CreateEmployee;
import models.*;

import java.util.Scanner;

public class AddNewEmployee implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        System.out.println("Enter first name:");
        String fisrtName=s.next();
        System.out.println("Enter last name:");
        String lasttName=s.next();
        System.out.println("Enter Email:");
        String email=s.next();
        System.out.println("Enter password");
        String password=s.next();
        String ConfirmPassword;
        do{
            System.out.println("Confirm password");
            ConfirmPassword=s.next();
        }while(!password.equals(ConfirmPassword));
        System.out.println("Enter phone number:");
        String phoneNumber=s.next();
        System.out.println("Enter salary:");
        int salary=s.nextInt();
        int job;
        do{
            System.out.println("Enter job title:\n0. Doctor\n1. Cashier\n2. Receptionist");
            job=s.nextInt();
        }while (job!=2 && job!=1 &&job!=0);
        String specialization="";
        if(job == 0){
            System.out.println("Enter your specialization");
            specialization=s.next();
        }
        //create employee
        Employee employee;
        switch(job){
            case 0:
                employee=new Doctor();
                employee.setFirstName(fisrtName);
                employee.setLastName(lasttName);
                employee.setEmail(email);
                employee.setPassword(password);
                employee.setSalary(salary);
                employee.setPhoneNumber(phoneNumber);
                ((Doctor) employee).setSpecialization(specialization);
                break;
            case 1:
                employee=new Cashier();
                employee.setFirstName(fisrtName);
                employee.setLastName(lasttName);
                employee.setEmail(email);
                employee.setPassword(password);
                employee.setSalary(salary);
                employee.setPhoneNumber(phoneNumber);
                break;
            case 2:
                employee=new Receptionist();
                employee.setFirstName(fisrtName);
                employee.setLastName(lasttName);
                employee.setEmail(email);
                employee.setPassword(password);
                employee.setSalary(salary);
                employee.setPhoneNumber(phoneNumber);
                break;
            default:
                employee= new Employee() {
                    @Override
                    public void showList(Scanner s, Database database) {
                        System.out.println("Invalid Job!");
                    }
                    @Override
                    public String getJobToString() {
                        return "invalid job title";
                    }
                    @Override
                    public int getTitle() {
                        return -1;
                    }
                };
        }
        //**********

        if(new CreateEmployee(employee, database).isCreated()){
            System.out.println("Employee added successfully");
        }
    }

    @Override
    public String getName() {
        return "Add new Employee";
    }
}
