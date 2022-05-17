package activities;

import java.util.Arrays;

public class Activity4 {

    public static void main(String[] args) {
        int[] nums ={4,2,18,35,67,23,12,35,80};
        System.out.println("Arrays before sorting " + Arrays.toString(nums));
        sortAlgo(nums);
        System.out.println("Arrays after sorting " + Arrays.toString(nums));
    }

    public  static  int[] sortAlgo(int[] nums){
        int[] sortedArray = new int[nums.length];
        int n =nums.length;
        for(int i = 1;i<n;i++){
            int key = nums[i];
            int j =i-1;

            while (j>=0&& nums[j]>key){
                nums[j+1]=nums[j];
                j=j-1;

            }
                nums[j+1] =key;

        }
        return  sortedArray;
    }
}
