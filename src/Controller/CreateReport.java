package Controller;

import models.Database;
import models.Report;

import java.sql.SQLException;

public class CreateReport {

    private Database database;
    private Report report;
    public CreateReport(Database db, Report r){
        this.database=db;
        this.report=r;
    }

    public boolean isCreated(){
        boolean created=false;
        String create="INSERT INTO `Report`( `doctor`, `patient`, `paid`, `diagnosis`, `dateTime`, `treatment`) " +
                "VALUES ('"+report.getDoctor().getID()+"','"+report.getPatient().getID()+"','"+report.isPaid()+"'," +
                "'"+report.getDiagnosis()+"','"+report.getDateTime()+"','"+report.getTreatment()+"')";
        try {
            database.getStatement().execute(create);
            created=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
