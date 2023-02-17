public class Lounge {
	private Passenger[][] passengers;
	private Display display;
	private Lounge successor;

	private SecurityControl securityControl;

	public Lounge getSuccessor() {
		return successor;
	}

	public void setSuccessor(Lounge successor) {
		this.successor = successor;
	}

	public boolean canHandlePassenger(Passenger passenger, String passengerType) {
		//System.out.println("canHandlePassenger method from class Lounge: " + passenger.getState().toString().substring(0,4));
		return (passenger == null) || (passenger.getState().toString().substring(0, 4).equals(passengerType));
	}

	public boolean assign(Passenger passenger) {
		if (getSuccessor() != null) {
			getSuccessor().assign(passenger);
		} else {
			System.out.println("Unable to find correct passenger State: " + passenger.toString());
		}
		return false;
	}

	public void addDisplayListener(IDisplayListener listener) {
		display.addListener(listener);
	}

	public boolean isLoungeFull() {
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 100; y++) {
				if (passengers[x][y] == null) {
					//Lounge is not empty
					return false;
				}//end if
			}//end 2 for
		}//end 1 for
		//if code reaches here, lounge is full
		return true;
	}//end method


	/**
	 * Adds the parameter passenger to the lounge.
	 * Does Security check, sets Passengers lounge place and add the passenger to the DisplayListener.
	 * @param passenger
	 * @return
	 */
	public boolean addPassengerToLounge(Passenger passenger) {
		int[] tempPlaceArray = new int[2];
		if (!isLoungeFull()) {
			for (int x = 0; x < 25; x++) {
				for (int y = 0; y < 100; y++) {
					if (passengers[x][y] == null) {
						tempPlaceArray[0] = x;
						tempPlaceArray[1] = y;
						passenger.setLoungePlace(tempPlaceArray);
						securityControl.doSecurityControl(passenger);
						passengers[x][y] = passenger;
						addDisplayListener(passenger);
						return true;
					}//end if
				}//end 2 for
			}//end 1 for
		}//end if
		return false;
	}//end method

	public void tellDisplaysToUpdate(String city, String trackID){
		display.updateAndPresentInformation(city, trackID);
	}
}
