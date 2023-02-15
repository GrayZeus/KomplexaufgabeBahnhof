import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TrainStation {
	private HashMap<String, Integer> distances = new HashMap<String,Integer>();
	private Track[] tracks = new Track[10];

	private City trainStationCity = new City("x");
	private Train[] trains = new Train[10];

	private SecurityControl securityControl = new SecurityControl();

	private Lounge blueLounge,bronzeSilverLounge,goldPlatinLounge;

	private Repository repository = new Repository();

	private Random random = new Random();

	Passenger[] choosedPassengers = new Passenger[500];

	ArrayList<Passenger> completedConfiguredPassengers = new ArrayList<>();

	public TrainStation() {
		//initialization Tracks
		for(int i = 0 ; i <= 8 ; i++){
			tracks[i] = new Track("T0" + (i+1));
			//System.out.println(tracks[i].getId());
		}
		tracks[9] = new Track("T10");
		//System.out.println(tracks[9].getId());

		//initialization trains
		for(Train train: trains){
			train = new Train();
		}

		//initialization of Lounges, CoR pattern
		blueLounge = new BlueLounge();
		bronzeSilverLounge = new BronzeSilverLounge(blueLounge);
		goldPlatinLounge = new GoldPlatinumLounge(bronzeSilverLounge);


		//Setting distances to other cities
		distances.put("XA",125);
		distances.put("XB",225);
		distances.put("XC",185);
		distances.put("XD",85);
		distances.put("XE",85);
		distances.put("XF",50);
		distances.put("XG",85);
		distances.put("XH",250);
		distances.put("XI",115);
		distances.put("XJ",200);
	}

	public void startDailyBusiness(){
		for(int i = 0 ; i < 10 ; i++){
			chooseRandomPassengers();
			configureChoosedPassengersTravelClass();
			for(int x = 0 ; x < 500 ; x++){
				completedConfiguredPassengers.add(choosedPassengers[x]);
			}
		}
		System.out.println("ArrayList size: " + completedConfiguredPassengers.size());
	}


	public void assignConfiguredPassengersToTrains(){

	}


	public void outputCompletedConfiguredPassengers(){
		for(Passenger passenger: completedConfiguredPassengers){
			System.out.println(passenger.getId());
		}
	}


	public void outputChoosedPassengers(){
		for(Passenger passenger: choosedPassengers){
			System.out.println(passenger.getId());
		}
	}


	public Passenger[] chooseRandomPassengers(){
		Passenger[] tempPassengers = repository.getPassengers();
		int temp = 0;
		int i = 0;
		while(!isChoosedPassengersFull()){

			temp = random.nextInt(5000);
			if(tempPassengers[temp] != null) {
				System.out.println("Non null passenger found number: " + temp + " passenger will be deleted from tempPassengers");
				choosedPassengers[i] = tempPassengers[temp];
				tempPassengers[temp] = null;
				i += 1;
				System.out.println("Counter number: " + i);
			}//end if
		}
		return choosedPassengers;
	}

	public Passenger[] configureChoosedPassengersTravelClass(){
		//First Class
		for(int x = 0 ; x < 25 ; x++ ){
			choosedPassengers[x].setTravelClass(TravelClass.FIRST);
		}
		//Business Class
		for(int x = 25 ; x < 100 ; x++ ){
			choosedPassengers[x].setTravelClass(TravelClass.BUSINESS);
		}
		//Economy Class
		for(int x = 100 ; x < 500 ; x++ ){
			choosedPassengers[x].setTravelClass(TravelClass.ECONOMY);
		}
		return choosedPassengers;
	}


	public boolean isChoosedPassengersFull(){
		for(Passenger passenger: choosedPassengers) {
			if (passenger == null) {
				return false;
			}//end if
		}//end for
		return true;
	}//end method

}