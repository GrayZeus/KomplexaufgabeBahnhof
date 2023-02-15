import java.util.Date;

public class Application {

    public static void main(String... args){
        TrainStation trainStation = new TrainStation();

        //trainStation.chooseRandomPassengers();

        //trainStation.outputChoosedPassengers();

        trainStation.startDailyBusiness();

        trainStation.moveCustomAmountOfPassengersToLounges(1000,2000);
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
