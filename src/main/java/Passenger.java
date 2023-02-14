public class Passenger implements IDisplayListener {

	private IFTPState state;

	public IFTPState getState() {
		return state;
	}

	public Passenger(){
		//initial state for all Passengers
		this.state = new Blue();
	}


	@Override
	public void updateEvent() {

	}
}