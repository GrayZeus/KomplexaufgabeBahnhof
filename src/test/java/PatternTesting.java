import chainOfResponibility.BlueLounge;
import chainOfResponibility.BronzeSilverLounge;
import chainOfResponibility.GoldPlatinumLounge;
import chainOfResponibility.Lounge;
import classesToMoreThanOnePattern.Passenger;
import observer.Display;
import org.junit.jupiter.api.Test;
import state.*;

import static org.junit.jupiter.api.Assertions.*;

public class PatternTesting {
    private Lounge blueLounge, bronzeSilverLounge, goldPlatinLounge;
    private Passenger passenger;


    @Test
    public void checkChainOfResponsibilityPattern() {
        blueLounge = new BlueLounge();
        bronzeSilverLounge = new BronzeSilverLounge(blueLounge);
        goldPlatinLounge = new GoldPlatinumLounge(bronzeSilverLounge);

        passenger = new Passenger(815);
        assertTrue(goldPlatinLounge.canHandlePassenger(passenger, "state.Blue"));

        passenger.setState(new Bronze());
        assertTrue(goldPlatinLounge.canHandlePassenger(passenger, "state.Bron"));

        passenger.setState(new Silver());
        assertTrue(goldPlatinLounge.canHandlePassenger(passenger, "state.Silv"));

        passenger.setState(new Gold());
        assertTrue(goldPlatinLounge.canHandlePassenger(passenger, "state.Gold"));

        passenger.setState(new Platinum());
        assertTrue(goldPlatinLounge.canHandlePassenger(passenger, "state.Plat"));

        assertFalse(goldPlatinLounge.canHandlePassenger(passenger, "asldfajlsdlfjöo"));
    }


    @Test
    public void checkObserverPattern() {
        blueLounge = new BlueLounge();
        passenger = new Passenger(815);
        passenger.setDestination("XA");
        Passenger p2 = new Passenger(42);
        p2.setDestination("XB");
        Display display = blueLounge.getDisplay();
        display.addListener(passenger);
        display.addListener(p2);
        assertEquals(2, display.getListeners().size());
        blueLounge.tellDisplayToUpdate("XA", "T01");
        assertEquals(1, display.getListeners().size());
    }//end


    @Test
    public void checkStatePattern() {
        passenger = new Passenger(815);
        assertTrue(passenger.getState() instanceof Blue);

        passenger.promote();
        System.out.println("Passengers new State: " + passenger.getState());
        assertTrue(passenger.getState() instanceof Bronze);

        passenger.promote();
        System.out.println("Passengers new State: " + passenger.getState());
        assertTrue(passenger.getState() instanceof Silver);

        passenger.promote();
        System.out.println("Passengers new State: " + passenger.getState());
        assertTrue(passenger.getState() instanceof Gold);

        passenger.promote();
        System.out.println("Passengers new State: " + passenger.getState());
        assertTrue(passenger.getState() instanceof Platinum);

        //Alternative way
        assertEquals("state.Plat", passenger.getState().toString().substring(0, 10));
    }

}
