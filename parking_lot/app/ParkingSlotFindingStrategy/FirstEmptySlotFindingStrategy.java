package parking_lot.app.ParkingSlotFindingStrategy;

import parking_lot.app.model.ParkingSlot.ParkingSlot;
import java.util.ArrayList;

public class FirstEmptySlotFindingStrategy extends ParkingSlotFindingStrategy{
    public ParkingSlot findParkingSlot(ArrayList<ParkingSlot> lot){
        for(int i = 0; i < lot.size(); i++){
            ParkingSlot curSlot = lot.get(i);
            if(!curSlot.is_occupied()){
                return curSlot;
            }
        }
        return null;
    }
}
