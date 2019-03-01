package pl.jm.advanced_programming.closable;

public class MyOwnCloseable implements AutoCloseable{
    private boolean canUse = true;

    @Override
    public void close(){
        System.out.println("Calling close() method");
        canUse = false;
    }
}
