package ood.design.parkinglot;

import ood.design.parkinglot.vehicles.Bike;
import ood.design.parkinglot.vehicles.Car;
import ood.design.parkinglot.vehicles.HandicappedVehicle;
import ood.design.parkinglot.vehicles.Vehicle;

/**
 * Created by George Fouche on 1/2/20.
 */
public class ParkingLotApp {


    public static void main(String[] args) {
        int noOfSLots = 100;
        int noOFHandicapSlots = 10;
        int noOfSmallSLots = 30;
        int noOfNormalSlots = 30;

        /** Create the parking lot */
        ParkingLot parkingLot = new ParkingLot(noOfSLots, noOfSmallSLots, noOfNormalSlots, noOFHandicapSlots);


        /** Parked Vehicles **/
        Vehicle bike = new Bike(1);
        Vehicle car = new Car(2);
        Vehicle hcVehicle = new HandicappedVehicle(3);
        parkingLot.park(bike);
        parkingLot.park(car);
        parkingLot.park(hcVehicle);

        parkingLot.unpark(car);


    }
}
