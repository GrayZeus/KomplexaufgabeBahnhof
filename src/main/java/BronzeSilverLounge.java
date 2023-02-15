public class BronzeSilverLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();

	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Bron") || canHandlePassenger(passenger,"Silv") ){
			//only first 4 chars possible
			System.out.println("Passenger matches to BronzeSilver Lounge. Source: assign , BronzeSilverLounge");
		}else{
			super.assign(passenger);
		}
	}//end method
}