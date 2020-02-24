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
    public static void main(String[] args) {
        final Integer age;

       age=123;
      // age=344;

        Optional<String> result =  Stream.of("bb", "c", "d")
                .collect(maxBy(Comparator.naturalOrder()));

        List<Integer> ints1 = IntStream.of(3, 1, 4, 1, 5, 9)
                //   .collect(Collectors.toList());
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> ints2 = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> ints4 = IntStream.of(3, 1, 4, 1, 5, 9)
                //   .collect(Collectors.toList());
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> ints3 = Stream.of(3, 1, 4, 1, 5, 9)
                .collect(Collectors.toList());


//        List<String> resultCollectingAndThen = Stream.of("bb", "c", "d")
//                .collect(collectingAndThen(toList(), ImmutableList::copyOf));


        String[] list= new  String[3];
        Object[] obj =list;





        List<String> listWithDuplicates2 = Arrays.asList("a", "bb", "c", "d", "bb");
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result12 = listWithDuplicates.stream().collect(toSet());
        HashSet<String> resultHashSet = (HashSet<String>) listWithDuplicates.stream().collect(toSet());
        TreeSet<String> resultTreeSet = (TreeSet<String>) listWithDuplicates.stream().collect(toSet());
       // TreeSet<String> resultTreeSet2 = listWithDuplicates.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.printf(resultHashSet.toString());
        System.out.printf(result.toString());

////MAP

        Map<String, Integer> resultMap = listWithDuplicates.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));



    }

}


