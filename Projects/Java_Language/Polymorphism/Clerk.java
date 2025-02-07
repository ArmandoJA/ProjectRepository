import java.util.Objects;

public class Clerk extends Employee{

    public Clerk() { //default constructor
        super();
        designation = "Clerk";
    }
    public Clerk (String employeeID, String name, String department, double salary, String designation) { //parameter constructor
        super(employeeID, name, department, salary, designation);
    }
    public Clerk (Clerk anotherClerk) { //copy constructor
        super(anotherClerk);
    }
    public double addBonus () { //overridden addBonus for clerk, add bonus to salary
        return getSalary() + 100;
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
    public double calculateDeductions(int daysPresent) { //overridden method that calculates salary deduction for clerk
        int daysOnLeave = 20 - daysPresent;
        double deduction = addBonus()/20;
        return daysOnLeave * deduction;
    }
}
