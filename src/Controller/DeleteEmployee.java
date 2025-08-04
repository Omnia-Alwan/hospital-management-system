package Controller;

import models.Database;

import java.sql.SQLException;

public class DeleteEmployee {

    private int ID;
    private Database database;

    public DeleteEmployee(int ID, Database database) {
        this.database=database;
        this.ID=ID;
    }

    public boolean isDeleted() {
        boolean deleted=false;
        String delete="DELETE FROM `Employee` WHERE `ID`= '"+ID+"';";
        try {
            database.getStatement().execute(delete);
            deleted=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
