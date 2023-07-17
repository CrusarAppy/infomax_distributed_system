public class Main {
    public static void main(String [] args){
        CreateThread ct = new CreateThread();

//        to start thread ct.start() cannot be done
//         java.lang.Thread

        Thread t1 = new Thread(ct);

        t1.start();

//        CreateThreadByThread t2 = new CreateThreadByThread();
//        t2.start();

    }
}
