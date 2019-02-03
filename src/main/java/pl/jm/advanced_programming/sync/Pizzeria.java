package pl.jm.advanced_programming.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Pizzeria implements Runnable {
    private Queue<Pizza> pizzas;
    Lock lock;

    public Pizzeria(Queue<Pizza> pizzas, Lock lock) {
        this.lock = lock;
        this.pizzas = pizzas;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
                pizzas.offer(new Pizza("Margerita", "cheese"));
            lock.unlock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
