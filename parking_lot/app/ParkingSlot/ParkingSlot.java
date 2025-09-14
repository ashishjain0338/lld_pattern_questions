package parking_lot.app.ParkingSlot;

public abstract class ParkingSlot {
    public int loc = -1; // Location of ParkingSlot
    public boolean is_occupied = false;

    public ParkingSlot(int loc, boolean is_occupied){
        this.loc = loc;
        this.is_occupied = is_occupied;
    }

}
