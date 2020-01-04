package ood.design.parkinglot;

/**
 * Created by George Fouche on 1/2/20.
 */
public class Slot {

    private VehicleSIZE vehicleSize;
    private boolean occupied;
    private boolean handicapped;
    private int vehicle_id;
    private int slotNumber;

    public Slot(int slotNumber, VehicleSIZE vehicleSIZE) {
        this.vehicleSize = vehicleSIZE;
        this.occupied = false;
        this.handicapped = false;
        this.slotNumber = slotNumber;
        vehicle_id = 0;


    }

    public VehicleSIZE getVehicleSize() {
        return vehicleSize;
    }

    public boolean isFree() {
        return (!occupied);
    }

    public void freeSlot() {
        this.occupied = false;
        this.vehicle_id = 0;
    }

    public void setHandicapped() {
        handicapped = true;

    }

    public boolean isHandicapped() {
        return handicapped;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public void occupySLot(int vehicle_id) {
        this.occupied = true;
        this.vehicle_id = vehicle_id;
    }


}
