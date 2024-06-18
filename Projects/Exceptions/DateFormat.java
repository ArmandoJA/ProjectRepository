// Armando Alonso Franco
// Panther ID: 6406621
// COP 3337

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DateFormat {

    private static final String[] monthList = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    private static int handleMonthException(Scanner scan, int month) { //Method to facilitate month exception
        while (month < 1 || month > 12) {
            System.out.println("Invalid month. Reenter a valid month: ");
            String input = scan.nextLine();
            quitProgram(input);
            try {
                month = Integer.parseInt(input);
            } catch (NumberFormatException ex) { //Exception in case user input is not a number
                System.out.println("Invalid month. Reenter a valid month: ");
                input = scan.nextLine();
                quitProgram(input);
                month = Integer.parseInt(input);
            }
        }
        return month;
    }
    public static int handleDayException(Scanner scan, int month, int day, int year) { //Method to facilitate day exception
        if (month == 2) {
            if (leapYear(year)) {
                while (day < 1 || day > 29) {
                    System.out.println("Invalid day. Reenter a valid day: ");
                    String input = scan.nextLine();
                    quitProgram(input);
                    try {
                        day = Integer.parseInt(input);
                    } catch (NumberFormatException ex) { //Exception in case user input is not a number
                        System.out.println("Invalid day. Reenter a valid day: ");
                        input = scan.nextLine();
                        quitProgram(input);
                        day = Integer.parseInt(input);
                    }
                }
            }
            else {
                while (day < 1 || day > 28) {
                    System.out.println("Invalid day. Reenter a valid day: ");
                    String input = scan.nextLine();
                    quitProgram(input);
                    try {
                        day = Integer.parseInt(input);
                    } catch (NumberFormatException ex) { //Exception in case user input is not a number
                        System.out.println("Invalid day. Reenter a valid day: ");
                        input = scan.nextLine();
                        quitProgram(input);
                        day = Integer.parseInt(input);
                    }
                }
            }
        }
        else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                while (day < 1 || day > 31) {
                    System.out.println("Invalid day. Reenter a valid day: ");
                    String input = scan.nextLine();
                    quitProgram(input);
                    try {
                        day = Integer.parseInt(input);
                    } catch (NumberFormatException ex) { //Exception in case user input is not a number
                        System.out.println("Invalid day. Reenter a valid day: ");
                        input = scan.nextLine();
                        quitProgram(input);
                        day = Integer.parseInt(input);
                    }
                }
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                while (day < 1 || day > 30) {
                    System.out.println("Invalid day. Reenter a valid day: ");
                    String input = scan.nextLine();
                    quitProgram(input);
                    try {
                        day = Integer.parseInt(input);
                    } catch (NumberFormatException ex) { //Exception in case user input is not a number
                        System.out.println("Invalid day. Reenter a valid day: ");
                        input = scan.nextLine();
                        quitProgram(input);
                        day = Integer.parseInt(input);
                    }
                }
            }
        }
        return day;
    }
    public static int handleYearException(Scanner scan, int year) { //Method to facilitate year exception
        while (!yearValid(year)) { //Will continue to ask user until year is valid
            System.out.println("Invalid year. Reenter a valid year: ");
            String input = scan.nextLine();
            quitProgram(input);
            try {
                year = Integer.parseInt(input);
            } catch (NumberFormatException ex) { //Exception in case user input is not a number
                System.out.println("Invalid year. Reenter a valid year: ");
                input = scan.nextLine();
                quitProgram(input);
                year = Integer.parseInt(input);
            }
        }
        return year;
    }
    public static void quitProgram(String input) { //Method that checks if input is quit to allow user to end program
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("End of program");
            System.exit(0);
        }
    }
    public static boolean leapYear(int year) { //Method that checks if year is a leap year
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    public static void validateDay(int day, int maxDay) throws DayException { //Method that checks if date is valid and if not throws exception
        if (day < 1 || day > maxDay) {
            throw new DayException();
        }
    }
    public static boolean yearValid(int year) { //Method that checks if year is valid or not
        return (year >= 1000 && year <= 3000);
    }
    public static boolean validateDate(String date) { //Makes sure date has valid format and input
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Program to change date format (You may exit the program at any time by writing quit)");

        while (true) { //Allows code to run endlessly unless user inputs quit
            int day = 0, month = 0, year = 0;
            try {
                System.out.println("Enter date to parse (MM/DD/YYYY format): ");
                String date = scan.nextLine();
                quitProgram(date);

                if (!validateDate(date)) {
                    throw new InputMismatchException();
                }

                StringTokenizer dateToken = new StringTokenizer(date, "/"); //breaks apart date into month, day, and year
                month = Integer.parseInt(dateToken.nextToken());
                day = Integer.parseInt(dateToken.nextToken());
                year = Integer.parseInt(dateToken.nextToken());

                switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12:
                        validateDay(day, 31);
                        break;
                    case 2:
                        if (leapYear(year)) {
                            validateDay(day, 29);
                        } else {
                            validateDay(day, 28);
                        }
                        break;
                    case 4, 6, 9, 11:
                        validateDay(day, 30);
                        break;
                    default: //if month is not valid, aka not between 1 and 12, it will throw an exception
                        throw new MonthException();
                }

                if (!yearValid(year)) { //checks if year is valid
                    throw new YearException();
                }

            } catch (InputMismatchException e) { //Exception for when date input does not match format required
                System.out.println("Invalid input, please only use numbers in MM/DD/YYYY format.");
                System.out.println();
                continue;
            } catch (MonthException e) { //Exception for when month is invalid
                month = handleMonthException(scan, month);
                day = handleDayException(scan, month, day, year);
                year = handleYearException(scan, year);
            } catch (DayException e) { //Exception for when day is invalid
                day = handleDayException(scan, month, day, year);
                year = handleYearException(scan, year);
            } catch (YearException e) { //Exception for when year is invalid
                year = handleYearException(scan, year);
            }
            String monthName = monthList[month - 1];
            System.out.println("Parsed date: " + monthName + " " + day + ", " + year);
            System.out.println();
        }
    }
}