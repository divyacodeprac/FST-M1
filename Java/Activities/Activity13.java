package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter the elements in array");

        while (scan.hasNextInt()){
            list.add(scan.nextInt());
        }


        Integer arr[] = list.toArray(new Integer[0]);
       System.out.println("Value at random index" +indexGen.nextInt(list.size()) +" is " + arr[indexGen.nextInt(list.size()-1)]);
       scan.close();
    }
}
