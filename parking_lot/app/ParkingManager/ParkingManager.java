package parking_lot.app.ParkingManager;

import java.util.ArrayList;
import parking_lot.app.ParkingSlot.*;
import parking_lot.app.ParkingSlotFindingStrategy.FirstEmptySlotFindingStrategy;
import parking_lot.app.ParkingSlotFindingStrategy.ParkingSlotFindingStrategy;
import parking_lot.app.factory.*;


abstract public class ParkingManager {
    // Can't use int as HashMap Key
    // HashMap<Integer, ParkingSlot> lot = new HashMap<>();
    ArrayList<ParkingSlot> lot = new ArrayList<>();
    ParkingSlotFindingStrategy slotFindingStrategyObj = new FirstEmptySlotFindingStrategy();
    String spotType = "";
    
    protected ParkingManager(int intialSize, String spotType){
        for(int i = 0;i < intialSize; i++){
            lot.add(ParkingSlotFactory.getParkingSlotObj(spotType, i, false));
        }
        this.spotType = spotType;
    }

    public void addParkingSlot(){
        ParkingSlot slot = ParkingSlotFactory.getParkingSlotObj(spotType, lot.size(), false);
        lot.add(slot);
    }

    public void removeParkingSlot(int spotLocation){
        if(spotLocation >= lot.size()){
            System.out.printf("The Parking-Slot with location : %d doesn't exist", spotLocation);
            return;   
        }

        lot.remove(spotLocation);
        System.out.println("Note: Removing ParkingSlot doesn't update the other slot's loc");
    }

    public ParkingSlot findParkingSlot(){
        return slotFindingStrategyObj.findParkingSlot();
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
            if(!curSlot.is_occupied){
                slotStatus = "_";
            }
            if(verbose == 0){
                System.out.printf("%s\t", slotStatus);
            }else{
                System.out.printf("%s, %d\t", slotStatus, curSlot.loc);
            }
            
        }
        System.out.println("");
    }

    public String toString(){
        return "ParkingManger";
    }

}
