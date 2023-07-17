package static_synchronization;

// Java program of multithreading
// with static synchronized

public class MainClass{
    public static void main(String arg[])
    {
        Display d1=new Display();
        Display d2=new Display();
        MyThread t1=new MyThread(d1,"Hello");
        MyThread t2=new MyThread(d2,"World");
        t1.start();
        t2.start();
    }
}


