import java.util.ArrayList;

public class BronzeSilverLounge extends Lounge {
	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}


	public Passenger assign(Passenger passenger) {

		if (canHandlePassenger(passenger, "Bron") || canHandlePassenger(passenger, "Silv")) {
			//only first 4 chars possible
//			System.out.println("Passenger matches to BronzeSilver Lounge. Source: assign , BronzeSilverLounge");
			if (!isLoungeFull()) {
//				System.out.println("Lounge isn't full, passenger will be added");
				passenger = addPassengerToLounge(passenger);
			} else {
				System.out.println("Lounge is full, passenger can't be added");
			}
		}else {
			passenger = super.assign(passenger);
		}
		return passenger;
	}//end method

}