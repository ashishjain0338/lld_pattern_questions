package parking_lot.app.model.ParkingSlot;

import parking_lot.app.model.Vehicle;

public abstract class ParkingSlot {
    private int loc = -1; // Location of ParkingSlot
    private boolean is_occupied = false;
    public Vehicle curVehicle = null;

    public boolean is_occupied(){
        return this.is_occupied;
    }

    public int  getLoc(){
        return this.loc;
    }

    public void updateLoc(int newLoc){
        this.loc = newLoc;
    }

    public ParkingSlot(int loc, boolean is_occupied){
        this.loc = loc;
        this.is_occupied = is_occupied;
    }

    public boolean allocateSlot(Vehicle vehicle){
        if(this.is_occupied){
            System.out.printf("Slot with loc = %d already occupied\n", loc);
            return false;
        }
        this.curVehicle = vehicle;
        this.is_occupied = true;
        return true;
    }

    public void releaseSlot(){
        this.curVehicle = null;
        this.is_occupied = false;
    }

}
