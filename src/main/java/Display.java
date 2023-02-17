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

	public void updatedDisplay(String city, String track) {
		for(IDisplayListener listener:listeners){
			if(listener.updateEvent(city,track)){
				removeListener(listener);
				//Lounge has to be informed...
			}//end if
		}//end for
	}//end method

	public String updateAndPresentInformation(String city, String track){
		System.out.println("Train to " + city + " today from Track " + track +".");
		updatedDisplay(city, track);
		return city+track;
	}
}