import java.util.ArrayList;
import java.util.Date;

public class Application {

    public static void main(String... args){
        TrainStation trainStation = new TrainStation();
        trainStation.startDailyBusiness();
        //System.out.println("");


        //2nd int value max 500 difference!!!!
        trainStation.moveCustomAmountOfPassengersToLounges(0,500);
        trainStation.moveCustomAmountOfPassengersToLounges(500,1000);
        trainStation.moveCustomAmountOfPassengersToLounges(1000,1500);
        trainStation.moveCustomAmountOfPassengersToLounges(1500,2000);
        trainStation.moveCustomAmountOfPassengersToLounges(2000,2500);
        trainStation.tellLoungesToUpdateDisplay("XJ","T01");
        trainStation.tellLoungesToUpdateDisplay("XI","T02");
        trainStation.tellLoungesToUpdateDisplay("XH","T03");
        trainStation.tellLoungesToUpdateDisplay("XG","T04");
        trainStation.tellLoungesToUpdateDisplay("XF","T05");
        trainStation.tellLoungesToUpdateDisplay("XE","T06");




        trainStation.moveCustomAmountOfPassengersToLounges(2500,3000);
        trainStation.moveCustomAmountOfPassengersToLounges(3000,3500);
        trainStation.tellLoungesToUpdateDisplay("XD","T07");
        trainStation.moveCustomAmountOfPassengersToLounges(3500,4000);
        trainStation.tellLoungesToUpdateDisplay("XC","T08");
        trainStation.moveCustomAmountOfPassengersToLounges(4000,4500);
        trainStation.tellLoungesToUpdateDisplay("XB","T09");
        trainStation.moveCustomAmountOfPassengersToLounges(4500,5000);
        trainStation.tellLoungesToUpdateDisplay("XA","T10");



        /*
        OUTPUT OF PASSENGERS INFORMATIONS

        int[] yep = trainStation.getCompletedConfiguredPassengers().get(14).getLoungePlace();
        System.out.println("Row " + yep[0] + " Column " + yep[1]);
        */


        //trainStation.tellLoungesToUpdateDisplay("XJ","T01");

        //OLD#######################################################################
        //trainStation.chooseRandomPassengers();
        //trainStation.outputChoosedPassengers();
        //trainStation.outputCompletedConfiguredPassengers();

        /*Repository repository = new Repository();

        Passenger[] tempPassengers = repository.getPassengers();
        tempPassengers[3000].recordJourney(new Date(), "XA",5000);
        tempPassengers[3000].recordJourney(new Date(), "XB",1);
        tempPassengers[3000].recordJourney(new Date(), "XC",2);
        repository.setPassengers(tempPassengers);

        tempPassengers = repository.getPassengers();
        System.out.println(tempPassengers[3000].getPointsFromDrivingLog());
         */
    }//end main
}
