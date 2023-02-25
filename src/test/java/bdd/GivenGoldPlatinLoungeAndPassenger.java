package bdd;

import chainOfResponibility.GoldPlatinumLounge;
import chainOfResponibility.Lounge;
import classesToMoreThanOnePattern.Passenger;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import state.Platinum;
import task_classes.TravelClass;

public class GivenGoldPlatinLoungeAndPassenger extends Stage<GivenGoldPlatinLoungeAndPassenger> {
    @ProvidedScenarioState
    public Lounge goldPlatinLounge;
    @ProvidedScenarioState
    public Passenger passenger;

    public void getInitializedGoldPlatinLoungeAndPlatinPassenger() {
        goldPlatinLounge = new GoldPlatinumLounge(null);
        passenger = new Passenger(815);
        passenger.setDestination("XJ");
        passenger.setTravelClass(TravelClass.FIRST);
        passenger.setState(new Platinum());
    }

    public void getInitializedGoldPlatinLoungeAndBluePassenger() {
        goldPlatinLounge = new GoldPlatinumLounge(null);
        passenger = new Passenger(111204);
        passenger.setDestination("XC");
        passenger.setTravelClass(TravelClass.ECONOMY);
    }

}
