import model.Employee;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false


        Stream<String> stream = list.stream().filter(element -> element.contains("d"));
        list.add("d after d");
        stream.forEach(System.out::println);


        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);




    }


}
