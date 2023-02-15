public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();


	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Blue")){
			System.out.println("Passenger matches to Blue Lounge");

			// maybe more CODE
		}else{
			super.assign(passenger);
		}
	}
}