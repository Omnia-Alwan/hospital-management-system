package Controller;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class employeeLogin {
    private String email,password;
    private Database db;
    private User u;
    public employeeLogin(String email, String password, Database db){
        this.email=email;
        this.password=password;
        this.db=db;
    }
    public boolean isLoggedIn(){
        boolean LoggedIn=false;
        String select="SELECT * FROM `Employee` WHERE `Email`='"+email+"' AND `Password`='"+password+"'";
        try {
            ResultSet rs=db.getStatement().executeQuery(select);
            LoggedIn= rs.next();
            if(LoggedIn){
                int job= rs.getInt("Job");
                switch (job){
                    case 0:
                        u=new Doctor();
                        ((Doctor) u).setSpecialization(rs.getString("Specialization"));
                        break;
                    case 1:
                        u= new Cashier();
                        break;
                    case 2:
                        u=new Receptionist();
                        break;
                    default:
                        u=new User() {
                            @Override
                            public void showList(Scanner s, Database database) {
                                System.out.println("Invalid Job");
                            }
                        };
                }
                u.setID(rs.getInt("ID"));
                u.setFirstName(rs.getString("FirstName"));
                u.setLastName(rs.getString("LastName"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                u.setPhoneNumber(rs.getString("Phone Number"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LoggedIn;
    }
    public User getUser(){
        return u;
    }
}
