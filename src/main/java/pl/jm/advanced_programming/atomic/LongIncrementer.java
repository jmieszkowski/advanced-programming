package pl.jm.advanced_programming.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class LongIncrementer implements Runnable {
    AtomicLong atomicLong;

    public LongIncrementer(AtomicLong atomicLong) {
        this.atomicLong = atomicLong;
    }

    @Override
    public void run() {
        long expected;
        do{
            expected = atomicLong.get();
        } while (!atomicLong.compareAndSet(expected,expected+2));

    }
    //Another method
//    @Override
//    public void run() {
//        atomicLong.incrementAndGet();
//    }
}
