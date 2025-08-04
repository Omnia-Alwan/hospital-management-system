package Controller;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadEmployee {


    private Employee employee;
    public ReadEmployee(int ID, Database database){
        String select="SELECT * FROM `Employee` WHERE `ID`="+ID+"";
        try {
            ResultSet rs= database.getStatement().executeQuery(select);
            rs.next();
                Employee e;
                int job=rs.getInt("Job");
                switch (job){
                    case 0:
                        e=new Doctor();
                        ((Doctor) e).setSpecialization(rs.getString("Specialization"));
                        break;
                    case 1:
                        e= new Cashier();
                        break;
                    case 2:
                        e=new Receptionist();
                        break;
                    default:
                        e=new Employee() {
                            @Override
                            public int getTitle() {
                                return -1;
                            }

                            @Override
                            public String getJobToString() {
                                return "invalid job title";
                            }
                        };
                }
                e.setID(rs.getInt("ID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setEmail(rs.getString("Email"));
                e.setPassword(rs.getString("Password"));
                e.setPhoneNumber(rs.getString("Phone Number"));
                e.setSalary(rs.getInt("Salary"));
                this.employee=e;

        }catch (SQLException ee){
            ee.printStackTrace();
        }

    }
    public Employee getEmployee(){
        return employee;
    }
}
