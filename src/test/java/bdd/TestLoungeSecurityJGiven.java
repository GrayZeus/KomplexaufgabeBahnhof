package bdd;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class TestLoungeSecurityJGiven extends ScenarioTest<GivenGoldPlatinLoungeAndPassenger, WhenPassengerAssignedToGoldPlatinLounge,
        ThenGoldPlatinLoungeContainsAssignedPassenger> {

    @Test
    public void assignPlatinPassenger() {
        given().getInitializedGoldPlatinLoungeAndPlatinPassenger();
        when().assignPassenger();
        then().assertGoldPlatinLoungeContainsPassenger();
    }

    @Test
    public void assignBluePassenger() {
        given().getInitializedGoldPlatinLoungeAndBluePassenger();
        when().assignPassenger();
        then().assertGoldPlatinLoungeContainsNoPassenger();
    }
}
