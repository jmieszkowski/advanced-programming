package pl.jm.advanced_programming.sync;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private Lock lock;
    private Queue<Pizza> pizzas;

    public Consumer(Queue<Pizza> pizzas, Lock lock) {
        this.pizzas = pizzas;
        this.lock = lock;

    }

//
//    public synchronized void showPizzas() {
//        pizzas.forEach(System.out::println);
//    }
//
//    public void showPizzas2() {
//        synchronized (this) {
//            pizzas.forEach(System.out::println);
//        }
//    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
                pizzas.forEach(System.out::println);
                if (!pizzas.isEmpty()) {
                    Pizza pizzaToEat = pizzas.poll();
                    System.out.println("Ate 1 pizza with " + pizzaToEat.getIngredients());
//            if (pizzaToEat != null) System.out.println("Ate 1 pizza with " + pizzaToEat.getIngredients());
            }
            lock.unlock();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
