package pl.jm.advanced_programming.animal;

import java.util.List;

public class Cycle implements Runnable {
    private final long timeOfEveryCycle;
    private final List<Animal> animals;

    public Cycle(long timeOfEveryCycle, List<Animal> animals) {
        this.timeOfEveryCycle = timeOfEveryCycle;
        this.animals = animals;
    }


    @Override
    public void run() {
        while (true) {
            animals.forEach(Animal::consumeCalories);
            try {
                Thread.sleep(Utils.convertSecToMiliseconds(timeOfEveryCycle));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
