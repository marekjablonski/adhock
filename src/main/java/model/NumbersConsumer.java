package model;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    MaxValueService maxValueService;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill,  MaxValueService maxValueService) {
        this.queue = queue;
        this.poisonPill = poisonPill;
        this.maxValueService  =maxValueService;
    }
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();

                if (number.equals(poisonPill)) {
                    return;
                }
                // System.out.println(Thread.currentThread().getName() + " result: " + number);
                 maxValueService.addNumber(number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}