public class BlueLounge extends Lounge {

    public Passenger assign(Passenger passenger) {
        if (canHandlePassenger(passenger, "Blue")) {
            //only first 4 chars possible
            if (!isLoungeFull()) {
                passenger = addPassengerToLounge(passenger);
            } else {
            }
        } else {
            passenger = super.assign(passenger);
        }//end else
        return passenger;
    }//end method
}//end class