package models;

public class Reciept {

    private int ID;
    private Cashier cashier;
    private Patient patient;
    private double amount;
    private int type; //o-->operation, 1-->report
    private int itemID; //operation/report ID

    public Reciept(){

    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public String toString(int t){
        if(t==0)
            return "Operation";
        else return "Report";
    }
}
