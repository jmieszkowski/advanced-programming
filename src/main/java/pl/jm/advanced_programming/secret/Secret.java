package pl.jm.advanced_programming.secret;

public class Secret {
    private static Secret INSTANCE;

    private Secret(){
        //empty
    }
    public static Secret getInstance(){

        if(INSTANCE == null) {
            synchronized (Secret.class) {
                if (null == INSTANCE) INSTANCE = new Secret();
            }
        }
        return INSTANCE;
        }
    }

