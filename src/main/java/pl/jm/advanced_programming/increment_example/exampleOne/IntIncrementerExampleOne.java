package pl.jm.advanced_programming.increment_example.exampleOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IntIncrementerExampleOne implements Runnable {
   long i = 5;

    @Override
    public void run() {
        for (int k =0; k<1000; k++) {
            System.out.println(String.format("Worker name: %s, current value of i = %s",
                    Thread.currentThread().getName(), ++i));
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        IntIncrementerExampleOne job = new IntIncrementerExampleOne();
        service.execute(job);
        service.execute(job);

        service.shutdown();

        while (!service.isTerminated()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("From main, i = " + job.i);
    }

}
