package pl.jm.advanced_programming.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Runnable job1 = Main::run1;
        Runnable job2 = Main::run2;

        Thread thread1 = new Thread(job1);
        Thread thread2 = new Thread(job2);
        Thread thread3 = new Thread(job1);
        Thread thread4 = new Thread(job2);
        Thread thread5 = new Thread(job1);
        Thread thread6 = new Thread(job2);
        Thread thread7 = new Thread(job1);
        Thread thread8 = new Thread(job2);
        Thread thread9 = new Thread(job1);
        Thread thread10 = new Thread(job2);

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread4.setPriority(Thread.MAX_PRIORITY);
        thread5.setPriority(Thread.MIN_PRIORITY);
        thread6.setPriority(Thread.MAX_PRIORITY);
        thread7.setPriority(Thread.MIN_PRIORITY);
        thread8.setPriority(Thread.MAX_PRIORITY);
        thread9.setPriority(Thread.MIN_PRIORITY);
        thread10.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    private static void run1() {
        while (true) {
            System.out.println("Job1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void run2() {
        while (true) {
            System.out.println("Job2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
