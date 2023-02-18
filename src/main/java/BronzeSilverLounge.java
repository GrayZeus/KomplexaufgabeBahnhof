import java.util.ArrayList;

public class BronzeSilverLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();

	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}



	public ArrayList<Passenger> assign(ArrayList<Passenger> actualPassengers, int startValue, int endValue) {
		for(int i = startValue ; i < endValue ; i++) {
			if (canHandlePassenger(actualPassengers.get(i), "Bron") || canHandlePassenger(actualPassengers.get(i), "Silv")) {
				//only first 4 chars possible
				System.out.println("Passenger matches to BronzeSilver Lounge. Source: assign , BronzeSilverLounge");
				if (!isLoungeFull(passengers)) {
					System.out.println("Lounge isn't full, passenger will be added");
					actualPassengers.set(i, addPassengerToLounge(actualPassengers.get(i), passengers));
				} else {
					System.out.println("Lounge is full, passenger can't be added");
				}
			} else {
				super.assign(actualPassengers, startValue, endValue);
			}
		}//end for
		return actualPassengers;
	}//end method

}