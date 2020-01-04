package ood.design.parkinglot.vehicles;


/**
 * Created by George Fouche on 12/29/19.
 */
public abstract class Vehicle {

    private int vehicle_id;
    private VehicleSIZE vehicleSIZE;
    private boolean parked;
    private boolean handicapped;
    private int slotID = 0;


    public Vehicle(int vehicle_id, VehicleSIZE vehicleSIZE) {
        this.vehicle_id = vehicle_id;
        this.vehicleSIZE = vehicleSIZE;
        parked = false;
        handicapped = false;
    }


    public Vehicle(int vehicle_id, String s) {
        this.vehicle_id = vehicle_id;
        this.vehicleSIZE = VehicleSIZE.Normal;
        parked = false;
        handicapped = true;
    }


    public void setParked(int slotID) {
        parked = true;
        this.slotID = slotID;
    }


    public void setUnParked() {
        parked = false;
        this.slotID = 0; // reset the slotID
    }

    public boolean isHandicapped() {
        return handicapped;
    }

    public int getSlotId() {
        return slotID;
    }

    public int getVehicle_id() {
        return this.vehicle_id;
    }

    public VehicleSIZE getVehicleSize() {
        return vehicleSIZE;
    }


}
