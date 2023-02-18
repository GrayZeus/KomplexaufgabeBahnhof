import java.util.ArrayList;

public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();







	public ArrayList<Passenger> assign(ArrayList<Passenger> actualPassengers, int startValue, int endValue) {
		for(int i = startValue ; i < endValue ; i++){
			if(canHandlePassenger(actualPassengers.get(i),"Blue")){
				//only first 4 chars possible
				System.out.println("Passenger: "+ actualPassengers.get(i).getId() + " matches to Blue Lounge. Source: assign, BlueLounge");
				if(!isLoungeFull(passengers)){
					//System.out.println("Lounge isn't full, passenger will be added");
					actualPassengers.set(i, addPassengerToLounge(actualPassengers.get(i), passengers));
					System.out.println("");
				}
				else{
					System.out.println("Lounge is full, passenger can't be added");
				}
			}else{
				super.assign(actualPassengers, startValue,endValue);
			}//end else
		}//end for
		return actualPassengers;
	}//end method
}