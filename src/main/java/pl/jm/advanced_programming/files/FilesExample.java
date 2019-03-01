package pl.jm.advanced_programming.files;

import pl.jm.advanced_programming.files.serialization.FileDeserializer;
import pl.jm.advanced_programming.files.serialization.to_file.FileSerializer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        List<Animal> animals = new LinkedList<>(Arrays.asList(
                new Animal("asda", 15, 150, true),
                new Animal("asdadsaa", 3, 50, true),
                new Animal("asd123a", 4, 250, true),
                new Animal("asdqwea", 2, 1150, true),
                new Animal("asdthgala", 5, 350, true)));
        String filePath = "/home/arch/animals.txt";

        try (FileSerializer fileSerializer = new FileSerializer(filePath)) {
           fileSerializer.writeAnimals(animals);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileDeserializer fileDeserializer = new FileDeserializer(filePath)) {
            fileDeserializer.readAnimals().forEach(FilesExample::printAnimals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAnimals(Animal animal) {
        System.out.println(animal);
    }
}
