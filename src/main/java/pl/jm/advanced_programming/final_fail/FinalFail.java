package pl.jm.advanced_programming.final_fail;

public class FinalFail implements Runnable {
   private final Object lock;

    public FinalFail(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i =0; i <10; i++){
                System.out.println("Runned by: " + Thread.currentThread().getName());
            }
        }
    }
}
