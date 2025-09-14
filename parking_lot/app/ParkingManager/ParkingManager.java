package parking_lot.app.ParkingManager;

import java.util.ArrayList;

import parking_lot.app.ParkingSlotFindingStrategy.FirstEmptySlotFindingStrategy;
import parking_lot.app.ParkingSlotFindingStrategy.ParkingSlotFindingStrategy;
import parking_lot.app.factory.*;
import parking_lot.app.model.Vehicle;
import parking_lot.app.model.ParkingSlot.*;


abstract public class ParkingManager {
    // Can't use int as HashMap Key
    // HashMap<Integer, ParkingSlot> lot = new HashMap<>();
    ArrayList<ParkingSlot> lot = new ArrayList<>();
    ParkingSlotFindingStrategy slotFindingStrategyObj = new FirstEmptySlotFindingStrategy();
    String spotType = "";
    
    protected ParkingManager(int intialSize, String spotType,ParkingSlotFindingStrategy findingStrategy){
        for(int i = 0;i < intialSize; i++){
            lot.add(ParkingSlotFactory.getParkingSlotObj(spotType, i, false));
        }
        this.spotType = spotType;
        this.slotFindingStrategyObj = findingStrategy;
    }

    public void addParkingSlot(){
        ParkingSlot slot = ParkingSlotFactory.getParkingSlotObj(spotType, lot.size(), false);
        lot.add(slot);
    }

    public void removeParkingSlot(int spotLocation){
        if(spotLocation >= lot.size()){
            System.out.printf("The Parking-Slot with location : %d doesn't exist\n", spotLocation);
            return;   
        }

        lot.remove(spotLocation);
        for(int i = spotLocation; i < lot.size(); i++){
            // Push Slots to fill the removed slot
            lot.get(i).updateLoc(i);
        }

        System.out.printf("Removed parking slot at location %d.%n", spotLocation);
        if (spotLocation < lot.size()) {
            System.out.println("Note: Locations of subsequent slots have been updated accordingly.");
        }
    }

    public ParkingSlot findParkingSlot(){
        return slotFindingStrategyObj.findParkingSlot(this.lot);
    }

    public boolean allocateParkingSlot(int slotIndex, Vehicle vehicle){
        if(slotIndex >=  this.lot.size()){
            System.out.printf("Can't Allocate Slot: Invalid slot-Index\n", slotIndex);
            return false;
        }
        return this.lot.get(slotIndex).allocateSlot(vehicle);
    }

    public boolean releaseParkingSlot(int slotIndex){
        if(slotIndex >=  this.lot.size()){
            System.out.printf("Can't Release Slot: Invalid slot-Index\n", slotIndex);
            return false;
        }
        this.lot.get(slotIndex).releaseSlot();
        return true;
    }

    public void printState(int verbose){
        /*
         * Prints the Current-State
         * verbose 0: lowest (default)
         * verbose 1: detailed
        */
        int line_break_after = 5;

        for(int i = 0;i < lot.size(); i++){
            if(i % line_break_after == 0){
                System.out.println("");
            }
            ParkingSlot curSlot = lot.get(i);
            String slotStatus = "";
            if(!curSlot.is_occupied()){
                slotStatus = "_";
            }else{
                char vehicleCode = curSlot.curVehicle.vehicleType.name().charAt(0);
                slotStatus = String.format("(%c, %s)",vehicleCode ,curSlot.curVehicle.id);
            }
            if(verbose == 0){
                System.out.printf("%s\t", slotStatus);
            }else{
                System.out.printf("%s, %d\t", slotStatus, curSlot.getLoc());
            }
            
        }
        System.out.println("");
    }

    public String toString(){
        return "ParkingManger";
    }

}
