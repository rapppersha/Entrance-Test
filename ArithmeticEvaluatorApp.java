import java.util.Scanner;

public class ArithmeticEvaluatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Arithmetic Expression Evaluator");

        while (true) {
            System.out.print("Enter expression (or type 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            try {
                double result = ArithmeticEvaluator.evaluate(input);
                if (result == (long) result) {
                    System.out.println("Result: " + (long) result);
                } else {
                    System.out.println("Result: " + result);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }
}