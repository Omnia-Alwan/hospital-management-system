package Controller;

import models.Database;
import models.Doctor;
import models.Operation;
import models.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class readDoctorReports {

    private ArrayList<Report> reports= new ArrayList<>();
    public readDoctorReports(Doctor d, Database database){
        String select="SELECT * FROM `Report` WHERE `doctor`= '"+d.getID()+"';";
        try {
            ResultSet rs=database.getStatement().executeQuery(select);

            while(rs.next()){
                Report report= new Report();
                report.setID(rs.getInt("ID"));
                report.setPatient(new ReadPatient(rs.getInt("patient"),database).getPatient());
                report.setDoctor((Doctor) new ReadEmployee(rs.getInt("doctor"),database).getEmployee());
                report.setDiagnosis(rs.getString("diagnosis"));
                report.setDateTime(rs.getString("dateTime"));
                report.setTreatment(rs.getString("treatment"));
                report.setPaid(Boolean.parseBoolean(rs.getString("paid")));
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Report> getReports(){
        return reports;
    }
}
