package testCollection.testCollection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cashlu on 15/1/29.
 */
public class Employee {
    private int id;
    private String name;
    private String departement;
    private double salary;
    private Date hireDate;

    DateFormat df = new SimpleDateFormat("yyyy-MM");

    public Employee(String departement, int id, Date hireDate, String name, double salary) {
        this.departement = departement;
        this.id = id;
        this.hireDate = hireDate;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return df.format(hireDate);
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
