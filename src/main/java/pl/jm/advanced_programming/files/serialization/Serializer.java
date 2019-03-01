package pl.jm.advanced_programming.files.serialization;


import pl.jm.advanced_programming.files.Animal;

import java.util.List;

public interface Serializer {
    void writeAnimals(List<Animal> animals);

}
