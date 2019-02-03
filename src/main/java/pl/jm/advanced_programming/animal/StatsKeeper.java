package pl.jm.advanced_programming.animal;

import java.util.List;
import java.util.function.Predicate;

public class StatsKeeper implements Runnable{
    private static final String messagePattern=
            "\t Number of all animals: [%s]\n" +
            "\t Number of dead ones: [%s]\n" +
             "\t Number of alive ones: [%s]\n";

    private final List<Animal> animals;
    private final long timeIntervalInSec;


    public StatsKeeper(List<? extends Animal> animals, long timeIntervalInSec) {
        this.animals = (List<Animal>) animals;
        this.timeIntervalInSec = timeIntervalInSec;
    }

    @Override
    public void run() {
        while (true) {
            long numberOfAll = animals.size();
            long numberOfAlive = animals.stream().filter(Animal::isAlive).count();
            long numberOfDead = numberOfAll - numberOfAlive;
            System.out.println(String.format(messagePattern, numberOfAll, numberOfDead, numberOfAlive));
            System.out.println();
            try {
                Thread.sleep(Utils.convertSecToMiliseconds(timeIntervalInSec));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
