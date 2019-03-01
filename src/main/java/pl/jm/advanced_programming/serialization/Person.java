package pl.jm.advanced_programming.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

public class Person implements Serializable
{
    private static final long serialVersionUID = 1207410172327704545L;
    private String name;
    private String surname;
    private transient Optional<String> nick;
    private Address address;

    private void writeObject(ObjectOutputStream writer) throws IOException {
            writer.defaultWriteObject();
            String toWrite = null;
            if (null != nick && nick.isPresent()) toWrite = nick.get();
            writer.writeObject(toWrite);
    }

    private void readObject(ObjectInputStream reader) throws IOException, ClassNotFoundException {
        reader.defaultReadObject();
        String nick = (String) reader.readObject();
        this.nick = Optional.ofNullable(nick);
    }

    public Person(String name, String surname, Optional<String> nick, Address address) {
        System.out.println("Constructor!");
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.address = address;
    }

    public Person(String name, String surname, Address address) {
        System.out.println("Constructor!");
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, Optional<String> nick) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nick=" + nick +
                ", address=" + address +
                '}';
    }

}
