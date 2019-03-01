package pl.jm.homework.hw_one;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Adder {
    long[] numbers;
    Object o;

    public Adder(long[] numbers, Object o) {
        this.numbers = numbers;
        this.o = o;
    }

    public long performArrayAddition() {

        int smallerArraysLength;

        if (numbers.length % 2 == 0) smallerArraysLength = numbers.length / 2;
        else smallerArraysLength = (numbers.length / 2)+1;


        long[] numbers1 = new long[numbers.length / 2];
        long[] numbers2 = new long[smallerArraysLength];

        System.arraycopy(numbers, 0, numbers1, 0     , numbers1.length);
        System.arraycopy(numbers, numbers1.length, numbers2, 0, numbers2.length);

        for (long n : numbers1) System.out.println(n);
        System.out.println("----------------------------------------");
        for (long n : numbers2) System.out.println(n);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        WorkerAdder workerAdder1 = new WorkerAdder(o, numbers1);
        WorkerAdder workerAdder2 = new WorkerAdder(o, numbers2);

        executorService.execute(workerAdder1);
        executorService.execute(workerAdder2);
        synchronized (o) {
            o.notify();
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long sum = workerAdder1.sum + workerAdder2.sum;
            executorService.shutdown();
            return sum;
        }
    }

}