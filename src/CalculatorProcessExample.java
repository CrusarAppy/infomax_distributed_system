import java.io.IOException;

public class CalculatorProcessExample {

    public static void main(String[] args) {
        // Creating a new process for the calculator
        ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "Calculator");
        try {
            Process calculatorProcess = processBuilder.start();
            System.out.println("Calculator process started.");

            // Create multiple threads within the calculator process
            for (int i = 1; i <= 5; i++) {
                int threadNumber = i;
                Thread thread = new Thread(() -> {
                    System.out.println("Thread " + threadNumber + " is running in the calculator process.");
                });
                thread.start();
            }

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
}
