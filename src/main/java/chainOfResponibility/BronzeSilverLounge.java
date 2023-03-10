package chainOfResponibility;

import classesToMoreThanOnePattern.Passenger;

public class BronzeSilverLounge extends Lounge {
    public BronzeSilverLounge(Lounge successor) {
        setSuccessor(successor);
    }


    public Passenger assign(Passenger passenger) {

        if (canHandlePassenger(passenger, "state.Bron") || canHandlePassenger(passenger, "state.Silv")) {
            //only first 10 chars possible
//			System.out.println("ClassesToMoreThanOnePattern.Passenger matches to BronzeSilver ChainOfResponibility.Lounge. Source: assign , ChainOfResponibility.BronzeSilverLounge");
            if (!isLoungeFull()) {
//				System.out.println("ChainOfResponibility.Lounge isn't full, passenger will be added");
                passenger = addPassengerToLounge(passenger);
            } else {
                System.out.println("ChainOfResponibility.Lounge is full, passenger can't be added");
            }
        } else {
            passenger = super.assign(passenger);
        }
        return passenger;
    }//end method

}