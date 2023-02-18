import java.util.ArrayList;
import java.util.HashMap;

public class Display {

	private HashMap<String, Integer> departures = new HashMap<String, Integer>();
	private ArrayList<IDisplayListener> listeners;

	public Display() {
		listeners = new ArrayList<>();
	}

	public void addListener(IDisplayListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IDisplayListener listener) {
		listeners.remove(listener);
	}

	public String updatedDisplay(String city, String track) {
		int[] tempPlaceArr = new int[2];
		String csvReturnListOfLeavingPassengers = "NoPassengersWantToThisDestination Source: updatedDisplay, Display ";
		System.out.println("Train to " + city + " today from Track " + track +". Source: updateDisplay, Display class");
		System.out.println("");
		for(IDisplayListener iterationListener:listeners){
			//Passenger (listener) will be informed through if method call
			if(iterationListener.updateEvent(city,track)){
				//when passengers matches to the destination city, true will be returned, so the passenger can leave the lounge, no longer observing needed
				//also passenger has to be removed from his seat in the lounge (row and column)
				//Lounge has to be informed...
				tempPlaceArr = iterationListener.getLoungePlace();
				System.out.println("Seatplace of passenger: " + tempPlaceArr[0] + tempPlaceArr[1] + " Source: updatedDisplay, Display");
				System.out.println("");
				csvReturnListOfLeavingPassengers += Integer.toString(tempPlaceArr[0]);
				csvReturnListOfLeavingPassengers += Integer.toString(tempPlaceArr[1]) + ";";
				System.out.println(iterationListener.getId());
				//removeListener(iterationListener);
			}//end if
		}//end for
		return csvReturnListOfLeavingPassengers;
	}//end method

	/*
	public String updateAndPresentInformation(String city, String track){
		System.out.println("Train to " + city + " today from Track " + track +".");
		updatedDisplay(city, track);
		return city+track;
	}
	 */
}