import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TrainStation {
	// GENERAL ATTRIBUTES#######################################################################################################
	private HashMap<String, Integer> distances = new HashMap<>();
	private Track[] tracks = new Track[10];
	private Train[] trains = new Train[10];

	private City trainStationCity = new City("x");
	private Repository repository = new Repository();
	private Lounge blueLounge,bronzeSilverLounge,goldPlatinLounge;

	// ATTRIBUTES FOR METHODS AND LOGIC ########################################################################################
	private Passenger[] passengersFromRepository;
	private Passenger[] chosenPassengers = new Passenger[500];
	private ArrayList<Passenger> completedConfiguredPassengers = new ArrayList<>();
	private Random random = new Random();

	//CONSTRUCTOR ##############################################################################################################
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

		//get Passengers in TrainStation
		passengersFromRepository = repository.getPassengers();
	}//end constructor


	//GETTER METHODS ##############################################################################################################
	public Lounge getBlueLounge() {
		return blueLounge;
	}
	public ArrayList<Passenger> getCompletedConfiguredPassengers() {
		return completedConfiguredPassengers;
	}

	// CLASS METHODS/ LOGIC METHODS ###############################################################################################

	public void startDailyBusiness(){
		for(int i = 0 ; i < 10 ; i++){
			chooseRandomPassengers();
			configureChosenPassengersTravelClass();
			for(int x = 0 ; x < 500 ; x++){
				completedConfiguredPassengers.add(chosenPassengers[x]);
			}//end for
			clearChosenPassengers();
		}//end for
		assignConfiguredPassengersToTrains();
		movePassengersSuccessivelyToLoungeAndUpdateDisplay();
		System.out.println("Start daily business from TrainStation class completed");
	}//end method

	public void movePassengersSuccessivelyToLoungeAndUpdateDisplay(){
		//NOTE: 2nd parameter int value is only allowed to create a difference between 1st and 2nd parameter of 500
		//Math: param2 - param1 = max. 500
		moveCustomAmountOfPassengersToLounges(0,500);
		tellLoungesToUpdateDisplay("XA","T01");
		moveCustomAmountOfPassengersToLounges(500,1000);
		tellLoungesToUpdateDisplay("XB","T02");
		moveCustomAmountOfPassengersToLounges(1000,1500);
		tellLoungesToUpdateDisplay("XC","T03");
		moveCustomAmountOfPassengersToLounges(1500,2000);
		tellLoungesToUpdateDisplay("XD","T04");
		moveCustomAmountOfPassengersToLounges(2000,2500);
		tellLoungesToUpdateDisplay("XE","T05");
		moveCustomAmountOfPassengersToLounges(2500,3000);
		tellLoungesToUpdateDisplay("XF","T06");
		moveCustomAmountOfPassengersToLounges(3000,3500);
		tellLoungesToUpdateDisplay("XG","T07");
		moveCustomAmountOfPassengersToLounges(3500,4000);
		tellLoungesToUpdateDisplay("XH","T08");
		moveCustomAmountOfPassengersToLounges(4000,4500);
		tellLoungesToUpdateDisplay("XI","T09");
		moveCustomAmountOfPassengersToLounges(4500,5000);
		tellLoungesToUpdateDisplay("XJ","T10");
	}//end method


	public void clearChosenPassengers(){
		for(int i = 0 ; i < chosenPassengers.length ; i++){
			chosenPassengers[i] = null;
		}//end for
	}//end method


	public void moveCustomAmountOfPassengersToLounges(int startValue, int endValue){
		for(int i = startValue ; i < endValue ; i++){
			//using CoR
			Passenger tempPassenger;
			tempPassenger = goldPlatinLounge.assign(completedConfiguredPassengers.get(i));
			completedConfiguredPassengers.set(i, tempPassenger);
			/*
			System.out.println("Train Passenger: " + completedConfiguredPassengers.get(i) + " Row: " + completedConfiguredPassengers.get(i).getLoungePlace()[0] +
					" Column: "	+	completedConfiguredPassengers.get(i).getLoungePlace()[1] +
					" Source: moveCustomAmountOfPassengersToLounges, TrainStation");
			 */
		}//end for
	}//end method


	public void tellLoungesToUpdateDisplay(String destination, String trackID){
		blueLounge.tellDisplayToUpdate(destination, trackID);
		//bronzeSilverLounge.tellDisplayToUpdate(destination, trackID);
		//goldPlatinLounge.tellDisplayToUpdate(destination, trackID);
	}

	public void assignConfiguredPassengersToTrains(){
		//XA
		for(int i = 0 ; i < 500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XA");
		}//end for
		System.out.println("XA train has 500 passengers assigned");
		//XB
		for(int i = 500 ; i < 1000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XB");
		}//end for
		System.out.println("XB has 500 passengers assigned");
		//XC
		for(int i = 1000 ; i < 1500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XC");
		}//end for
		System.out.println("XC has 500 passengers assigned");
		//XD
		for(int i = 1500 ; i < 2000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XD");
		}//end for
		System.out.println("XD has 500 passengers assigned");
		//XE
		for(int i = 2000 ; i < 2500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XE");
		}//end for
		System.out.println("XE has 500 passengers assigned");
		//XF
		for(int i = 2500 ; i < 3000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XF");
		}//end for
		System.out.println("XF has 500 passengers assigned");
		//XG
		for(int i = 3000 ; i < 3500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XG");
		}//end for
		System.out.println("XG has 500 passengers assigned");
		//XH
		for(int i = 3500 ; i < 4000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XH");
		}//end for
		System.out.println("XH has 500 passengers assigned");
		//XI
		for(int i = 4000 ; i < 4500 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XI");
		}//end for
		System.out.println("XI has 500 passengers assigned");
		//XJ
		for(int i = 4500 ; i < 5000 ; i++){
			completedConfiguredPassengers.get(i).setDestination("XJ");
		}//end for
		System.out.println("XJ has 500 passengers assigned");
	}


	public void chooseRandomPassengers(){
		int randomInt = 0;
		int counter = 0;
		while(!isChosenPassengersFull()){
			randomInt = random.nextInt(5000);
			//System.out.println(randomInt);
			if(passengersFromRepository[randomInt] != null) {
				chosenPassengers[counter] = passengersFromRepository[randomInt];
				passengersFromRepository[randomInt] = null;
				counter += 1;
			}//end if
		}//end while
	}//end method

	public void configureChosenPassengersTravelClass(){
		//First Class 5% of 500
		for(int x = 0 ; x < 25 ; x++ ){
			chosenPassengers[x].setTravelClass(TravelClass.FIRST);
		}
		//Business Class 15% of 500
		for(int x = 25 ; x < 100 ; x++ ){
			chosenPassengers[x].setTravelClass(TravelClass.BUSINESS);
		}
		//Economy Class	80% of 500
		for(int x = 100 ; x < 500 ; x++ ){
			chosenPassengers[x].setTravelClass(TravelClass.ECONOMY);
		}
	}//end method


	public boolean isChosenPassengersFull(){
		for(int i = 0; i < chosenPassengers.length ; i++) {
			if (chosenPassengers[i] == null) {
				return false;
			}//end if
		}//end for
		return true;
	}//end method

	public void outputCompletedConfiguredPassengers(){
		for(Passenger passenger: completedConfiguredPassengers){
			System.out.println(passenger.getId());
		}
	}

	public void outputChosenPassengers(){
		for(Passenger passenger: chosenPassengers){
			System.out.println(passenger.getId());
		}
	}

}