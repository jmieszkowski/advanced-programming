package pl.jm.advanced_programming.notify;

public class NotifyExample {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {
            try {
                o.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
