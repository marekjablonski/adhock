package dataStructures;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) throws Exception {
        Deque<String> stackAndQueue = new ArrayDeque<>();
        //as Stack:
        stackAndQueue.push("first");
        stackAndQueue.push("second");
        System.out.println(stackAndQueue.toString());
        //as Queue:
        stackAndQueue.offer("third");
        stackAndQueue.offer("fourth");

        System.out.println(stackAndQueue.toString());


        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        queue.offer(0);
        queue.offer(2);
        queue.add(2);

        System.out.println(queue);
        queue.offer(0);
        System.out.println("size: "+ queue.size());
        System.out.println("0 added");
        System.out.println(queue);


        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        int t = queue.size();
        for (int i = 1; i < queue.size(); ) {
            System.out.println(queue);
            System.out.println(queue.poll());
            System.out.println(queue);
        }

    }


}

