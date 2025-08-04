package Controller;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadEmployees {
    private ArrayList<Employee> employees;

    public ReadEmployees(Database database) throws SQLException {
        String select="SELECT * FROM `Employee`";
        employees = new ArrayList<>();
        ResultSet rs= database.getStatement().executeQuery(select);
        while(rs.next()){
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
                       /* @Override
                          public void showList(Scanner s, Database database) {
                            System.out.println("Invalid Job!");
                       }*/
                       @Override
                       public String getJobToString() {
                           return "invalid job title";
                       }
                        @Override
                        public int getTitle() {
                            return -1;
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
            employees.add(e);
        }
    }
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
