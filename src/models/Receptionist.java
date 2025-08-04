package models;


import view.*;

public class Receptionist extends Employee {

    public Receptionist(){
        super();
        this.Options = new Option[]{
                new AddNewEmployee(),
                new ViewEmployees(),
                new UpdateEmployee(),
                new UpdateEmployeePassword(),
                new FireEmployee(),
                new AddNewPatient(),
                new ViewAllPatients(),
                new EditPatient(),
                new ReleasePatient()
        };
    }


    @Override
    public int getTitle() {
        return 2;
    }

    @Override
    public String getJobToString() {
        return "Receptionist";
    }
}
