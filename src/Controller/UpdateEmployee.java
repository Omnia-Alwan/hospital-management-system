package Controller;

import models.Database;
import models.Doctor;
import models.Employee;

import java.sql.SQLException;

public class UpdateEmployee {

    private Employee employee;
    private Database database;
    public UpdateEmployee(Database database, Employee employee){
        this.employee=employee;
        this.database=database;
    }
    public boolean isUpdated(){
        boolean updated=false;
        String specialization;
        specialization=(employee.getTitle()==0)?((Doctor)employee).getSpecialization():"";
        String update="UPDATE `Employee` SET `FirstName`='"+ employee.getFirstName()+"',`LastName`='"+employee.getLastName()+"',`Email`='"+employee.getEmail()+"'," +
                "`Phone Number`='"+employee.getPhoneNumber()+"',`Salary`='"+employee.getSalary()+"',`Job`='"+employee.getTitle()+"',`Specialization`='"+specialization+"'" +
                " WHERE `ID` = "+employee.getID()+";";
        try {
            database.getStatement().execute(update);
            updated=true;
        } catch (SQLException e) {
            e.printStackTrace();
            updated=false;
        }
        return updated;
    }
}
