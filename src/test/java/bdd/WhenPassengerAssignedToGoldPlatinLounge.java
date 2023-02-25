package bdd;

import chainOfResponibility.Lounge;
import classesToMoreThanOnePattern.Passenger;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;

public class WhenPassengerAssignedToGoldPlatinLounge extends Stage<GivenGoldPlatinLoungeAndPassenger> {

    @ScenarioState
    public Lounge goldPlatinLounge;
    @ExpectedScenarioState
    public Passenger passenger;


    public void assignPassenger() {
        goldPlatinLounge.assign(passenger);
    }

}
