public class Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Lounge successor;
	private Display display;

	public Lounge getSuccessor() {
		return successor;
	}

	public void setSuccessor(Lounge successor) {
		this.successor = successor;
	}

	public boolean canHandlePassenger(Passenger passenger, String passengerType) {
		return (passenger == null) || (passenger.getState().toString().equals(passengerType));
	}

	public void assign(Passenger passenger) {
		if(getSuccessor() != null){
			getSuccessor().assign(passenger);
		}else{
			System.out.println("Unable to find correct passenger State: " + passenger.toString());
		}
	}

}