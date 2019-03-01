package pl.jm.advanced_programming.finalize;

public class Dog {
    String name;

    public Dog(String name) {
        System.out.println("Created new " + name);
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("i am finalize");
    }
}
