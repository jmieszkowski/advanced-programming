package pl.jm.advanced_programming.gogo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GogoClub {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Runnable job = () -> {
            System.out.println("Hitting bodyguard " + Thread.currentThread().getName());
            countDownLatch.countDown();
            try {
                countDownLatch.await();
                System.out.println("im in the club!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10;i++) executorService.execute(job);



    }
}
