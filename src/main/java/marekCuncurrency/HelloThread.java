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

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
        (new HelloExtendThread()).start();
    }

}
