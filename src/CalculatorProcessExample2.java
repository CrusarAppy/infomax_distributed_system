import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorProcessExample2 {

    public static void main(String[] args) {
        // Creating a new process for the calculator
        ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "Calculator");
        try {
            Process calculatorProcess = processBuilder.start();
            System.out.println("Calculator process started.");

            // Create multiple threads within the calculator process
            Thread additionThread = new Thread(() -> performAddition(getNumberInput(), getNumberInput()));
            Thread subtractionThread = new Thread(() -> performSubtraction(getNumberInput(), getNumberInput()));
            Thread divisionThread = new Thread(() -> performDivision(getNumberInput(), getNumberInput()));

            additionThread.start();
            subtractionThread.start();
            divisionThread.start();

            // Sleep for a certain time (in milliseconds)
            int terminationTime = 5000;
            Thread.sleep(terminationTime);

            // Terminate the calculator process using AppleScript
            String[] closeCommand = {"osascript", "-e", "quit app \"Calculator\""};
            Process closeProcess = new ProcessBuilder(closeCommand).start();
            closeProcess.waitFor();
            System.out.println("Calculator process terminated.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static double getNumberInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number: ");
            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void performAddition(double num1, double num2) {
        double result = num1 + num2;
        System.out.println("Addition result: " + result);
    }

    private static void performSubtraction(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("Subtraction result: " + result);
    }

    private static void performDivision(double dividend, double divisor) {
        double result = dividend / divisor;
        System.out.println("Division result: " + result);
    }
}
