package activities;

import java.util.ArrayList;

public class Activity9 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Andrew");
        names.add("Evan");
        names.add("Sam");
        names.add("Rick");

        for(String name:names){
            System.out.println("Names are : "+ name);
        }

        System.out.println("Third name in the list "+names.get(2));
        System.out.println("Evan is found in the list "+names.contains("Evan"));
        System.out.println("Size of arraylist is  : "+names.size());
        names.remove("John");
        System.out.println("Size of the arraylist after removing element " +names.size());

    }
}
