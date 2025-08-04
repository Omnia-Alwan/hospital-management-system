package Controller;

import models.Database;
import models.Patient;

import java.sql.SQLException;

public class UpdatePatient {

    private Patient patient;
    private Database database;

    public UpdatePatient(Patient p,Database db){
        this.database=db;
        this.patient=p;
    }

    public boolean isUpdated(){
        boolean updated=false;
        String update="UPDATE `Patient` SET `FirstName`='"+patient.getFirstName()+"',`LastName`='"+patient.getLastName()+"'," +
                "`Email`='"+patient.getEmail()+"',`Password`='"+patient.getPassword()+"',`Phone Number`='"+patient.getPhoneNumber()+"'," +
                "`BloodType`='"+patient.getBloodGroup()+"' WHERE `ID`= '"+patient.getID()+"' ;";
        try {
            database.getStatement().execute(update);
            updated=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
