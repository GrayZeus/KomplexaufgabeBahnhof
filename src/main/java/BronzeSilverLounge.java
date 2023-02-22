import java.util.ArrayList;

public class BronzeSilverLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();

	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}



	public Passenger assign(Passenger passenger) {
		Passenger newPassenger = new Passenger(9999);
		if (canHandlePassenger(passenger, "Bron") || canHandlePassenger(passenger, "Silv")) {
			//only first 4 chars possible
			System.out.println("Passenger matches to BronzeSilver Lounge. Source: assign , BronzeSilverLounge");
			if (!isLoungeFull(passengers)) {
				System.out.println("Lounge isn't full, passenger will be added");
				newPassenger = addPassengerToLounge(passenger, passengers);
			} else {
				System.out.println("Lounge is full, passenger can't be added");
			}
		}else {
			newPassenger = super.assign(passenger);
		}
		return newPassenger;
	}//end method

}