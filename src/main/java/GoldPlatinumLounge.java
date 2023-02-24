import java.util.ArrayList;

public class GoldPlatinumLounge extends Lounge {
	public GoldPlatinumLounge(Lounge successor) {
		setSuccessor(successor);
	}

	public Passenger assign(Passenger passenger) {
		if(canHandlePassenger(passenger,"Gold") || canHandlePassenger(passenger,"Plat") ){
			//only first 4 chars possible
//			System.out.println("Passenger matches to GoldPlatinum Lounge. Source: assign, GoldPlatinumLounge");
			if(!isLoungeFull()){
//				System.out.println("Lounge isn't full, passenger will be added");
				passenger = addPassengerToLounge(passenger);
//				System.out.println("");
			}
			else{
				System.out.println("Lounge is full, passenger can't be added");
			}
		}else{
			passenger = super.assign(passenger);
		}//end else

		return passenger;
	}//end method
}