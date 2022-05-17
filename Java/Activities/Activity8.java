package activities;

public class Activity8 {

    public static void main(String[] args)  {
        try {
            exceptionTest("hello");
            exceptionTest(null);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    public static void exceptionTest(String s) throws CustomException {

        if(s==null) throw new CustomException("String is null");
        else System.out.println("String is " +s);
    }
}
