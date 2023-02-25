package state;

public class Blue implements IFTPState {

    @Override
    public void promote(Passenger passenger) {
//        System.out.println("Promoting passenger to state.Bronze state -> verified");
        passenger.setState(new Bronze());
    }
}