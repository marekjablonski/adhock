package model;


import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxValueService {
    int QUEUE_SIZE=10;
    PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(QUEUE_SIZE, (a, b) -> Integer.compare(a, b));
   // ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>(QUEUE_SIZE);
    AtomicInteger minValue;

    public MaxValueService(int initialQueueValue){
         for(int i=0;i<QUEUE_SIZE;i++){
             queue.add(initialQueueValue);
         }
        minValue = new AtomicInteger(initialQueueValue);
      }


    public void addNumber(Integer input) {
        if (input > minValue.get()) {
            queue.add(input);
            minValue.set(queue.poll());
            System.out.println(Thread.currentThread().getName() + " added number: " + input);
            System.out.println(Thread.currentThread().getName() + " removed number: " + minValue.get());

        }
    }






    public Integer[] takeMaxValues() {
        Integer[] maxValuesArray= new Integer[QUEUE_SIZE];
        return  queue.toArray(maxValuesArray);


    }


}


