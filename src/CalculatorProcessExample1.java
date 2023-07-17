import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorProcessExample1 {

    public static void main(String[] args) {
        // Creating a new process for the calculator
        ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "Calculator");
        try {
            Process calculatorProcess = processBuilder.start();
            System.out.println("Calculator process started.");

            // Create multiple threads within the calculator process
            Thread additionThread = new Thread(() -> performAddition());
            Thread subtractionThread = new Thread(() -> performSubtraction());
            Thread divisionThread = new Thread(() -> performDivision());

            additionThread.start();
            subtractionThread.start();
            divisionThread.start();

            // Sleep for a certain time (in milliseconds)
            int terminationTime = 5000;
            Thread.sleep(terminationTime);

            // Terminate the calculator process using AppleScript
            String[] closeCommand = { "osascript", "-e", "quit app \"Calculator\"" };
            Process closeProcess = new ProcessBuilder(closeCommand).start();
            closeProcess.waitFor();
            System.out.println("Calculator process terminated.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void performAddition() {
        try {
            // Read user input for addition
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number for addition: ");
            double num1 = Double.parseDouble(reader.readLine());
            System.out.print("Enter the second number for addition: ");
            double num2 = Double.parseDouble(reader.readLine());

            // Perform addition
            double result = num1 + num2;
            System.out.println("Addition result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void performSubtraction() {
        try {
            // Read user input for subtraction
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number for subtraction: ");
            double num1 = Double.parseDouble(reader.readLine());
            System.out.print("Enter the second number for subtraction: ");
            double num2 = Double.parseDouble(reader.readLine());

            // Perform subtraction
            double result = num1 - num2;
            System.out.println("Subtraction result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void performDivision() {
        try {
            // Read user input for division
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the dividend for division: ");
            double dividend = Double.parseDouble(reader.readLine());
            System.out.print("Enter the divisor for division: ");
            double divisor = Double.parseDouble(reader.readLine());

            // Perform division
            double result = dividend / divisor;
            System.out.println("Division result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
