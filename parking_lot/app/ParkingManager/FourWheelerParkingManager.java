package parking_lot.app.ParkingManager;

import parking_lot.app.ParkingSlotFindingStrategy.FirstEmptySlotFindingStrategy;

public class FourWheelerParkingManager extends ParkingManager{
    private static FourWheelerParkingManager CLASS_INSTANCE = null;

    private FourWheelerParkingManager(int intialSize){
        super(intialSize, "four", new FirstEmptySlotFindingStrategy());
    }

    public static FourWheelerParkingManager getInstance(int intialSize){
        if(CLASS_INSTANCE == null){
            CLASS_INSTANCE = new FourWheelerParkingManager(intialSize);
        }
        return CLASS_INSTANCE;
    }

    public String toString(){
        return "FourWheelerParkingManager";
    }
}
