import java.util.ArrayList;

public class Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private Lounge successor;

	private SecurityControl securityControl = new SecurityControl();

	public Lounge getSuccessor() {
		return successor;
	}

	public Display getDisplay() {
		return display;
	}

	public void setSuccessor(Lounge successor) {
		this.successor = successor;
	}

	public boolean canHandlePassenger(Passenger passenger, String passengerType) {
		//System.out.println("canHandlePassenger method from class Lounge: " + passenger.getState().toString().substring(0,4));
		return (passenger == null) || (passenger.getState().toString().substring(0, 4).equals(passengerType));
	}

	public Passenger assign(Passenger passenger) {
		Passenger newPassenger = new Passenger(9999);
		//for (int i = startValue; i < endValue; i++) {
			if (getSuccessor() != null) {
				newPassenger = getSuccessor().assign(passenger);
			} else {
				System.out.println("Unable to find correct passenger State. Source: assign, Lounge");
			}
			return newPassenger;
		//}//end for
	}//end method

	public void addDisplayListener(IDisplayListener listener) {
		display.addListener(listener);
	}

	public boolean isLoungeFull(Passenger[][] passengers) {
		for (int a = 0; a < 25; a++) {
			for (int y = 0; y < 100; y++) {
				if (passengers[a][y] == null) {
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
						//System.out.println("");
						//System.out.println("Passengers: " + passenger +  " assigned seat over passenger object: " + passenger.getLoungePlace()[0] +":" + passenger.getLoungePlace()[1] + " Source: addPassengerToLounge, Lounge" );
						securityControl.doSecurityControl(passenger);
						passengers[x][y] = passenger;
						addDisplayListener(passenger);



						ArrayList<IDisplayListener> tempDispListeners = getDisplay().getListeners();
						Passenger p;
							p = (Passenger) tempDispListeners.get(y);
							//System.out.println("LOUNGE Passenger: " + p + " Seats at row: " + p.getLoungePlace()[0] + " column: " +
							//	p.getLoungePlace()[1]);
						return passenger; //return value here is important!
					}//end if
				}//end 2 for
			}//end 1 for
		}//end if
		return passenger;
	}//end method

	public void tellDisplayToUpdate(String city, String trackID){
		ArrayList<Integer> seatPlacesToBeRemoved = display.updatedDisplay(city, trackID);
		removeCollectionOfPassengers(seatPlacesToBeRemoved);
		//System.out.println("Size of Arraylist: " + seatPlacesToBeRemoved.size());
		//outputAllElementsOfCollection(seatPlacesToBeRemoved);
	}

	public void outputAllElementsOfCollection(ArrayList<Integer> seatPlacesToBeRemoved){
		for(int i = 0 ; i < seatPlacesToBeRemoved.size() ; i++){
			System.out.println(seatPlacesToBeRemoved.get(i));
		}//end for
	}

	public void removeCollectionOfPassengers(ArrayList<Integer> seatPlacesToBeRemoved){
		//pairs of row and column
		//even index is a row, odd index is a column
		for (int i = 0 ; i < seatPlacesToBeRemoved.size() ; i+=2){
			//System.out.println("Iteration number: "+ i);
			passengers[seatPlacesToBeRemoved.get(i)][seatPlacesToBeRemoved.get(i+1)] = null;
			//System.out.println("Passenger at seat row: " + seatPlacesToBeRemoved.get(i) + " column: " +
			//		seatPlacesToBeRemoved.get(i+1) + " has been removed. Source: removeCollectionPassengers, Lounge");
		}//end for
	}//end method
}
