package exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FibonacciServices {
    private static Map<Integer, Integer> cachedFibonacciMap = new HashMap<>();
    private static AtomicInteger maxCachedFibonacci = new AtomicInteger(2);
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public FibonacciServices(int initialLoad) {
        cachedFibonacciMap.put(1, 1);
        cachedFibonacciMap.put(2, 1);

        fillCachedFibonacciMap(initialLoad);
    }

    public Integer getFibonacci(int number) {
        if (number > maxCachedFibonacci.get()) {
            fillCachedFibonacciMap(number);
        }
        return cachedFibonacciMap.get(number);
    }

    private synchronized void fillCachedFibonacciMap(int number) {
        while (maxCachedFibonacci.get() < number) {
            final Integer  currentMaxCachedFibonacci= maxCachedFibonacci.incrementAndGet();
            logger.log(Level.INFO, "calculate cached value for: " + currentMaxCachedFibonacci);
            cachedFibonacciMap.put(currentMaxCachedFibonacci, cachedFibonacciMap.get(currentMaxCachedFibonacci-1) + cachedFibonacciMap.get(currentMaxCachedFibonacci-2));
            }
    }


}
