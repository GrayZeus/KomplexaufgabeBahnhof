public class Silver implements IFTPState {
    @Override
    public void promote(Passenger passenger) {
//        System.out.println("Promoting passenger to Gold state -> verified");
        passenger.setState(new Gold());
    }
}