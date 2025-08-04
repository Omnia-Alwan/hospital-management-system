package Controller;

import models.Database;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class DeletePatient {
    private int ID;
    private Database database;
    public DeletePatient(int id, Database database){
        this.ID=id;
        this.database=database;
    }

    public boolean isDeleted(){
        boolean deleted=false;
        String delete="DELETE FROM `Patient` WHERE `ID`= '"+this.ID+"';";
        try {
            database.getStatement().execute(delete);
            deleted=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
