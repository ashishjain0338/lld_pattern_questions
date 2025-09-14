package parking_lot.app.factory;

import parking_lot.app.model.ParkingSlot.*;

public class ParkingSlotFactory {
    public static ParkingSlot getParkingSlotObj(String slotType, int loc, boolean is_occupied){
        ParkingSlot parkingSlotObj = null;
        switch (slotType) {
            case "two":
                parkingSlotObj = new TwoWheelerParkingSlot(loc, is_occupied);
                break;
            case "four":
                parkingSlotObj = new FourWheelerParkingSlot(loc, is_occupied);
                break;
            default:
                System.out.printf("Invalid Slottype : %s\n", slotType);
                break;
        }
        return parkingSlotObj;
    } 
}
