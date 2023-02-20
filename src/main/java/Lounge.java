import java.util.ArrayList;

public class Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private Lounge successor;

	private SecurityControl securityControl = new SecurityControl();

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

	public Passenger assign(Passenger passenger, int startValue, int endValue) {
		//for (int i = startValue; i < endValue; i++) {
			if (getSuccessor() != null) {
				getSuccessor().assign(passenger,  startValue, endValue);
			} else {
				System.out.println("Unable to find correct passenger State. Source: assign, Lounge");
			}
			return passenger;
		//}//end for
	}//end method

	public void addDisplayListener(IDisplayListener listener) {
		display.addListener(listener);
	}

	public boolean isLoungeFull(Passenger[][] passengers) {
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
	public Passenger addPassengerToLounge(Passenger passenger, Passenger[][] passengersForFullCheck) {
		int[] tempPlaceArray = new int[2];
		if (!isLoungeFull(passengersForFullCheck)) {
			for (int x = 0; x < 25; x++) {
				for (int y = 0; y < 100; y++) {
					if (passengers[x][y] == null) {
						tempPlaceArray[0] = x;
						tempPlaceArray[1] = y;
						passenger.setLoungePlace(tempPlaceArray);
						System.out.println("Passengers assigned seat over passenger object: " + passenger.getLoungePlace()[0] +":" + passenger.getLoungePlace()[1] + " Source: addPassengerToLounge, Lounge" );
						securityControl.doSecurityControl(passenger);
						passengers[x][y] = passenger;
						addDisplayListener(passenger);
						return passenger;
					}//end if
				}//end 2 for
			}//end 1 for
		}//end if
		return passenger;
	}//end method

	public void tellDisplayToUpdate(String city, String trackID){
		String CSVlistOfPassengersWhoLeaveTheLounge;
		CSVlistOfPassengersWhoLeaveTheLounge = display.updatedDisplay(city, trackID);
		System.out.println(CSVlistOfPassengersWhoLeaveTheLounge);
	}
}
