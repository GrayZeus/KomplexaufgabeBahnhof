public class Lounge {
	private Passenger[][] passengers;
	private Display display;
	private Lounge successor;

	public Lounge getSuccessor() {
		return successor;
	}

	public void setSuccessor(Lounge successor) {
		this.successor = successor;
	}

	public boolean canHandlePassenger(Passenger passenger, String passengerType) {
		//System.out.println("canHandlePassenger method from class Lounge: " + passenger.getState().toString().substring(0,4));
		return (passenger == null) || (passenger.getState().toString().substring(0,4).equals(passengerType));
	}

	public boolean assign(Passenger passenger) {
		if(getSuccessor() != null){
			getSuccessor().assign(passenger);
		}else{
			System.out.println("Unable to find correct passenger State: " + passenger.toString());
		}
		return false;
	}

	public void addDisplayListener(IDisplayListener listener){
		display.addListener(listener);
	}

	public boolean isLoungeFull(){
		for(int x = 0 ; x < 25 ; x++){
			for(int y = 0 ; y < 100 ; y++){
				if(passengers[x][y] == null){
					//Lounge is not empty
					return false;
				}//end if
			}//end 2 for
		}//end 1 for
		//if code reaches here, lounge is full
		return true;
	}//end method

	public boolean addPassengerToLounge(Passenger passenger){
		if(!isLoungeFull()){
			for(int x = 0 ; x < 25 ; x++) {
				for (int y = 0; y < 100; y++) {
					if(passengers[x][y] == null){
						passengers[x][y] = passenger;
					}//end if
				}//end 2 for
			}//end 1 for
		}//end if
		return false;
	}//end method


}