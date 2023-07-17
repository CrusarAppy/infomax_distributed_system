package static_synchronization;

public class Display {
    public static synchronized void wish(String name) {
        for (int i = 0; i < 3; i++) {
            System.out.print("Good Morning: ");
            System.out.println(name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
