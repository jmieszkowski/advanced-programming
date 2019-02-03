package pl.jm.advanced_programming.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HipHop {
    public static void main(String[] args) {
        Object o = new Object();
        Hip hip = new Hip(o);
        Hop hop = new Hop(o);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(hip);
        executor.execute(hop);
    }
}
