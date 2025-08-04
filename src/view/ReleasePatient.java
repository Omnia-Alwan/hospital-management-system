package view;

import Controller.DeletePatient;
import models.Database;
import models.Option;
import models.User;

import java.util.Scanner;

public class ReleasePatient implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        int id;
        do{
            System.out.println("Enter Patient ID to release or -1 to view all patients");
            id =s.nextInt();
            if(id<0)
                new ViewAllPatients().operation(s,database,u);
        }while(id<0);
        if(new DeletePatient(id, database).isDeleted()){
            System.out.println("Patient deleted successfully!");
        }
    }

    @Override
    public String getName() {
        return "Release patient";
    }
}
