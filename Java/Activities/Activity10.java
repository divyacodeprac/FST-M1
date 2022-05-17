package activities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Activity10 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(4,2,7,1,8,12));
        System.out.println("Size of hash set is "+set.size());
        set.remove(8);
        set.remove(10);
        System.out.println("If element 8 is in the set " +set.contains(8));
        System.out.println("Updated set is " +set.toString());




    }
}
