package state;

import classesToMoreThanOnePattern.Passenger;

public class Gold implements IFTPState {

    @Override
    public void promote(Passenger passenger) {
//        System.out.println("Promoting passenger to state.Platinum state -> verified");
        passenger.setState(new Platinum());
    }
}