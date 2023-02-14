public class Passenger implements IDisplayListener {
	private int id;
	private IFTPState state;

	private DrivingLog drivingLog;

	public IFTPState getState() {
		return state;
	}

	public void setState(IFTPState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void promote(){
		state.promote(this);
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