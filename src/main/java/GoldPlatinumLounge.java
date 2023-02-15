public class GoldPlatinumLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	public GoldPlatinumLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Gold") || canHandlePassenger(passenger,"Plat") ){
			//only first 4 chars possible
			System.out.println("Passenger matches to GoldPlatinum Lounge. Source: assign, GoldPlatinumLounge");
		}else{
			super.assign(passenger);
		}
	}//end method


}