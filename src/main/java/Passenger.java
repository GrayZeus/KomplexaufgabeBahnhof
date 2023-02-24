import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Passenger implements IDisplayListener {
	// GENERAL ATTRIBUTES#######################################################################################################
	private int id;
	private IFTPState state;

	private TravelClass travelClass;

	private String destination;

	private boolean doneSecurityCheck = false;
	private DrivingLog drivingLog = new DrivingLog();
	private int[] loungePlace = new int[2];
	private HashMap<String, Integer> distances = new HashMap<>();

	//GETTER AND SETTER METHODS #############################################################################################

	public boolean isDoneSecurityCheck() {
		return doneSecurityCheck;
	}

	public void setDoneSecurityCheck(boolean doneSecurityCheck) {
		this.doneSecurityCheck = doneSecurityCheck;
	}
	public int[] getLoungePlace() {
		return loungePlace;
	}
	public void setLoungePlace(int[] loungePlace) {
		this.loungePlace = loungePlace;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public IFTPState getState() {
		return state;
	}
	public void setState(IFTPState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public DrivingLog getDrivingLog() {
		return drivingLog;
	}

	//CONSTRUCTOR ########################################################################################################


	public Passenger(int id) {
		//initial state for all Passengers
		this.state = new Blue();
		this.id = id;
		instantiateDistancesToOtherCities();
	}

	//METHODS ########################################################################################################

	public void promote() {
		state.promote(this);
	}

	public TravelClass getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}


	/**
	 * Observer pattern method. Passenger is a listener, listener will be informed if this method is called.
	 * If the destination city of the passenger matches to the city on the display, true will be returned.
	 * @param city
	 * @param track
	 * @return
	 */

	@Override
	public boolean updateEvent(String city, String track) {
		//System.out.println("Updated event on Lounge Display.Source: updateEvent, Passenger class");
		if(destination.equals(city)){
			//System.out.println("Display content matches destination of Passenger");
			return true;
		}
		System.out.println("Passenger don't wan't to city: " + city +" he wants to: " + destination +".");
		System.out.println("");
		return false;
	}

	public int getPointsFromDrivingLog() {
		ArrayList<Integer> tempPoints = drivingLog.getPoints();
		int returnValue = 0;
		for (int point : tempPoints) {
			returnValue += point;
		}//end for
		return returnValue;
	}//end method

	public void recordJourney(LocalDateTime dateTime) {
		//get ArrayLists
		ArrayList<LocalDateTime> passengerDates = drivingLog.getDates();
		ArrayList<String> passengerRoutes = drivingLog.getRoutes();
		ArrayList<Integer> passengerPoints = drivingLog.getPoints();
		//add data
		passengerDates.add(dateTime);
		passengerRoutes.add(destination);
		int points = evaluatePointAmount(distances.get(destination));
		passengerPoints.add(points);
		//set ArrayLists
		drivingLog.setDates(passengerDates);
		drivingLog.setRoutes(passengerRoutes);
		drivingLog.setPoints(passengerPoints);
		//update state
		preconditionNewStateThenPromote();
	}//end method


	public int evaluatePointAmount(int distance) {
		int points = 0;
		switch (travelClass.toString()) {
			case "FIRST":
				points = 2 * distance + everyTenThRouteDriven(distance);
				break;
			case "BUSINESS":
				if (drivingLog.getDates().size() >= 3) {
					points = 2 * distance + everyTenThRouteDriven(distance);
				}
				break;
			case "ECONOMY":
				if (drivingLog.getDates().size() >= 3) {
					points = distance + 50 + everyTenThRouteDriven(distance);
				}
				break;
			default:
				System.out.println("Something ain't right. Source: evaluatePointAmount, Passenger ");
		}
		return points;
	}

	public int everyTenThRouteDriven(int distance){
		int extraPoints = 0;
		if(drivingLog.getDates().size() % 10 == 0){
			extraPoints = distance*3;
			System.out.println("YAYYYY that's your 10th drive! Source everyTenThRouteDriven, Passenger");
			return extraPoints;
		}//end if
		return extraPoints;
	}//end method



	public boolean preconditionNewStateThenPromote() {
		//false = not promoted
		//true = promoted
		String actualState = state.getClass().toString();
		String futureState = evaluateFTPState();
		if (actualState.equals("class " + futureState)) {
			//Passenger stays in his state
			//System.out.println("Passenger stays in his state. Source: Passenger");
			return false;
		} else {
			promote();
			System.out.println("Congrats " + this + " passengers FTP State has been promoted. Source: preconditionNewStateThenPromote, Passenger ");
			return true;
		}
	}//end method


	public String evaluateFTPState() {
		int points = getPointsFromDrivingLog();
		if (points <= 1999) {
			//stays Blue
			return "Blue";
		} else if (points >= 2000 && points <= 4249) {
			//Bronze state
			return "Bronze";
		} else if (points >= 4250 && points <= 6499) {
			//Silver state
			return "Silver";
		} else if (points >= 6500 && points <= 11499) {
			//Gold state
			return "Gold";
		} else {
			//points over 11500, Platinum state
			return "Platinum";
		}
	}

	public void instantiateDistancesToOtherCities(){
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


}//end passenger class