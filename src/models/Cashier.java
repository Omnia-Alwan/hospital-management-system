package models;

import view.*;


public class Cashier extends Employee {

    public Cashier(){
        super();
        this.Options = new Option[]{
                new UpdateEmployeePassword(),
                new ViewEmployees(),
                new ViewAllPatients(),
                new addNewReciept(),
                new viewAllReciepts(),
                new viewMyReciepts()
        };
    }



    @Override
    public int getTitle() {
        return 1;
    }

    @Override
    public String getJobToString() {
        return "Cashier";
    }
}
