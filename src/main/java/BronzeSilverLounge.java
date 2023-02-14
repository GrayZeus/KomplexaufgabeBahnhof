public class BronzeSilverLounge extends Lounge {

	public BronzeSilverLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public void assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Bronze") || canHandlePassenger(passenger,"Silver") ){
			System.out.println("Passenger matches to BronzeSilver Lounge");
		}else{
			super.assign(passenger);
		}
	}//end method
}