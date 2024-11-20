import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee employee1 = new Manager("E001", "Mark", "HR", 15000.0, "Manager");
        Employee employee2 = new Manager("E012", "Peter", "R&D", 15000.0, "Manager");
        Employee employee3 = new Clerk("E056", "Samuel", "Accounts", 10000.0, "Clerk");
        Employee employee4 = new Employee();
        employee4.setEmployeeID("E089");
        Employee[] employees = {employee1, employee2, employee3, employee4}; //array with each employee to facilitate writing information

        for (int i = 0; i < employees.length - 1; i++) { //for loop that displays the information of the desired employees
            employees[i].display();
            System.out.println();
        }

        if (employee1.equals(employee3)) { //if employee designations are equal print same, if not print different
            System.out.println(employee1.getName() + " and " + employee2.getName() + " have the same designations");
            System.out.println();
        }
        else {
            System.out.println(employee1.getName() + " and " + employee2.getName() + " have different designations");
            System.out.println();
        }

        // 2D array that holds days present of each employee and also holds days absent based on days present
        Integer[][] deduction = new Integer[2][employees.length];

        for (int i = 0; i < employees.length; i++) { //loop that ask for days present for each employee and makes sure the value given is valid
            System.out.print("Enter the number of days Employee " + employees[i].getEmployeeID() + " is present out of 20: ");
            int daysPresent = scan.nextInt();
            while (daysPresent < 0 || daysPresent > 20) {
                System.out.println("Value given for " + employees[i].getEmployeeID() + " is not valid");
                System.out.print("Enter the number of days Employee " + employees[i].getEmployeeID() + " is present out of 20: ");
                daysPresent = scan.nextInt();
            }
            deduction[0][i] = daysPresent;
            deduction[1][i] = 20 - daysPresent;
        }

        System.out.println();
        System.out.printf("Employee ID%5sPresent%2sAbsent%1sDeductions","","","");
        System.out.println();
        double totalDeduction = 0.0;
        for (int i = 0; i < employees.length; i++) { //for loop that prints out employee ID, days present, days absent, and their deduction
            double deductedValue = employees[i].calculateDeductions(deduction[0][i]);
            System.out.printf(employees[i].getEmployeeID() + "%12s" + deduction[0][i] + "%7s" + deduction[1][i] + "%6s" + "$" + deductedValue,"","","");
            totalDeduction += deductedValue;
            System.out.println();
            if (i == 3) { //also prints out total amount of deduction money in the end
                System.out.println();
                System.out.println("Total Deduction: $" + totalDeduction);
            }
        }

    }
}
