public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();


	public boolean assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Blue")){
			//only first 4 chars possible
			System.out.println("Passenger matches to Blue Lounge. Source: assign , BlueLounge");
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
		return false;
		//false because the next responsible class would be the normal lounge, there will no passenger be added
	}
}