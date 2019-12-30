package ood.design.parkinglot.workers;

import ood.design.parkinglot.spots.ParkingSpot;
import ood.design.parkinglot.structure.*;

/**
 * Created by George Fouche on 12/29/19.
 */
public class Admin extends Account {

    public boolean addParkingFloor(ParkingFloor floor) { return false; }
    public boolean addParkingSpot(String floorName, ParkingSpot spot){return false;}
    public boolean addParkingDisplayBoard(String floorName,ParkingDisplayBoard displayBoard){return false;}
    public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel){return false;}
    public boolean addEntrancePanel(EntrancePanel entrancePanel){return false;}
    public boolean addExitPanel(ExitPanel exitPanel){return false;}

    @Override
    public boolean resetPassword() {
        return false;
    }
}
