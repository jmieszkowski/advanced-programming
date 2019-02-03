package pl.jm.advanced_programming.notify;

import java.util.concurrent.locks.Lock;

public class Hop implements Runnable {
    Object o;

    public Hop(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            while (true) {
                System.out.println("Hop");
                o.notify();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
