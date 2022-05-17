package activities;

public class Bicycle implements  BicycleParts,BicycleOperations{

    public  int gear;
    public  int currentSpeed;

    Bicycle(int gear,int currentSpeed){
        this.gear =gear;
        this.currentSpeed = currentSpeed;
    }

    public  void applyBrake(int decrement){
        currentSpeed= currentSpeed-decrement;
    }

    public  void speedUp(int increment){
        currentSpeed = currentSpeed+increment;
    }

    public  String bicycleDesc(){
        return("No of gears are "+ gear + "Speed of bicycle is " + currentSpeed);
    }
}
