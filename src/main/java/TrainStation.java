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
	}//end constructor


	public void moveCustomAmountOfPassengersToLounges(int startValue, int endValue){
		for(int i = startValue ; i < endValue ; i++){
			//using CoR
			//System.out.println("Passenger: " + completedConfiguredPassengers.get(i).getId() + " is assigned to the lounge corresponding to the state");
			//System.out.println("he will drive to: " + completedConfiguredPassengers.get(i).getDestination() + " SOURCE: moveCustomAmountOfPassengersToLounges, TrainStation");
			goldPlatinLounge.assign(completedConfiguredPassengers.get(i));
		}//end for
	}//end method



	public void startDailyBusiness(){
		for(int i = 0 ; i < 10 ; i++){
			chooseRandomPassengers();
			configureChoosedPassengersTravelClass();
			for(int x = 0 ; x < 500 ; x++){
				completedConfiguredPassengers.add(choosedPassengers[x]);
			}
		}
		System.out.println("ArrayList size: " + completedConfiguredPassengers.size());
		assignConfiguredPassengersToTrains();
	}

	public void assignConfiguredPassengersToTrains(){
		//XA
		for(int i = 0 ; i < 500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XA");
		}//end for
		System.out.println("XA train full");
		//XB
		for(int i = 500 ; i < 1000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XB");
		}//end for
		System.out.println("XB train full");
		//XC
		for(int i = 1000 ; i < 1500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XC");
		}//end for
		System.out.println("XC train full");
		//XD
		for(int i = 1500 ; i < 2000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XD");
		}//end for
		System.out.println("XD train full");
		//XE
		for(int i = 2000 ; i < 2500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XE");
		}//end for
		System.out.println("XE train full");
		//XF
		for(int i = 2500 ; i < 3000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XF");
		}//end for
		System.out.println("XF train full");
		//XG
		for(int i = 3000 ; i < 3500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XG");
		}//end for
		System.out.println("XG train full");
		//XH
		for(int i = 3500 ; i < 4000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XH");
		}//end for
		System.out.println("XH train full");
		//XI
		for(int i = 4000 ; i < 4500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XI");
		}//end for
		System.out.println("XI train full");
		//XJ
		for(int i = 4500 ; i < 5000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XJ");
		}//end for
		System.out.println("XJ train full");
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