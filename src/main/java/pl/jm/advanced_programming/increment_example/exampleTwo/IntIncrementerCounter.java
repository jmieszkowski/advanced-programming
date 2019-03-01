package pl.jm.advanced_programming.increment_example.exampleTwo;

public class IntIncrementerCounter implements Runnable {
    Holder holder;

    public IntIncrementerCounter(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
//        for (int k =0; k < 10000;k++){
        while (true){
            holder.setI(holder.getI() + 1);
        }
    }
}
