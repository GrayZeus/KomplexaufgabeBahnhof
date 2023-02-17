public class BronzeSilverLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();

	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public boolean assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Bron") || canHandlePassenger(passenger,"Silv") ){
			//only first 4 chars possible
			System.out.println("Passenger matches to BronzeSilver Lounge. Source: assign , BronzeSilverLounge");
			if(!isLoungeFull()){
				System.out.println("Lounge isn't full, passenger will be added");
				addPassengerToLounge(passenger);
				return true;
			}
			else{
				System.out.println("Lounge is full, passenger can't be added");
				return false;
			}
		}else {
			super.assign(passenger);
		}
		return true;
		//true because maybe the next responsible class can handle the passenger
	}//end method

}