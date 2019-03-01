package pl.jm.advanced_programming.serialization;

import java.io.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person("Jędrek", "M", Optional.ofNullable("nick"));
        Person person = new Person("Jędrek", "M", new Address("K", "W", 1));
        Person person2 = new Person("Jędrek", "M", Optional.ofNullable("nick"),
                                            new Address("K", "W", 1));


        String myPath = File.separator + "home" +
                        File.separator + "arch" +
                        File.separator + "person.ser";

        String myPath2 = File.separator + "home" +
                        File.separator + "arch" +
                        File.separator + "person2.ser";
        try (ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(myPath));
             ObjectOutputStream serializer2 = new ObjectOutputStream(new FileOutputStream(myPath2))){

            serializer.writeObject(person);
            serializer2.writeObject(person2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(myPath2))){

            try {
                Person personWithOptional = (Person) deserializer.readObject();
                System.out.println(personWithOptional);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
