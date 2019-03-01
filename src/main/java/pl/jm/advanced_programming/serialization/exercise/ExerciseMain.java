package pl.jm.advanced_programming.serialization.exercise;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ExerciseMain {
    public static void main(String[] args) {
        Animal animal = new Animal("asd", 10, 50, false);

        List<String> days = new LinkedList<>(Arrays.asList(
                "monday", "tuesday"
        ));

        String myPath = File.separator + "home" +
                File.separator + "arch" +
                File.separator + "animal.ser";
        String myPath2 = File.separator + "home" +
                File.separator + "arch" +
                File.separator + "days.ser";


        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(myPath));
             ObjectOutputStream writer2 = new ObjectOutputStream(new FileOutputStream(myPath2))) {

            writer.writeObject(animal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(myPath));
             ObjectInputStream reader2 = new ObjectInputStream(new FileInputStream(myPath2))) {
           Animal animalAfterDeserialization =  (Animal) reader.readObject();
            System.out.println(animalAfterDeserialization);

//            List<String> days2 = (List<String>) reader2.readObject();
//            System.out.println(days2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
