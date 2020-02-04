package marekCuncurrency;


public class HelloThread  {

    public static class HelloRunnable implements Runnable {
        public void run() {
            System.out.println("Hello from a thread!");
        }
    }
    public static class HelloExtendThread extends Thread {
        public void run() {
            System.out.println("Hello from a thread!");
        }
    }

    public static void main(String args[])  throws InterruptedException {
        (new Thread(new HelloRunnable())).start();
        //(new HelloExtendThread()).start();


        Thread thread = new HelloExtendThread();

        // nothing happens until the thread starts
        System.out.println("After creation: " + thread.getState());

        thread.start();
        System.out.println("After thread.start(): " + thread.getState());

        // Wait until the second thread completes its execution either by sleeping or by
        // joining
        thread.join();
        // or
        try {
            Thread.sleep(500, 0); // == TimeUnit.MILLISECONDS.sleep(1000)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("When completed execution: " + thread.getState());
    }

}
