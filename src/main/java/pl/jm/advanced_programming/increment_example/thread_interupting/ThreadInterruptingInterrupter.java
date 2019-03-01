package pl.jm.advanced_programming.increment_example.thread_interupting;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadInterruptingInterrupter implements Runnable {
    InterruptHolder interruptHolder;

    public ThreadInterruptingInterrupter(InterruptHolder interruptHolder) {
        this.interruptHolder = interruptHolder;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptHolder.setShouldBeInterrupted(new AtomicBoolean(true));
        System.out.println("Stopped!");
    }
}
