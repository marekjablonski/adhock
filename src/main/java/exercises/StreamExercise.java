package exercises;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


import static java.lang.Math.abs;
import static java.util.stream.Collectors.*;

public class StreamExercise {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumDiagonal = 0;
        int arraySize = arr.get(0).size();

        for (int i = 0; i < arr.get(0).size(); i++) {
            sumDiagonal=sumDiagonal+arr.get(i).get(i)-arr.get(i).get(arraySize-i-1);
        }
        return sumDiagonal>0 ? sumDiagonal : -sumDiagonal;
    }

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aBigerCount = 0;
        int bBigerCount = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aBigerCount++;
            } else if (a.get(i) < b.get(i)) {
                bBigerCount++;
            }
        }
        return Arrays.asList(aBigerCount, bBigerCount);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = compareTriplets(a, b);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();

        List<Integer> testList=Arrays.asList(1,3,3);
        System.out.println(testList.size());
        List<Integer> testList2=Arrays.asList(4,2,1);
        List<Integer> testList3=Arrays.asList(4,2,1);
        int a=diagonalDifference(Arrays.asList(testList,testList2,testList3));
        System.out.printf("ruznieca:"+a);
  }
}


