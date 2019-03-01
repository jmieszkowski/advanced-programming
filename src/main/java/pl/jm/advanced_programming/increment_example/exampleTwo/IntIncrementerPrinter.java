package pl.jm.advanced_programming.increment_example.exampleTwo;

public class IntIncrementerPrinter implements Runnable {
    Holder holder;

    public IntIncrementerPrinter(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(holder.getI());
        }
    }
}
