public class CreateThreadByThread extends Thread{

    public void run(){
        //task
            for(int i=1; i<=10; i++){
                System.out.println(i* 5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }

}
