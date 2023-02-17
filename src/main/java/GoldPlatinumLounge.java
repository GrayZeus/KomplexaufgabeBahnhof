public class GoldPlatinumLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	public GoldPlatinumLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public boolean assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Gold") || canHandlePassenger(passenger,"Plat") ){
			//only first 4 chars possible
			System.out.println("Passenger matches to GoldPlatinum Lounge. Source: assign, GoldPlatinumLounge");
			if(!isLoungeFull()){
				System.out.println("Lounge isn't full, passenger will be added");
				addPassengerToLounge(passenger);
				return true;
			}
			else{
				System.out.println("Lounge is full, passenger can't be added");
				return false;
			}
		}else{
			super.assign(passenger);
		}
		return true;
		//true because maybe the next responsible class can handle the passenger
	}//end method

}