package pl.jm.homework.hw_one;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        WorkerAdder workerAdder = new WorkerAdder();
//        workerAdder.performArrayAddition()
            Object o = new Object();
            Random random = new Random();
            long[] numbers = new long[15];
            for (int i =0; i < numbers.length;i++) numbers[i] = random.nextInt(10);
            for (long n : numbers) System.out.println(n);

            Adder adder = new Adder(numbers, o);
        System.out.println("--------------------------");
        System.out.println(adder.performArrayAddition());
    }
}
