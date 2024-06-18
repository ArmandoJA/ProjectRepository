import java.util.Scanner;

// Armando Alonso Franco
// Panther ID: 6406621
// COP 3337

public class AirplaneSeats { //program that assigns passenger seats in an airplane

    public void makeSeats(String[][] arr) { //method that makes the airplane seats as a matrix
        String[] seat = {"1", "2", "3", "4", "5", "6", "7"};
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = String.valueOf((char) ('A' - 1 + col));
                arr[row][0] = seat[row];
            }
        }
    }

    public void fillSeats (String[][] arr, String response, int[] seatsLeft) {// method that fills the seat provided by user
        if (response.length() == 2) { //checks if the input is valid by checking if it has a length of 2
            int columnValue = 0;
            String row = String.valueOf(response.charAt(0)); //grabs the first value of user input which represents rows
            String column = String.valueOf(response.charAt(1)); //grabs the second value of user input which represents column
            if (column.equalsIgnoreCase("a")) { //each of this if-statements give the seat letter a value from 1 to 4
                columnValue = 1;
            }
            if (column.equalsIgnoreCase("b")) {
                columnValue = 2;
            }
            if (column.equalsIgnoreCase("c")) {
                columnValue = 3;
            }
            if (column.equalsIgnoreCase("d")) {
                columnValue = 4;
            }
            if (row.equals("1") || row.equals("2") || row.equals("3") || row.equals("4")
                    || row.equals("5") || row.equals("6") || row.equals("7")) { //checks if the user row input is valid
                if (column.equalsIgnoreCase("a") || column.equalsIgnoreCase("b")
                        || column.equalsIgnoreCase("c") || column.equalsIgnoreCase("d")) { //checks if the user column input is valid
                    if (arr[Integer.parseInt(row)-1][columnValue].equals("X")) { //if input is valid, program will check if seat is already filled
                        System.out.println("Seat already filled, try again.");
                    }
                    else { //if input is valid and seat is not taken, seat will be filled, marked by x, and amount of seats left decreases
                        arr[Integer.parseInt(row)-1][columnValue] = "X";
                        seatsLeft[0] --;
                    }
                }
                else { //if column input by user is invalid error message will show
                    System.out.println("Seat not found, try again.");
                }
            }
            else { //if row input by user is invalid error message will show
                System.out.println("Seat not found, try again.");
            }
        }
        else { //if input does not have the valid length error message will show
            System.out.println("Seat not found, try again.");
        }

    }


    public void printSeats(String[][] arr) { //method that prints the seat matrix and shows available seats
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [][] seats =  new String[7][5];
        AirplaneSeats as = new AirplaneSeats();
        as.makeSeats(seats);
        System.out.println("You will be selecting seats for this plane.");
        as.printSeats(seats);
        System.out.println();

        System.out.println("You will input the seat selection using the row number and then the seat letter (ex - 3B)");

        String input;
        int[] seatsLeft = {28};
        do { // do while loop so if user inputs q the program will end
            System.out.println("Please enter the seat number or Q to quit.");
            input = scan.nextLine();
            if (!input.equalsIgnoreCase("q")) {
                as.fillSeats(seats, input, seatsLeft);
                as.printSeats(seats);
            }
            if (seatsLeft[0] == 0) { //if seats left becomes zero program ends
                System.out.println("No more seats available.");
                System.exit(0);
            }

        } while (!input.equalsIgnoreCase("q"));
    }
}
