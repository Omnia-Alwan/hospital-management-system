package Controller;

import models.Database;
import models.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPatients {

    private ArrayList<Patient> patients=new ArrayList<>();
    //private Database database;

    public ReadPatients(Database database) {
        String readd = "SELECT * FROM `Patient`";
        try {
            ResultSet rs = database.getStatement().executeQuery(readd);
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setID(rs.getInt("ID"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setLastName(rs.getString("LastName"));
                patient.setEmail(rs.getString("Email"));
                patient.setPassword(rs.getString("Password"));
                patient.setPhoneNumber(rs.getString("Phone Number"));
                patient.setBloodGroup(rs.getString("BloodType"));
                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
