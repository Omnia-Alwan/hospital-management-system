package view;

import Controller.ReadEmployee;
import models.*;

import java.util.Scanner;

public class UpdateEmployee implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        int ID;
        do {
            System.out.println("Enter employee ID:\n(-1 to show all employees)");
            ID = s.nextInt();
            if (ID < 0) {
                new ViewEmployees().operation(s, database, u);
            }
        } while (ID < 0);
        Employee e=new ReadEmployee(ID,database).getEmployee();
        System.out.println("Enter first name (-1 to keep existing value)");
        String firstName=s.next();
        if(!firstName.equals(("-1")))
            e.setFirstName(firstName);

        System.out.println("Enter last name (-1 to keep existing value)");
        String lastName=s.next();
        if(!lastName.equals(("-1")))
            e.setLastName(lastName);

        System.out.println("Enter Email (-1 to keep existing value)");
        String email=s.next();
        if(!email.equals(("-1")))
            e.setEmail(email);

        System.out.println("Enter phone number (-1 to keep existing value)");
        String phoneNumber=s.next();
        if(!phoneNumber.equals(("-1")))
            e.setPhoneNumber(phoneNumber);

        System.out.println("Enter salary (-1 to keep existing value)");
        int salary=s.nextInt();
        if(salary!=-1)
            e.setSalary(salary);

        if(e.getTitle()==0){
            System.out.println("Enter specialization (-1 to keep existing value)");
            String specialization=s.next();
            if(!specialization.equals(("-1")))
                ((Doctor)e).setSpecialization(specialization);
        }

        System.out.println("Enter new job (-1 to keep existing value)\n0. Doctor\n1. Cashier\n2. Receptionist:\n");
        int job=s.nextInt();
        switch(job){
            case 0:
                System.out.println("Enter specialization");
                String spec=s.next();
                Employee d=new Doctor();
                d.setID(e.getID());
                d.setFirstName(e.getFirstName());
                d.setLastName(e.getLastName());
                d.setEmail(e.getEmail());
                d.setPassword(e.getPassword());
                d.setSalary(e.getSalary());
                d.setPhoneNumber(e.getPhoneNumber());
                ((Doctor)d).setSpecialization(spec);
                e=d;
                break;
            case 1:
                Employee c= new Cashier();
                c.setID(e.getID());
                c.setFirstName(e.getFirstName());
                c.setLastName(e.getLastName());
                c.setEmail(e.getEmail());
                c.setPassword(e.getPassword());
                c.setSalary(e.getSalary());
                c.setPhoneNumber(e.getPhoneNumber());
                e=c;
                break;
            case 2:
                Employee r=new Receptionist();
                r.setID(e.getID());
                r.setFirstName(e.getFirstName());
                r.setLastName(e.getLastName());
                r.setPhoneNumber(e.getPhoneNumber());
                r.setEmail(e.getEmail());
                r.setPassword(e.getPassword());
                r.setSalary(e.getSalary());
                e=r;
                break;
            case -1:
                break;
            default:
                System.out.println("invalid job title");
                break;
        }
        if(new Controller.UpdateEmployee(database,e).isUpdated()){
            System.out.println("Employee has been updated successfully!!");
        }
    }

    @Override
    public String getName() {
        return "Update employee";
    }
}
