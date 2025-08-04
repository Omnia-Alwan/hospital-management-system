package Controller;

import models.Database;
import models.Doctor;
import models.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class readDoctorOperations {
    private ArrayList<Operation>operations= new ArrayList<>();
    public readDoctorOperations(Doctor d, Database database){
        String select="SELECT * FROM `Operation` WHERE `doctor`= '"+d.getID()+"';";
        try {
            ResultSet rs=database.getStatement().executeQuery(select);

            while(rs.next()){
                Operation operation= new Operation();
                operation.setID(rs.getInt("ID"));
                operation.setPatient(new ReadPatient(rs.getInt("patient"),database).getPatient());
                operation.setDoctor((Doctor) new ReadEmployee(rs.getInt("doctor"),database).getEmployee());
                operation.setDiagnosis(rs.getString("diagnosis"));
                operation.setDateTime(rs.getString("dateTime"));
                operation.setPaid(Boolean.parseBoolean(rs.getString("paid")));
                operations.add(operation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Operation> getOperations(){
        return operations;
    }
}
