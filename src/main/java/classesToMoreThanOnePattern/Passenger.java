package classesToMoreThanOnePattern;

import observer.IDisplayListener;
import state.Blue;
import state.IFTPState;
import task_classes.DrivingLog;
import task_classes.TravelClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //CONSTRUCTOR #############################################################################################

    public Passenger(int id) {
        //initial state for all Passengers
        this.state = new Blue();
        this.id = id;
        instantiateDistancesToOtherCities();
    }

    //GETTER AND SETTER METHODS #############################################################################################

    public void setDoneSecurityCheck(boolean doneSecurityCheck) {
        this.doneSecurityCheck = doneSecurityCheck;
    }

    public int[] getLoungePlace() {
        return loungePlace;
    }

    public void setLoungePlace(int[] loungePlace) {
        this.loungePlace = loungePlace;
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

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    //METHODS ########################################################################################################

    public void promote() {
        state.promote(this);
    }

    /**
     * Observer pattern method. ClassesToMoreThanOnePattern.Passenger is a listener, listener will be informed if this method is called.
     * If the destination city of the passenger matches to the city on the display, true will be returned.
     *
     * @param city
     * @param track
     * @return
     */

    @Override
    public boolean updateEvent(String city, String track) {
        //System.out.println("Updated event on ChainOfResponibility.Lounge observer.Display.Source: updateEvent, ClassesToMoreThanOnePattern.Passenger class");
        if (destination.equals(city)) {
            //System.out.println("observer.Display content matches destination of ClassesToMoreThanOnePattern.Passenger");
            return true;
        }
        System.out.println("ClassesToMoreThanOnePattern.Passenger don't wan't to city: " + city + " he wants to: " + destination + ".");
//		System.out.println("");
        return false;
    }


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


    public int getPointsFromDrivingLog() {
        int points = drivingLog.sumAllPoints();
        return points;
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
                System.out.println("Something ain't right. Source: evaluatePointAmount, ClassesToMoreThanOnePattern.Passenger ");
        }
        return points;
    }

    public int everyTenThRouteDriven(int distance) {
        int extraPoints = 0;
        if (drivingLog.getDates().size() % 10 == 0) {
            extraPoints = distance * 3;
//			System.out.println("YAYYYY that's your 10th drive! Source everyTenThRouteDriven, ClassesToMoreThanOnePattern.Passenger");
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
            //ClassesToMoreThanOnePattern.Passenger stays in his state
            //System.out.println("ClassesToMoreThanOnePattern.Passenger stays in his state. Source: ClassesToMoreThanOnePattern.Passenger");
            return false;
        } else {
            promote();
//			System.out.println("Congrats " + this + " passengers FTP State has been promoted. Source: preconditionNewStateThenPromote, ClassesToMoreThanOnePattern.Passenger ");
            return true;
        }
    }//end method


    public String evaluateFTPState() {
        int points = getPointsFromDrivingLog();
        if (points <= 1999) {
            //stays state.Blue
            return "state.Blue";
        } else if (points >= 2000 && points <= 4249) {
            //state.Bronze state
            return "state.Bronze";
        } else if (points >= 4250 && points <= 6499) {
            //state.Silver state
            return "state.Silver";
        } else if (points >= 6500 && points <= 11499) {
            //state.Gold state
            return "state.Gold";
        } else {
            //points over 11500, state.Platinum state
            return "state.Platinum";
        }
    }

    public void instantiateDistancesToOtherCities() {
        distances.put("XA", 125);
        distances.put("XB", 225);
        distances.put("XC", 185);
        distances.put("XD", 85);
        distances.put("XE", 85);
        distances.put("XF", 50);
        distances.put("XG", 85);
        distances.put("XH", 250);
        distances.put("XI", 115);
        distances.put("XJ", 200);
    }

}//end passenger class