import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lounge {
    protected Passenger[][] passengers;
    protected Display display;
    protected SecurityControl securityControl;
    private Lounge successor;
    private LocalDateTime time;

    //CONSTRUCTOR ####################################################################################################
    public Lounge() {
        passengers = new Passenger[25][100];
        display = new Display();
        securityControl = new SecurityControl();
    }

    //GETTER AND SETTERS ###############################################################################################
    public Lounge getSuccessor() {
        return successor;
    }

    public void setSuccessor(Lounge successor) {
        this.successor = successor;
    }

    //METHODS #########################################################################################################
    public Passenger assign(Passenger passenger) {
        //for (int i = startValue; i < endValue; i++) {
        if (getSuccessor() != null) {
            passenger = getSuccessor().assign(passenger);
        } else {
            System.out.println("Unable to find correct passenger State. Source: assign, Lounge");
        }
        return passenger;
        //}//end for
    }//end method

    public boolean canHandlePassenger(Passenger passenger, String passengerType) {
        //System.out.println("canHandlePassenger method from class Lounge: " + passenger.getState().toString().substring(0,4));
        return (passenger == null) || (passenger.getState().toString().substring(0, 4).equals(passengerType));
    }

    public void addDisplayListener(IDisplayListener listener) {
        display.addListener(listener);
    }

    public boolean isLoungeFull() {
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
     *
     * @param passenger
     * @return
     */
    public Passenger addPassengerToLounge(Passenger passenger) {
        int[] tempPlaceArray = new int[2];
        if (!isLoungeFull()) {
            for (int x = 0; x < 25; x++) {
                for (int y = 0; y < 100; y++) {
                    if (passengers[x][y] == null) {
                        securityControl.doSecurityControl(passenger);
                        //free place found
                        tempPlaceArray[0] = x;
                        tempPlaceArray[1] = y;
                        passenger.setLoungePlace(tempPlaceArray);
                        //record Journey
                        time = LocalDateTime.now();
                        passenger.recordJourney(time);
                        //save passenger in Lounge
                        passengers[x][y] = passenger;
                        addDisplayListener(passenger);
                        return passenger; //return value here is important!
                    }//end if
                }//end 2 for
            }//end 1 for
        }//end if
        return passenger;
    }//end method

    public void tellDisplayToUpdate(String city, String trackID) {
        ArrayList<Integer> seatPlacesToBeRemoved = display.updatedDisplay(city, trackID);
        removeCollectionOfPassengers(seatPlacesToBeRemoved);
        //System.out.println("Size of Arraylist: " + seatPlacesToBeRemoved.size());
        //outputAllElementsOfCollection(seatPlacesToBeRemoved);
    }

    public void removeCollectionOfPassengers(ArrayList<Integer> seatPlacesToBeRemoved) {
        //pairs of row and column
        //even index is a row, odd index is a column
        for (int i = 0; i < seatPlacesToBeRemoved.size(); i += 2) {
            //System.out.println("Iteration number: "+ i);
            passengers[seatPlacesToBeRemoved.get(i)][seatPlacesToBeRemoved.get(i + 1)] = null;
        }//end for
//		System.out.println();
//		System.out.println("The passengers who go to their train now, have been removed from the lounge. Source: Lounge");
    }//end method

}
