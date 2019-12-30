package ood.design.parkinglot.vehicles;

import ood.design.parkinglot.ParkingTicket;
import ood.design.parkinglot.constants.VehicleType;

/**
 * Created by George Fouche on 12/29/19.
 */
public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;


    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

}
