package pl.jm.advanced_programming.files.serialization.to_file;

import pl.jm.advanced_programming.files.Animal;
import pl.jm.advanced_programming.files.serialization.Serializer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class FileSerializer implements Serializer, AutoCloseable {
    private final String filePath;
    private final PrintWriter printWriter;

    public FileSerializer(String filePath) throws FileNotFoundException {
        this.filePath = Objects.requireNonNull(filePath, "Path cannot be null");
        printWriter = new PrintWriter(this.filePath);
    }
    @Override
    public void writeAnimals(List<Animal> animals) {
        animals.forEach(animal -> {
            printWriter.format("%20s %3d %10d %5b",animal.getName(),animal.getNumberOfLegs(),
                    animal.getHairs(), animal.isAlive())
                    .println();
        });
        printWriter.flush();
    }

    @Override
    public void close() throws Exception {
            printWriter.close();
    }
}
