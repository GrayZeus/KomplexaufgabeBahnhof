import java.util.ArrayList;
import java.util.HashMap;

public class Display {

	private HashMap<String, Integer> departures = new HashMap<String, Integer>();
	private ArrayList<IDisplayListener> listeners;

	public Display(ArrayList<IDisplayListener> listeners) {
		listeners = new ArrayList<>();
	}

	public void addListener(IDisplayListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IDisplayListener listener) {
		listeners.remove(listener);
	}
	public void updatedDisplay() {
		for(IDisplayListener listener:listeners){
			listener.updateEvent();
		}
	}
}