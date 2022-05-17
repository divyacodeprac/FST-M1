package activities;

public class MountainBike extends  Bicycle{

    int seatHeight;
    MountainBike(int gear, int currentSpeed,int seatHeight){
        super(gear,currentSpeed);
        this.seatHeight= seatHeight;
    }

    public  void setHeight(int newValue){
        seatHeight = newValue;
    }

    public  String bicycleDesc(){
        return(super.bicycleDesc() + "Seat Height " +seatHeight);
    }
}
