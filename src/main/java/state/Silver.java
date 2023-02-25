package state;

import classesToMoreThanOnePattern.Passenger;

public class Silver implements IFTPState {
    @Override
    public void promote(Passenger passenger) {
//        System.out.println("Promoting passenger to state.Gold state -> verified");
        passenger.setState(new Gold());
    }
}