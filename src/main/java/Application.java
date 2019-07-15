import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String args[]) {
        System.out.println("Starting app");

        Executor executor = Executors.newFixedThreadPool(200);


        for (int i = 0; i < 500; i++) {
            executor.execute(() -> new SomeJob().run(false));
        }
    }
}

class SomeJob {

    private final int taskTime = 10000;

    void run(boolean blocking) {
        var whoami = whoami();

        System.out.println("Starting blocking tasks: " + whoami);
        if (blocking) {
            blockingTask();
        } else {
            itensiveOperation();
        }
        System.out.println("**** Ends " + whoami + " ****");
    }

    private void itensiveOperation() {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < taskTime) {
            String[] array = new String[100000];
            array[1] = new String("Test");
            Arrays.asList(array).size();
        }
    }

    private void blockingTask() {
        try {
            Thread.sleep(taskTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String whoami() {
        return Thread.currentThread().getName();
    }

}