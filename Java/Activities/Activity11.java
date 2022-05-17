package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"Blue");
        map.put(1,"Green");
        map.put(2,"Grey");
        map.put(3,"Red");
        map.put(4,"White");

        map.remove(2);
        System.out.println("Is green in the map " +map.containsValue("Green"));
        System.out.println("Size of map  "+map.size());
        System.out.println(map.values());
    }
}
