import java.util.ArrayList;

public class BlueLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();







	public Passenger assign(Passenger passenger, int startValue, int endValue) {
			if(canHandlePassenger(passenger,"Blue")){
				//only first 4 chars possible
				//System.out.println("Passenger: "+ passenger.getId() + " matches to Blue Lounge. Source: assign, BlueLounge");
				if(!isLoungeFull(passengers)){
					//System.out.println("Lounge isn't full, passenger will be added");
					addPassengerToLounge(passenger, passengers);
					System.out.println("");
				}
				else{
					System.out.println("Lounge is full, passenger can't be added");
				}
			}else{
				super.assign(passenger, startValue,endValue);
			}//end else
		return passenger;
	}//end method
}//end class