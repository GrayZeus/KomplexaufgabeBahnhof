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

	public ArrayList<IDisplayListener> getListeners() {
		return listeners;
	}

	public void removeListener(IDisplayListener listener) {
		listeners.remove(listener);
	}

	public ArrayList<Integer> updatedDisplay(String city, String track) {
		ArrayList<Integer> seatPlacesToBeRemoved = new ArrayList<>();
		ArrayList<IDisplayListener> found = new ArrayList<>();
		int row;
		int column;

		System.out.println("Train to " + city + " today from Track " + track +". Source: updateDisplay, Display class");
		System.out.println("");

	//	System.out.println("Listeners size: " + listeners.size() + " Source: updatedDisplay, Display");


		for(int i = 0 ; i < listeners.size() ; i++){
			//Passenger (listener) will be informed through if method call
			if(listeners.get(i).updateEvent(city,track)){
				//save seat from passenger so lounge can empty the seat
				row = listeners.get(i).getLoungePlace()[0];
				column = listeners.get(i).getLoungePlace()[1];
				seatPlacesToBeRemoved.add(row); //ROWS are everytime even
				seatPlacesToBeRemoved.add(column); //COLUMNS are everytime odd
				//save the listener which has to be deleted, avoid concurrentModificationException
				found.add(listeners.get(i));
			}//end if
		}//end for
		//System.out.println("Listeners size: " + listeners.size() + " Source: updatedDisplay, Display");
		listeners.removeAll(found);
		/*
		for(int i:seatPlacesToBeRemoved){
			System.out.println("From Dispaly: " +i);
		}
		 */
		return seatPlacesToBeRemoved;
	}//end method
}