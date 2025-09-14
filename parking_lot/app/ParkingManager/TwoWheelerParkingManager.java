package parking_lot.app.ParkingManager;

import parking_lot.app.ParkingSlotFindingStrategy.FirstEmptySlotFindingStrategy;

public class TwoWheelerParkingManager extends ParkingManager{
    private static TwoWheelerParkingManager CLASS_INSTANCE = null;
    private TwoWheelerParkingManager(int intialSize){
        super(intialSize, "two", new FirstEmptySlotFindingStrategy());
    }

    public static TwoWheelerParkingManager getInstance(int intialSize){
        if(CLASS_INSTANCE == null){
            CLASS_INSTANCE = new TwoWheelerParkingManager(intialSize);
        }
        return CLASS_INSTANCE;
    }

    public String toString(){
        return "TwoWheelerParkingManager";
    }
}
