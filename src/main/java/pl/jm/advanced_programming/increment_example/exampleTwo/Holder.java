package pl.jm.advanced_programming.increment_example.exampleTwo;

public class Holder {
    private volatile int i;

    Holder(int i) {
        this.i = i;
    }

    int getI() {
        return i;
    }

    void setI(int i) {
        this.i = i;
    }
}
