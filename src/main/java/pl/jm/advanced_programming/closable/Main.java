package pl.jm.advanced_programming.closable;

public class Main {
    public static void main(String[] args) {
        mustBeClose();

    }

    private static void mustBeClose() {
        try (MyOwnCloseable myOwnCloseable = new MyOwnCloseable()){}

    }
}
