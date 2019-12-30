package ood.design.parkinglot.workers;

/**
 * Created by George Fouche on 12/29/19.
 */
public class ParkingAttendant extends Account {
    public boolean processTicket(String ticketNumber) { return true ;}


    @Override
    public boolean resetPassword() {
        return false;
    }
}
