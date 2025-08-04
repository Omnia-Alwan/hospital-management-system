package Controller;

import models.Database;
import models.Doctor;
import models.Employee;

import java.sql.SQLException;

public class CreateEmployee {
    private Employee e;
    private Database database;
    public CreateEmployee(Employee e, Database database){
        this.e=e;
        this.database=database;
    }
    public boolean isCreated(){
        boolean created= false;
        String specialization;
        specialization=(e.getTitle()==0)?((Doctor)e).getSpecialization():"";
        String insert="INSERT INTO `Employee`( `FirstName`, `LastName`, `Email`, `Password`, `Phone Number`, `Salary`, `Job`, `Specialization`) " +
                "VALUES ('"+e.getFirstName()+"','"+e.getLastName()+"','"+e.getEmail()+"','"+e.getPassword()+"','"+e.getPhoneNumber()+"'," +
                "'"+e.getSalary()+"','"+e.getTitle()+"','"+specialization+"')";

        try{
            database.getStatement().execute(insert);
            created=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            created=false;
        }
        return created;
    }
}
