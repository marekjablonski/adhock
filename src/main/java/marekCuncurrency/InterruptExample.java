package marekCuncurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread taskThread = new Thread(taskThatFinishesEarlyOnInterruption());
        taskThread.start();      // requirement 3

        Thread.sleep(3_000);     // requirement 4
        taskThread.interrupt();  // requirement 5
        taskThread.join(1_000);  // requirement 6

        FutureTask<String> countResult= new FutureTask<>(taskThatFinishesEarlyOnInterruptionWithCallable());
        Thread t=new Thread(countResult);
        t.start();
        Thread.sleep(3_000);     // requirement 4
        t.interrupt();  // requirement 5
        String result = countResult.get();
        System.out.println(result);
    }
    private static Runnable taskThatFinishesEarlyOnInterruption() {
        return () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);      // requirement 1
                try {
                    Thread.sleep(1_000);  // requirement 2
                } catch (InterruptedException e) {
                    System.out.println("");
                    System.out.println("InterruptedException has been caught");
                    break;                // requirement 7
                }
            }
        };
    }

    private static Callable<String> taskThatFinishesEarlyOnInterruptionWithCallable() {
        return () -> {  Integer number=0;
            for (int i = 0; i < 10; i++) {
                      number=i;
                try {
                    Thread.sleep(1_000);  // requirement 2
                } catch (InterruptedException e) {
                    System.out.println("");
                    System.out.println("InterruptedException has been caught");
                    return new String("not completed");
                }
            }
            return number.toString();
          };
    }

}
