package java9;

import model.Employee;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallImprovements {




    public static void main(String[] args) {
        List<LocalDate> listDate1=Stream.iterate(LocalDate.now(), d -> d.plusMonths(1))
                .limit(12).collect(Collectors.toList());

        List<LocalDate> listDateJava9=Stream.iterate(LocalDate.now(), d-> d.compareTo(LocalDate.now().plusMonths(12))<0, d -> d.plusMonths(1))
               .collect(Collectors.toList());

        listDateJava9.stream().forEach(System.out::println);

        Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty())
                .forEach(System.out::print);
        System.out.println();
        Stream.of("a","b","c","","e","f").dropWhile(s->!s.isEmpty())
                .forEach(System.out::println);

        List<List<Integer>> doubleListInt = List.of(List.of(1,2),List.of(3,4,5));

        doubleListInt.stream().flatMap(Collection::stream).takeWhile(integer -> !integer.equals(4))
                .forEach(System.out::print);


    }

}
