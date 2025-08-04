package models;

public abstract class Employee extends User {
    private int salary;

    public Employee(){

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public abstract int getTitle();

    public abstract String getJobToString();
}
