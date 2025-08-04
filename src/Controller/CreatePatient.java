package Controller;

import models.Database;
import models.Patient;

import java.sql.SQLException;

public class CreatePatient {

    private Patient patient;
    private Database database;
    public CreatePatient(Patient p,Database db){
        this.patient=p;
        this.database=db;
    }

    public boolean isCreated(){
        boolean created=false;
        String insert="INSERT INTO `Patient`(`FirstName`, `LastName`, `Email`, `Password`, `Phone Number`, `BloodType`) VALUES " +
                "('"+patient.getFirstName()+"','"+patient.getLastName()+"','"+patient.getEmail()+"'," +
                "'"+patient.getPassword()+"','"+patient.getPhoneNumber()+"','"+patient.getBloodGroup()+"')";
        try {
            database.getStatement().execute(insert);
            created=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
