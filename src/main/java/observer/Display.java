package observer;

import java.util.ArrayList;

public class Display {
    private ArrayList<IDisplayListener> listeners;

    public Display() {
        listeners = new ArrayList<>();
    }

    public ArrayList<IDisplayListener> getListeners() {
        return listeners;
    }

    public void addListener(IDisplayListener listener) {
        listeners.add(listener);
    }

    public ArrayList<Integer> updatedDisplay(String city, String track) {
        ArrayList<Integer> seatPlacesToBeRemoved = new ArrayList<>();
        ArrayList<IDisplayListener> found = new ArrayList<>();
        int row;
        int column;
//		System.out.println("");
//		System.out.println("task_classes.Train to " + city + " today from task_classes.Track " + track +". Source: observer.Display");
        for (int i = 0; i < listeners.size(); i++) {
            if (listeners.get(i).updateEvent(city, track)) {
                //save seat from passenger so lounge can empty the seat
                row = listeners.get(i).getLoungePlace()[0];
                column = listeners.get(i).getLoungePlace()[1];
                seatPlacesToBeRemoved.add(row); //ROWS are everytime even
                seatPlacesToBeRemoved.add(column); //COLUMNS are everytime odd
                //save the listener which has to be deleted, avoid concurrentModificationException
                found.add(listeners.get(i));
            }//end if
        }//end for
        listeners.removeAll(found);
//		System.out.println("");
//		System.out.println("All passengers who wanted to " + city + " have been deleted in listeners. Source: observer.Display");
        return seatPlacesToBeRemoved;
    }//end method
}