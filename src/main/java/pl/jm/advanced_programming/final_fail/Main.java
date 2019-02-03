package pl.jm.advanced_programming.final_fail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        FinalFail finalFail = new FinalFail(object);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(finalFail);
        executor.execute(finalFail);
        executor.execute(finalFail);
        executor.execute(finalFail);

    }
}
