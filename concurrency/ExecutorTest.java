import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

