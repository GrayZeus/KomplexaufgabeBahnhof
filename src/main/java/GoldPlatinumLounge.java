public class GoldPlatinumLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	public GoldPlatinumLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Gold") || canHandlePassenger(passenger,"Platinum") ){
			System.out.println("Passenger matches to GoldPlatinum Lounge");
		}else{
			super.assign(passenger);
		}
	}//end method


}