package pl.jm.advanced_programming.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicMain {
    public static void main(String[] args) {
        AtomicLong a = new AtomicLong(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i =0; i < 5; i++){
            LongIncrementer longIncrementer = new LongIncrementer(a);
            executorService.execute(longIncrementer);
        }
    while (true) {
        try {
            executorService.shutdown();
            if (executorService.awaitTermination(10, TimeUnit.SECONDS));
                break;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        System.out.println(a);
        System.exit(0);
    }
}
