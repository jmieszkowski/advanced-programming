package pl.jm.homework.hw_one;

public class WorkerAdder implements Runnable{

    public long sum;
    Object o;
    long[] numbers;

    public WorkerAdder(Object o, long[] numbers) {
        this.o = o;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        sum = performArrayAddition();
    }

    long performArrayAddition(){
        long sum = 0;
        synchronized (o) {
            o.notify();
            for (long n : numbers) {
                sum = sum + n;
            }
        }
            return sum;

    }
}
