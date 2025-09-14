package parking_lot.app.model;

public class Vehicle {
    public VehicleType vehicleType;
    public String id;

    public Vehicle(String vehicleType, String id){
        this.vehicleType = VehicleType.valueOf(vehicleType.toUpperCase());
        this.id = id;
    }
}
