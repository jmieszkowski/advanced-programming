package pl.jm.advanced_programming.animal;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class ZooWorker implements Runnable{
    private List<Animal> animals;
    private long timeIntervalInSec;
    private String name;
    private static BigInteger drinkAmount = BigInteger.valueOf(1);
    private static BigInteger foodAmount = BigInteger.valueOf(1);

    public ZooWorker(List<? extends Animal> animals, long timeInSec, String name){
        this.animals = (List<Animal>) Objects.requireNonNull(animals);
        this.timeIntervalInSec = timeInSec;
        this.name = name;
    }

    private static void feedAnimal(Animal animal) {
        animal.eatAndDrink(drinkAmount, foodAmount);
    }


    @Override
    public void run() {
//        animals.forEach(animal -> animal.eatAndDrink(drinkAmount,foodAmount));
        while(true) {
            animals.forEach(ZooWorker::feedAnimal);
            try {
                Thread.sleep(Utils.convertSecToMiliseconds(timeIntervalInSec));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
