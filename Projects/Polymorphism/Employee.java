import java.util.Objects;

public class Employee {
    private String employeeID;
    private String name;
    private String department;
    protected String designation;
    private double salary;

    public Employee() { //default constructor
        this("No employee ID yet", "No name yet", "No department yet", 0.0, "No designation yet");
    }
    public Employee (String employeeID, String name, String department, double salary, String designation) { //argument constructor
        setEmployeeID(employeeID);
        setName(name);
        setDepartment(department);
        setDesignation(designation);
        setSalary(salary);
    }
    public Employee (Employee anotherEmployee) { //copy constructor
        setEmployeeID(anotherEmployee.getEmployeeID());
        setName(anotherEmployee.getName());
        setDepartment(anotherEmployee.getDepartment());
        setDesignation(anotherEmployee.getDesignation());
        setSalary(anotherEmployee.getSalary());
    }
    public void setEmployeeID (String employeeID) { //mutator/setter for employee ID
        if (employeeID != null) {
            this.employeeID = employeeID;
        }
        else {
            System.out.println("Invalid employee ID.");
        }
    }
    public void setName (String name) { //mutator/setter for employee name
        if (name != null) {
            this.name = name;
        }
        else {
            System.out.println("Invalid name.");
        }
    }
    public void setDepartment (String department) { //mutator/setter for employee department
        if (department != null) {
            this.department = department;
        }
        else {
            System.out.println("Invalid department.");
        }
    }
    public void setDesignation (String designation) { //mutator/setter for employee designation
        if (designation != null) {
            this.designation = designation;
        }
        else {
            System.out.println("Invalid designation.");
        }
    }
    public void setSalary (double salary) { //mutator/setter for employee salary
        if (salary < 0.0) {
            System.out.println("Invalid salary.");
        }
        else {
            this.salary = salary;
        }
    }
    public String getEmployeeID() { //accessor/getter for employee ID
        return employeeID;
    }
    public String getName() { //accessor/getter for employee name
        return name;
    }
    public String getDepartment() { //accessor/getter for employee department
        return department;
    }
    public String getDesignation() { //accessor/getter for employee designation
        return designation;
    }
    public double getSalary() { //accessor/getter for employee salary
        return salary;
    }
    public boolean equals(Object object) { //overridden equals method, checks if designation is equal
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Employee anotherEmployee = (Employee) object;
        return Objects.equals(designation, anotherEmployee.getDesignation());
    }
    public double addBonus() { //addBonus for regular employee, add bonus to salary
        return getSalary() + 200;
    }
    public void display() { //display method, showcases all employee information
        System.out.println("Employee ID: " + employeeID + "\nEmployee name: " + name +
                "\nDepartment name: " + department + "\nSalary: " + salary +
                "\nDesignation: " + designation + "\nSalary after adding the bonus is: " + addBonus());
    }
    public double calculateDeductions(int daysPresent) { //method that calculates salary deduction of average employee
        int daysOnLeave = 20 - daysPresent;
        double deduction = 500;
        return daysOnLeave * deduction;
    }
}
