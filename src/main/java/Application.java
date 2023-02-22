import java.util.Date;

public class Application {

    public static void main(String... args){
        TrainStation trainStation = new TrainStation();
        trainStation.startDailyBusiness();
        System.out.println("");
        trainStation.moveCustomAmountOfPassengersToLounges(0,550);

        trainStation.tellLoungesToUpdateDisplay("XJ","T01");



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
