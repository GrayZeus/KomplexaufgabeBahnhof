package bdd;

import chainOfResponibility.Lounge;
import classesToMoreThanOnePattern.Passenger;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThenGoldPlatinLoungeContainsAssignedPassenger extends Stage<GivenGoldPlatinLoungeAndPassenger> {
    @ExpectedScenarioState
    public Lounge goldPlatinLounge;

    public void assertGoldPlatinLoungeContainsPassenger() {
        Passenger[][] passengers = goldPlatinLounge.getPassengers();
        assertTrue(passengers[0][0] instanceof Passenger);
    }

    public void assertGoldPlatinLoungeContainsNoPassenger() {
        Passenger[][] passengers = goldPlatinLounge.getPassengers();
        assertTrue(passengers[0][0] == null);
    }
}
