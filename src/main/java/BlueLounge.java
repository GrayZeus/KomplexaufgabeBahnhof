public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();


	public boolean assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Blue")){
			//only first 4 chars possible
			System.out.println("Passenger matches to Blue Lounge. Source: assign , BlueLounge");
			return true;
			// maybe more CODE
		}else{
			super.assign(passenger);
		}
		return false;
		//false because the next responsible class would be the normal lounge, there will no passenger be added
	}
}