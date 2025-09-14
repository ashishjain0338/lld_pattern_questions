package parking_lot;

import parking_lot.app.ParkingManager.ParkingManager;
import parking_lot.app.factory.ParkingManagerFactory;
import parking_lot.app.model.Vehicle;

public class Main{

    public static void main(String[] args){
        ParkingManager twoVehicleObj = ParkingManagerFactory.getParkingManagerObj("two", 12);
        twoVehicleObj.printState(1);
        twoVehicleObj.addParkingSlot();
        twoVehicleObj.addParkingSlot();
        twoVehicleObj.addParkingSlot();
        twoVehicleObj.removeParkingSlot(2);
        twoVehicleObj.removeParkingSlot(3);
        twoVehicleObj.printState(1);
        Vehicle vehicleObj1 = new Vehicle("two_wheeler", "alpha");
        twoVehicleObj.allocateParkingSlot(0, vehicleObj1);
        twoVehicleObj.printState(1);
        System.out.println(twoVehicleObj.findParkingSlot().getLoc());
        twoVehicleObj.removeParkingSlot(1);
        System.out.println(twoVehicleObj.findParkingSlot().getLoc());
        twoVehicleObj.releaseParkingSlot(0);
        twoVehicleObj.printState(1);
        System.out.println(twoVehicleObj.findParkingSlot().getLoc());
    }
}