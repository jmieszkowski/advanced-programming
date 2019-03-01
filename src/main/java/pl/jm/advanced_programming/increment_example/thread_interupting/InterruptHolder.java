package pl.jm.advanced_programming.increment_example.thread_interupting;

import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptHolder {
//    boolean shouldBeInterrupted;
    AtomicBoolean shouldBeInterrupted;

    public InterruptHolder(AtomicBoolean shouldBeInterrupted) {
        this.shouldBeInterrupted = shouldBeInterrupted;
    }

    public void setShouldBeInterrupted(AtomicBoolean shouldBeInterrupted) {
        this.shouldBeInterrupted = shouldBeInterrupted;
    }

    public AtomicBoolean getShouldBeInterrupted() {
        return shouldBeInterrupted;
    }
}
