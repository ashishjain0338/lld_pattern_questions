package parking_lot.app.factory;

import parking_lot.app.ParkingManager.FourWheelerParkingManager;
import parking_lot.app.ParkingManager.ParkingManager;
import parking_lot.app.ParkingManager.TwoWheelerParkingManager;

public class ParkingManagerFactory {


    public static ParkingManager getParkingManagerObj(String managerType, int intialSize){
        ParkingManager managerObj = null;
        switch (managerType) {
            case "two":
                managerObj = TwoWheelerParkingManager.getInstance(intialSize);
                break;
            case "four":
                managerObj = FourWheelerParkingManager.getInstance(intialSize);
                break;
            default:
                System.out.printf("Invalid ParkingManagerType : %s\n", managerType);
                break;
        }
        return managerObj;
    }
}