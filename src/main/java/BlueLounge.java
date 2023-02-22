import java.util.ArrayList;

public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();







	public Passenger assign(Passenger passenger) {
		Passenger newPassenger = new Passenger(9999);
		if(canHandlePassenger(passenger,"Blue")){
			//only first 4 chars possible
			//System.out.println("Passenger: "+ passenger.getId() + " matches to Blue Lounge. Source: assign, BlueLounge");
			if(!isLoungeFull(passengers)){
				//System.out.println("Lounge isn't full, passenger will be added");
				newPassenger = addPassengerToLounge(passenger, passengers);
				//System.out.println("");
			}
			else{
				System.out.println("Lounge is full, passenger can't be added");
			}
		}else{
			newPassenger = super.assign(passenger);
		}//end else

		/*
		Display tempDisplay = getDisplay();
		ArrayList<IDisplayListener> tempDispListeners = tempDisplay.getListeners();
		Passenger p;
		for(int i = 0 ; i < tempDispListeners.size() ; i++){
			p = (Passenger) tempDispListeners.get(i);
			System.out.println("BLUELOUNGE Passenger: " + p + " Seats at row: " + p.getLoungePlace()[0] +
					" column: " + p.getLoungePlace()[1] + " Source: moveCustomAmountOfPassengersToLounges, TrainStation ");
		}//end
		 */


		return newPassenger;
	}//end method
}//end class