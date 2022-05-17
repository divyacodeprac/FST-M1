package activities;

public class Activity2 {
    public static void main(String[] args) {

        int[] numbers = {10, 77, 10, 54, -11,10};
        System.out.println(result(numbers,10,30));


    }

    public  static boolean result(int[] nums,int searchElement,int fixedSum){
        boolean isSum = false;
        int sum = 0;
        for(int n:nums){
            if(n==searchElement){
                sum=sum+n;
            }
        }
        if(sum==fixedSum) return true;

        return  isSum;
    }
}
