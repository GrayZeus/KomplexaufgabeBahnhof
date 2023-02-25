package chainOfResponibility;

import classesToMoreThanOnePattern.Passenger;

public class BlueLounge extends Lounge {

    public Passenger assign(Passenger passenger) {
        if (canHandlePassenger(passenger, "state.Blue")) {
            //only first 10 chars possible
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