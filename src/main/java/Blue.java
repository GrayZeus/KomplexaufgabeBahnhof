public class Blue implements IFTPState {

    @Override
    public void promote(Passenger passenger) {
        System.out.println("Promoting passenger to Blue state -> verified");
        passenger.setState(new Blue());
    }
}