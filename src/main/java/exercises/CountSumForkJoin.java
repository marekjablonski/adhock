package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountSumForkJoin extends RecursiveTask<Integer> {
    private List<Integer> inputToSum = new ArrayList<>();


    @Override
    protected Integer compute() {
    if (inputToSum.size()>1)

        return 0;
    }
}
