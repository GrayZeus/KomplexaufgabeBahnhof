public class BlueLounge extends Lounge {

	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Blue")){
			System.out.println("Passenger matches to Blue Lounge");

			// maybe more CODE
		}else{
			super.assign(passenger);
		}
	}
}