import java.util.Scanner;

public class TwoDigitCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input first number
            System.out.print("Enter the first two-digit number: ");
            int num1 = readTwoDigitNumber(scanner);

            // Input second number
            System.out.print("Enter the second two-digit number: ");
            int num2 = readTwoDigitNumber(scanner);

            // Input operator
            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = readOperator(scanner);

            // Perform calculation
            int result = calculate(num1, num2, operator);

            // Display result
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    // Helper method to read a two-digit number from the user
    private static int readTwoDigitNumber(Scanner scanner) {
        int number = scanner.nextInt();

        if (number < 10 || number > 99) {
            throw new IllegalArgumentException("Invalid input. Please enter a two-digit number.");
        }

        return number;
    }

    // Helper method to read a valid operator from the user
    private static char readOperator(Scanner scanner) {
        char operator = scanner.next().charAt(0);

        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new IllegalArgumentException("Invalid operator. Please enter +, -, *, or /.");
        }

        return operator;
    }

    // This is the method  to perform calculation
    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }
}
