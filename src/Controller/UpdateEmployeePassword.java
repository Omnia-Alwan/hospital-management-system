package Controller;

import models.Database;
import models.Employee;

import java.sql.SQLException;

public class UpdateEmployeePassword {

    private Employee employee;
    private Database database;
    public UpdateEmployeePassword(Employee e, Database database){
        this.employee=e;
        this.database=database;
    }
    public boolean isUpdated(){
        boolean updated = false;
        String update="UPDATE `Employee` SET `Password`='"+employee.getPassword()+"' " +
                "WHERE `ID` = "+employee.getID()+";";
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
