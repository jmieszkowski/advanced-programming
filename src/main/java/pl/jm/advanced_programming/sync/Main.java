package pl.jm.advanced_programming.sync;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        Queue<Pizza> pizzas = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Pizzeria pizzeria = new Pizzeria(pizzas,lock);
        Pizzeria pizzeria2 = new Pizzeria(pizzas,lock);
        Consumer consumer = new Consumer(pizzas,lock);
        Consumer consumer2 = new Consumer(pizzas,lock);
        Consumer consumer3 = new Consumer(pizzas, lock);

        ExecutorService worker = Executors.newFixedThreadPool(5);

        worker.execute(consumer);
        worker.execute(consumer2);
        worker.execute(consumer3);
        worker.execute(pizzeria);
        worker.execute(pizzeria2);




    }
}
