package pl.jm.advanced_programming.dead_lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Queue<String> source = new LinkedList<>();
        Queue<String> destination = new LinkedList<>();
        Random random = new Random();

       Producer producer = new Producer(source,destination, random);
        Copier copier = new Copier(source,destination);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(producer);
        executor.execute(copier);

    }
}
