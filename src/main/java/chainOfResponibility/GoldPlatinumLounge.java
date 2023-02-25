package chainOfResponibility;

public class GoldPlatinumLounge extends Lounge {
    public GoldPlatinumLounge(Lounge successor) {
        setSuccessor(successor);
    }

    public Passenger assign(Passenger passenger) {
        if (canHandlePassenger(passenger, "state.Gold") || canHandlePassenger(passenger, "Plat")) {
            //only first 4 chars possible
//			System.out.println("ClassesToMoreThanOnePattern.Passenger matches to GoldPlatinum ChainOfResponibility.Lounge. Source: assign, ChainOfResponibility.GoldPlatinumLounge");
            if (!isLoungeFull()) {
//				System.out.println("ChainOfResponibility.Lounge isn't full, passenger will be added");
                passenger = addPassengerToLounge(passenger);
//				System.out.println("");
            } else {
                System.out.println("ChainOfResponibility.Lounge is full, passenger can't be added");
            }
        } else {
            passenger = super.assign(passenger);
        }//end else

        return passenger;
    }//end method
}