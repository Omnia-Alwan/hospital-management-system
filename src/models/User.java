package models;

import java.util.Scanner;

public abstract class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    protected Option[] Options;
    public User(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void showList(Scanner s,Database database){
        for(int i=0;i<Options.length;i++){
            System.out.println(i+1+". "+Options[i].getName());
        }
        int selected=s.nextInt();
        Options[selected-1].operation(s,database,this);
        showList(s,database);
    }
     public String getName(){
        return this.firstName+" "+this.lastName;
     }
}
