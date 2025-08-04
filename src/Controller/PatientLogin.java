package Controller;

import models.Database;
import models.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientLogin {

    private Database database;
    private Patient patient;
    public String email,password;
    public PatientLogin(String p, String email, Database db){
        this.email=email;
        this.password=p;
        this.database=db;
    }
    public Patient getPatient(){
        return patient;
    }

    public boolean isLoggedIn(){
        boolean loggedIn=false;
        String select="SELECT * FROM `Patient` WHERE `Email`='"+email+"' AND " +
                "`Password`='"+password+"';";
        try {
            //System.out.println(email+" "+password);
            ResultSet rs=database.getStatement().executeQuery(select);
            loggedIn=rs.next();
            if(loggedIn){
                patient=new Patient();
                patient.setID(rs.getInt("ID"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setLastName(rs.getString("LastName"));
                patient.setEmail(rs.getString("Email"));
                patient.setPassword(rs.getString("Password"));
                patient.setPhoneNumber(rs.getString("Phone Number"));
                patient.setBloodGroup(rs.getString("BloodType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(loggedIn);
        return loggedIn;
    }


}
