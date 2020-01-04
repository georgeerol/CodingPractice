package ood.design.parkinglot;

import ood.design.parkinglot.vehicles.Vehicle;
import ood.design.parkinglot.vehicles.VehicleSIZE;

/**
 * Created by George Fouche on 1/2/20.
 */
public class ParkingLot {

    /**
     * Hold the number of empty slots of each size
     */
    private int noOfSlots;
    private int noOfSmallSlots;
    private int noOfNormalSlots;
    private int noOFHandicapSlots;
    private int noOfLargeSlots;
    private int emptySlots;
    private int total_vehicles_in_lot;
    private Slot[] slotList;

    public ParkingLot(int noOfSlots, int noOfSmallSlots, int noOfNormalSlots, int noOFHandicapSlots) {

        this.noOfSlots = noOfSlots;
        this.emptySlots = this.noOfSlots;
        this.noOfSmallSlots = noOfSmallSlots;
        this.noOfNormalSlots = noOfNormalSlots;
        this.noOFHandicapSlots = noOFHandicapSlots;
        this.noOfLargeSlots = noOfSlots - (noOFHandicapSlots + noOfSmallSlots + noOfNormalSlots);
        this.slotList = new Slot[noOfSlots];


        initializeHandicappedSpots();
        initializeSmallSpots();
        initializeNormalSpots();
        initializeLargeSlots();


    }

    public void initializeHandicappedSpots() {
        for (int i = 0; i <= noOFHandicapSlots - 1; i++) {
            slotList[i] = new Slot(i + 1, VehicleSIZE.Normal);
            slotList[i].setHandicapped();
        }
    }

    public void initializeSmallSpots() {
        for (int i = noOFHandicapSlots - 1; i <= noOfSmallSlots - 1; i++) {
            slotList[i] = new Slot(i + 1, VehicleSIZE.Small);
        }
    }

    public void initializeNormalSpots() {
        for (int i = noOfSmallSlots - 1; i <= noOfNormalSlots; i++) {
            slotList[i] = new Slot(i + 1, VehicleSIZE.Normal);
        }
    }

    public void initializeLargeSlots() {
        for (int i = noOfNormalSlots - 1; i <= noOfLargeSlots - 1; i++) {
            slotList[i] = new Slot(i + 1, VehicleSIZE.Large);
        }
    }


    public Slot getSlot(String h) {
        for (int i = 0; i < noOFHandicapSlots; i++) {
            if (slotList[i].isFree())
                return slotList[i];
        }
        return null;
    }

    public Slot getSlot(VehicleSIZE vehicleSIZE) {
        for (int i = noOfNormalSlots - noOFHandicapSlots; i < noOfSlots; i++) {
            if (slotList[i].getVehicleSize() == vehicleSIZE && slotList[i].isFree())
                return slotList[i];
        }

        return null;
    }


    public boolean park(Vehicle vehicle) {

        if (emptySlots <= 0) {
            System.out.println("Sorry there's no more slots. Parking is full");
            return false;
        } else {

            //Check if handicapped and get a slot
            Slot mySlot;
            if (vehicle.isHandicapped())
                mySlot = getSlot("Handicapped");
            else
                mySlot = getSlot(vehicle.getVehicleSize());

            if (mySlot == null) {
                System.out.println("No Parking spot available");
                return false;
            } else {
                // go an available spot
                // set a vehicle parked in the slot
                mySlot.occupySLot(vehicle.getVehicle_id());
                // let's vehicle know that is is parked and which slot
                vehicle.setParked(mySlot.getSlotNumber());

                this.total_vehicles_in_lot++;
                this.emptySlots--; //reduce the number of empty slots

                System.out.println("Vehicle with ID " + vehicle.getVehicle_id() + " is stored in Slot: " + mySlot.getSlotNumber());
                System.out.println("Total vehicles in the lot: " + total_vehicles_in_lot);
                System.out.println("Empty Slots left: " + emptySlots);
                System.out.println();
                return true;
            }

        }
    }

    public boolean unpark(Vehicle vehicle) {
        // Get the slot number from the vehicle and unpark it


        try {

            int slotID = vehicle.getSlotId();
            Slot mySlot = slotList[slotID - 1];

            mySlot.freeSlot();
            System.out.println("SLot Freed: " + slotID);

            //unpark the vehicle
            vehicle.setUnParked();

            this.total_vehicles_in_lot--;//decrease the number of vehicles in the slot
            this.emptySlots++;//increase the number of empty slots

            System.out.println("Total vehicles in the lot: " + total_vehicles_in_lot);
            System.out.println("Empty Slots left: " + emptySlots);
            System.out.println();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The vehicle is not parked in the parking lot.");
        }
        return true;
    }
}
