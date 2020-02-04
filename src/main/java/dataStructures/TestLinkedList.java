package dataStructures;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestLinkedList {
    public Set<String> mySet= new TreeSet<String>();
    static Queue<String> testList2= new LinkedList<>();
    static List<String> testList3= new ArrayList<>();
    static List<String> testList= new CopyOnWriteArrayList<>();
    public Set<String> mySet2= new CopyOnWriteArraySet<String>();
    Deque<String> stack = new ArrayDeque<>();
    static{

        testList.add("d1");
        testList2.add("d2");
    }

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers
                = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(10);
        List<Integer> result = new LinkedList<>();
        iterator.forEachRemaining(result::add);
        result.stream().forEach(System.out::println);

    }
    }

    //
    // EnumSet



