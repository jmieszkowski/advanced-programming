package pl.jm.advanced_programming.increment_example.thread_interupting;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadInterruptingWriting implements Runnable {
    volatile InterruptHolder interruptHolder;
    boolean aBoolean;
    public ThreadInterruptingWriting(InterruptHolder interruptHolder) {
        this.interruptHolder = interruptHolder;
    }

    @Override
    public void run() {
        while (interruptHolder.getShouldBeInterrupted().compareAndSet(false, aBoolean)){
            System.out.println(LocalTime.now());
        }
    }

    public static void main(String[] args) {
        InterruptHolder interruptHolder = new InterruptHolder(new AtomicBoolean(false));
        ThreadInterruptingWriting job1 = new ThreadInterruptingWriting(interruptHolder);
        ThreadInterruptingInterrupter job2 = new ThreadInterruptingInterrupter(interruptHolder);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(job1);
        executorService.execute(job2);
        executorService.shutdown();

    }
}
