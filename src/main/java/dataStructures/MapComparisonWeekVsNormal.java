package dataStructures;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class MapComparisonWeekVsNormal {
    public static void main(String[] args) throws Exception{
       String key1 = "dummy";
        Stack st = new Stack();;
        Map<String,String> myMap=new HashMap<>();
        Map<String,String> myWeakMap=new WeakHashMap<>();
        myMap.put(key1,"abc");
        myWeakMap.put(key1,"abc");
        System.out.println(myMap.get("dummy"));
        System.out.println(myWeakMap.get("dummy"));

        key1=null;
        System.gc();
        Thread.sleep(900);

        System.out.println("after gc");
        System.out.println(myMap.get("dummy"));
        System.out.printf("Week:");
        System.out.println(myWeakMap.get("dummy"));

       // await().atMost(10, TimeUnit.SECONDS)                .until(() -> myWeakMap.size() == 1);
    }

}
    class MyKey{
        @Override
        public String toString() {
            return "dummy";
        }
}
