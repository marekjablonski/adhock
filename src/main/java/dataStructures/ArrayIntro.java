package dataStructures;


import java.util.Arrays;

public class ArrayIntro {
  private String[] myArray;

    public <T> T[] reverseArray(T[] inputArray) {
        int inputArraySize = inputArray.length;
        T[] outputArray = Arrays.copyOf(inputArray, inputArraySize);
        for (int i = 0; i < inputArraySize; i++) {
            outputArray[inputArraySize - i - 1] = inputArray[i];
        }
        return outputArray;
    }

    public static void main(String[] args) throws Exception {
        Object[] array = new Object[10];
        array[0] = "lokesh";
        array[1] = 10;
        int intarray[] = { 1, 2, 3, 4, 5 };

        long larray[] = new long[5];
        Arrays.fill(larray, 30);
    }
}
