import java.util.ArrayList;

public class GoldPlatinumLounge extends Lounge {
	private Passenger[][] passengers = new Passenger[25][100];
	private Display display = new Display();
	private SecurityControl securityControl = new SecurityControl();
	public GoldPlatinumLounge(Lounge successor) {
		setSuccessor(successor);
	}




	public Passenger assign(Passenger passenger, int startValue, int endValue) {
		//for(int i = startValue ; i < endValue ; i++){
			if(canHandlePassenger(passenger,"Gold") || canHandlePassenger(passenger,"Plat") ){
				//only first 4 chars possible
				System.out.println("Passenger matches to GoldPlatinum Lounge. Source: assign, GoldPlatinumLounge");
				if(!isLoungeFull(passengers)){
					System.out.println("Lounge isn't full, passenger will be added");
					addPassengerToLounge(passenger, passengers);
					System.out.println("");
				}
				else{
					System.out.println("Lounge is full, passenger can't be added");
				}
			}else{
				super.assign(passenger, startValue,endValue);
			}//end else
		//}//end for
		return passenger;
	}//end method
}