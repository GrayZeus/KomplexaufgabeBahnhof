package observer;

public interface IDisplayListener {
    /**
     * Observer pattern method. ClassesToMoreThanOnePattern.Passenger is a listener, listener will be informed if this method is called.
     * If the destination city of the passenger matches to the city on the display, true will be returned.
     *
     * @param city
     * @param track
     * @return boolean
     */
    boolean updateEvent(String city, String track);

    int[] getLoungePlace();
}