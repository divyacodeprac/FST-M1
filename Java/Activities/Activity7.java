package activities;

public class Activity7 {

    public static void main(String[] args) {
        MountainBike mb = new MountainBike(2,5,8);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(12);
        mb.applyBrake(4);
        System.out.println(mb.bicycleDesc());
    }
}
