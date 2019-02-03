package pl.jm.advanced_programming.dead_lock;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private final Queue<String> first;
    private final Queue<String> second;
    private final Random random;

    public Producer(Queue<String> first, Queue<String> second, Random random) {
        this.first = first;
        this.second = second;
        this.random = random;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (first) {
                synchronized (second) {
                    System.out.println("Producing data...");
                    first.offer("" + random.nextInt());
                    second.offer("" + random.nextInt());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
