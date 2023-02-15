public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();


	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Blue")){
			//only first 4 chars possible
			System.out.println("Passenger matches to Blue Lounge. Source: assign , BlueLounge");

			// maybe more CODE
		}else{
			super.assign(passenger);
		}
	}
}