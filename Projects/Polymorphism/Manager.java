// Armando Alonso Franco
// Panther ID: 6406621
// COP 3337

import java.util.Objects;

public class Manager extends Employee{

    public Manager() { //default constructor
        super();
        designation = "Manager";
    }
    public Manager(String employeeID, String name, String department, double salary, String designation) { //parameter constructor
        super(employeeID, name, department, salary, designation);
    }
    public Manager (Manager anotherManager) { //copy constructor
        super(anotherManager);
    }

    public double addBonus() { //overridden addBonus for manager, add bonus to salary
        return getSalary() + 300;
    }
    public boolean equals(Object object) { //overridden equals method, only checks for object class since designations are fixed
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return true;
    }
    public double calculateDeductions(int daysPresent) { //overridden method that calculates salary deduction for manager
        int daysOnLeave = 20 - daysPresent;
        double deduction = addBonus()/20;
        return daysOnLeave * deduction;
    }

}
