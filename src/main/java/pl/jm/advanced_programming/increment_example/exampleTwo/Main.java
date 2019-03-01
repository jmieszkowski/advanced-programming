package pl.jm.advanced_programming.increment_example.exampleTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Holder holder = new Holder(0);
        IntIncrementerCounter intIncrementerCounter = new IntIncrementerCounter(holder);
        IntIncrementerPrinter intIncrementerPrinter = new IntIncrementerPrinter(holder);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(intIncrementerPrinter);
        executorService.execute(intIncrementerCounter);
    }
}
