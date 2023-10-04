
import java.util.Scanner;

public class Calculator {
    private double result;

    public Calculator() {
        this.result = 0.0;
    }

    public void add(double num1, double num2) {
        this.result = num1 + num2;
    }

    public void subtract(double num1, double num2) {
        this.result = num1 - num2;
    }

    public void multiply(double num1, double num2) {
        this.result = num1 * num2;
    }

    public void divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            this.result = num1 / num2;
        }
    }

    public double getResult() {
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Calculator!");
        System.out.println("Available operations: +, -, *, /");
        System.out.println("Enter 'quit' to exit the calculator.");

        while (true) {
            System.out.print("Enter an operation: ");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("quit")) {
                break;
            }

            if (!"+-*/".contains(operation) || operation.length() != 1) {
                System.out.println("Invalid operation. Please enter +, -, *, or /.");
                continue;
            }

            try {
                System.out.print("Enter the first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter the second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                switch (operation) {
                    case "+":
                        calculator.add(num1, num2);
                        break;
                    case "-":
                        calculator.subtract(num1, num2);
                        break;
                    case "*":
                        calculator.multiply(num1, num2);
                        break;
                    case "/":
                        calculator.divide(num1, num2);
                        break;
                }

                System.out.println("Result: " + calculator.getResult());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }

        scanner.close();
    }
}
