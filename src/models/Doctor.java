package models;


import view.*;

public class Doctor extends Employee {

    private String specialization;

    public Doctor(){
        super();
        this.Options = new Option[]{
                new UpdateEmployeePassword(),
                new AddNewOperation(),
                new viewPatientOperations(),
                new viewPatientReport(),
                new viewDoctorReports(),
                new viewDoctorOperations(),
                new AddNewReport()

        };
    }



    @Override
    public int getTitle() {
        return 0;
    }

    @Override
    public String getJobToString() {
        return "Doctor";
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
