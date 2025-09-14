package parking_lot;

import parking_lot.app.ParkingManager.ParkingManager;
import parking_lot.app.factory.ParkingManagerFactory;

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
        

    }
}