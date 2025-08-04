package Controller;

import models.Database;
import models.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPatient {
    private Patient patient;

    public ReadPatient(int ID,Database db){
        String select="SELECT * FROM `Patient` WHERE `ID`= '"+ID+"';";
        try {
            ResultSet rs=db.getStatement().executeQuery(select);
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setID(rs.getInt("ID"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setLastName(rs.getString("LastName"));
                patient.setEmail(rs.getString("Email"));
                patient.setPassword(rs.getString("Password"));
                patient.setPhoneNumber(rs.getString("Phone Number"));
                patient.setBloodGroup(rs.getString("BloodType"));
                this.patient = patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatient(){
        return this.patient;
    }
}
