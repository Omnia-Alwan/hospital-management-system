package view;

import Controller.DeleteEmployee;
import models.Database;
import models.Option;
import models.User;

import java.util.Scanner;

public class FireEmployee implements Option {
    @Override
    public void operation(Scanner s, Database database, User u) {
        System.out.println("Enter employee ID");
        int id=s.nextInt();
        while(id<=0){
            new view.FireEmployee().operation(s,database,u);
            System.out.println("Enter employee ID");
            id=s.nextInt();
        }
        if(new DeleteEmployee(id,database).isDeleted()){
            System.out.println("Employee deleted successfully");
        }
    }

    @Override
    public String getName() {
        return "Fire Employee";
    }
}
