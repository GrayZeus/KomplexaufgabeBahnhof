package state;

import classesToMoreThanOnePattern.Passenger;

public class Bronze implements IFTPState {
    @Override
    public void promote(Passenger passenger) {
//        System.out.println("Promoting passenger to state.Silver state -> verified");
        passenger.setState(new Silver());
    }
}