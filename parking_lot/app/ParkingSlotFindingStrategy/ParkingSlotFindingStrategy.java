package parking_lot.app.ParkingSlotFindingStrategy;

import parking_lot.app.model.ParkingSlot.ParkingSlot;
import java.util.ArrayList;

public abstract class ParkingSlotFindingStrategy {
    public abstract ParkingSlot findParkingSlot(ArrayList<ParkingSlot> lot);
}
