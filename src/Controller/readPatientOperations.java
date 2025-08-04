package Controller;

import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class readPatientOperations {
    private ArrayList<Operation> operations= new ArrayList<>();

    public readPatientOperations(Database database, int patientID){
        String select="SELECT * FROM `Operation` WHERE `patient`='"+patientID+"';";
        try {
            ResultSet rs=database.getStatement().executeQuery(select);

            while(rs.next()){
                Operation operation= new Operation();
                operation.setID(rs.getInt("ID"));
                operation.setPatient(new ReadPatient(rs.getInt("patient"),database).getPatient());
                /*int id=rs.getInt("doctor");
                Doctor e= (Doctor) new ReadEmployee(id,database).getEmployee();*/
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
