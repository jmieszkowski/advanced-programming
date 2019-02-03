package pl.jm.advanced_programming.animal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Animal> animals = Arrays.asList(
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(5),
                        BigDecimal.valueOf(50),
                        Sex.FEMALE, "Wolf"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(5),
                        BigInteger.valueOf(5),
                        BigInteger.valueOf(12),
                        BigInteger.valueOf(6),
                        BigDecimal.valueOf(20),
                        Sex.FEMALE, "Wolf2"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(14),
                        BigInteger.valueOf(14),
                        BigInteger.valueOf(16),
                        BigInteger.valueOf(8),
                        BigDecimal.valueOf(35),
                        Sex.FEMALE, "Wolf3"),

                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(20),
                        BigInteger.valueOf(9),
                        BigDecimal.valueOf(47),
                        Sex.FEMALE, "Wolf4"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(18),
                        BigInteger.valueOf(18),
                        BigInteger.valueOf(16),
                        BigInteger.valueOf(5),
                        BigDecimal.valueOf(40),
                        Sex.FEMALE, "Wolf5"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(15),
                        BigInteger.valueOf(13),
                        BigInteger.valueOf(14),
                        BigInteger.valueOf(10),
                        BigDecimal.valueOf(20),
                        Sex.FEMALE, "Wolf6"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(13),
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(15),
                        BigInteger.valueOf(10),
                        BigDecimal.valueOf(80),
                        Sex.FEMALE, "Wolf7"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(14),
                        BigInteger.valueOf(10),
                        BigInteger.valueOf(14),
                        BigInteger.valueOf(10),
                        BigDecimal.valueOf(25),
                        Sex.FEMALE, "Wolf8"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(15),
                        BigInteger.valueOf(15),
                        BigInteger.valueOf(20),
                        BigInteger.valueOf(10),
                        BigDecimal.valueOf(60),
                        Sex.FEMALE, "Wolf9"),
                Wolf.creatWolfWithEverything(
                        BigInteger.valueOf(2),
                        BigInteger.valueOf(20),
                        BigInteger.valueOf(15),
                        BigInteger.valueOf(10),
                        BigDecimal.valueOf(60),
                        Sex.FEMALE, "Wolf10")
        );


        ZooWorker john = new ZooWorker(animals, 1 + random.nextInt(10), "Worker1");
        ZooWorker steve = new ZooWorker(animals, 1 + random.nextInt(10), "Worker2");
        StatsKeeper statsKeeper = new StatsKeeper(animals,16);
        Cycle cycle = new Cycle(15,animals);

//        Thread feed1 = new Thread(john);
//        Thread feed2 = new Thread(steve);
//        Thread stats = new Thread(statsKeeper);
//        Thread time = new Thread(cycle);
//
//        feed1.start();
//        feed2.start();
//        stats.start();
//        time.start();
        ExecutorService workers = Executors.newFixedThreadPool(4);
//        workers.submit(john);
//        workers.submit(steve);
//        workers.submit(statsKeeper);
//        workers.submit(cycle);
        workers.execute(john);
        workers.execute(steve);
        workers.execute(statsKeeper);
        workers.execute(cycle);

    }
}
