package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CountSumForkJoin {
    public static void main(String[] args) {
        List<Integer> inputToSum = Arrays.asList(1, 3, 4, 4);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        SumNumberTask task = new SumNumberTask(inputToSum);
        int result = pool.invoke(task);
        System.out.println(result);
    }

    public static class SumNumberTask extends RecursiveTask<Integer> {
        private List<Integer> inputToSum;

        SumNumberTask(List<Integer> listToSum) {
            this.inputToSum = listToSum;
        }

        @Override
        protected Integer compute() {
            int arrayLength = inputToSum.size();
            if (arrayLength < 2)
                return inputToSum.get(0);

            SumNumberTask leftSum = new SumNumberTask(inputToSum.subList(0, arrayLength/2 ));
            SumNumberTask rightSum = new SumNumberTask(inputToSum.subList(arrayLength/2 , arrayLength));

            rightSum.fork(); // computed asynchronously

            return leftSum.compute()// computed synchronously: immediately and in the current thread
                    + rightSum.join();
        }
    }
}