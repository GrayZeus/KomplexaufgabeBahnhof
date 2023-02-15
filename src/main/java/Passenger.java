import java.util.ArrayList;
import java.util.Date;

public class Passenger implements IDisplayListener {
	private int id;
	private IFTPState state;

	private DrivingLog drivingLog = new DrivingLog();

	public IFTPState getState() {
		return state;
	}

	public void setState(IFTPState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void promote(){
		state.promote(this);
	}

	public Passenger(int id){
		//initial state for all Passengers
		this.state = new Blue();
		this.id = id;
	}

	@Override
	public void updateEvent() {
		System.out.println("Updated event on Lounge Display");
	}

	public int getPointsFromDrivingLog(){
		ArrayList<Integer> tempPoints = drivingLog.getPoints();
		int returnValue = 0;
		for(int point:tempPoints){
			returnValue += point;
		}//end for
		return returnValue;
	}//end method

	public void recordJourney(Date date, String route, int points){
		ArrayList<Date> tempDates = drivingLog.getDates();
		ArrayList<String> tempRoutes = drivingLog.getRoutes();
		ArrayList<Integer> tempPoints = drivingLog.getPoints();
		tempDates.add(date);
		tempRoutes.add(route);
		tempPoints.add(points);
		drivingLog.setDates(tempDates);
		drivingLog.setRoutes(tempRoutes);
		drivingLog.setPoints(tempPoints);
	}

	public String evaluateFTPState(){
		int points = getPointsFromDrivingLog();
		if(points <= 1999){
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
		}
		else{
			//points over 11500, Platinum state
			return "Platinum";
		}
	}




}