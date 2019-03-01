package pl.jm.advanced_programming.files.serialization;

import pl.jm.advanced_programming.files.Animal;
import pl.jm.advanced_programming.files.Deserializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class FileDeserializer implements Deserializer, AutoCloseable {
    private final String filePath;
    private final BufferedReader bufferedReader;

    public FileDeserializer(String filePath) throws FileNotFoundException {

        this.filePath = Objects.requireNonNull(filePath,"file path cannot be null");
        bufferedReader = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }

    private Optional<Animal> fromStringToOptional(String string){
        try {

            return Optional.of(convertStringToAnimal(string));

        }catch (RuntimeException e){return Optional.empty();}

    }

    private Animal convertStringToAnimal(String string){
        Scanner scanner = new Scanner(string);
        String name = scanner.next();
        int numberOfLegs = scanner.nextInt();
        long hairs = scanner.nextLong();
        boolean isAlive = scanner.nextBoolean();

        return new Animal(name,numberOfLegs,hairs,isAlive);

    }

    @Override
    public List<Animal> readAnimals() {
     return bufferedReader.lines().map(this::fromStringToOptional)
                                  .filter(Optional::isPresent)
                                  .map(Optional::get)
                                  .collect(Collectors.toList());

    }

//    @Override
//    public List<Animal> readAnimals() {
//       return bufferedReader.lines()
//                .filter((String s) -> s.length() > 0)
//                .map(this::convertStringToAnimal).collect(Collectors.toList());
//
//
//
//    }
}
