public class Passenger implements IDisplayListener {
	int id;

	private IFTPState state;

	public IFTPState getState() {
		return state;
	}

	public Passenger(int id){
		//initial state for all Passengers
		this.state = new Blue();
		this.id = id;
	}

	@Override
	public void updateEvent() {
		System.out.println("Updated event on Lounge Display");
	}
}