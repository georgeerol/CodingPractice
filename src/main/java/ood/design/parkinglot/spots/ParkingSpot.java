package ood.design.parkinglot.spots;

import ood.design.parkinglot.vehicles.Vehicle;
import ood.design.parkinglot.constants.ParkingSpotType;

/**
 * Created by George Fouche on 12/29/19.
 */
public abstract  class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;


    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean isFree() {
        return this.free;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }


}
