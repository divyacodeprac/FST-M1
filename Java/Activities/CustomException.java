package activities;

public class CustomException  extends Exception{
    String message =null ;

    CustomException(String message){
        this.message = message;
    }

    public  String getMessage(){
        return  message;
    }
}
