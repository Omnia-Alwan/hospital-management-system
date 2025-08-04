package Controller;

import models.Database;
import models.Patient;

import java.sql.SQLException;

public class UpdatePatientPassword {

    private Patient patient;
    private Database database;

    public UpdatePatientPassword(Patient p, Database db){
        this.database=db;
        this.patient=p;
    }

    public boolean isUpdated(){
        boolean updated=false;
        String update="UPDATE `Patient` SET `Password`='"+patient.getPassword()+"' " +
                "WHERE `ID`= '"+patient.getID()+"';";
        try {
            database.getStatement().execute(update);
            updated=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
