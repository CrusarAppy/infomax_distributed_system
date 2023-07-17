package multithreading_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Counter1 {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

class IncrementTask1 implements Runnable {
    private final Counter1 counter;

    public IncrementTask1(Counter1 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class MultithreadingProblemWithSynchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Runnable task = new IncrementTask(counter);
            executorService.execute(task);
        }

        executorService.shutdown();

        // Wait until all tasks are completed
        while (!executorService.isTerminated()) {
            // Do nothing
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
