package Controller;

import models.Database;
import models.Operation;

import java.sql.SQLException;

public class CreateOperation {
    private Operation operation;
    private Database database;

    public CreateOperation(Database db, Operation op){
        this.database=db;
        this.operation=op;
    }

    public boolean isCreated(){
        boolean created=false;
        String create="INSERT INTO `Operation`(`doctor`, `patient`, `paid`, `diagnosis`, `dateTime`) " +
                "VALUES ('"+ operation.getDoctor().getID()+"','"+operation.getPatient().getID()+"','"+operation.isPaid()+"'" +
                ",'"+operation.getDiagnosis()+"','"+operation.getDateTime()+"')";
        try {
            database.getStatement().execute(create);
            created=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
