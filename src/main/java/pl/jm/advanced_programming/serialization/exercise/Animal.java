package pl.jm.advanced_programming.serialization.exercise;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private int age;
    private long weight;
    boolean isPredator;


    private void writeObject(ObjectOutputStream writer) throws IOException {
        writer.writeObject(name);
        writer.writeObject(age);
        writer.writeObject(weight);
        writer.writeObject(isPredator);
    }

    private void readObject(ObjectInputStream reader) throws IOException, ClassNotFoundException {
        this.name = (String) reader.readObject();
        this.age = (Integer) reader.readObject();
        this.weight = (Long) reader.readObject();
        this.isPredator = (Boolean) reader.readObject();
    }

    public Animal(String name, int age, long weight, boolean isPredator) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isPredator = isPredator;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", isPredator=" + isPredator +
                '}';
    }
}
