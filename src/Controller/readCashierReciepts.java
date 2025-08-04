package Controller;

import models.Cashier;
import models.Database;
import models.Reciept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class readCashierReciepts {
    private ArrayList<Reciept> reciepts= new ArrayList<>();
    public readCashierReciepts(Database database, Cashier cashier){
        String select="SELECT * FROM `Reciept` WHERE `cashier`='"+cashier.getID()+"'";
        try {
            ResultSet rs=database.getStatement().executeQuery(select);
            while (rs.next()) {
                Reciept reciept = new Reciept();
                reciept.setID(rs.getInt("ID"));
                reciept.setCashier((Cashier) new ReadEmployee(rs.getInt("cashier"), database).getEmployee());
                reciept.setPatient( new ReadPatient(rs.getInt("patient"), database).getPatient());
                reciept.setType(rs.getInt("type"));
                reciept.setAmount(rs.getDouble("amount"));
                reciept.setItemID(rs.getInt("itemID"));
                reciepts.add(reciept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Reciept> getReciepts(){
        return reciepts;
    }
}
