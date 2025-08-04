package Controller;

import models.Database;
import models.Reciept;

import java.sql.SQLException;

public class createReciept {

    private Reciept reciept;
    private Database database;
    public createReciept(Reciept r, Database db){
        this.reciept=r;
        this.database=db;
    }

    public boolean isCreated(){
        boolean created=false;
        String insert="INSERT INTO `Reciept`(`cashier`, `patient`, `amount`, `type`, `itemID`) " +
                "VALUES ('"+reciept.getCashier().getID()+"','"+reciept.getPatient().getID()+"'," +
                "'"+reciept.getAmount()+"','"+reciept.getType()+"','"+reciept.getItemID()+"')";
        String update="";
        if(reciept.getType()==0){//operation
            update="UPDATE `Operation` SET `paid`='true' WHERE `ID`='"+reciept.getItemID()+"' ;";
        }else if(reciept.getType()==1){//report
            update="UPDATE `Report` SET `paid`='true' WHERE `ID`='"+reciept.getItemID()+"' ;";
        }
        try {
            database.getStatement().execute(insert);
            database.getStatement().execute(update);
            created=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
