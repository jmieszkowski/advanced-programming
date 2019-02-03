package pl.jm.advanced_programming.notify;

public class Hip implements Runnable {
    Object o;

    public Hip(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            while (true) {
                o.notify();
                System.out.println("Hip");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
