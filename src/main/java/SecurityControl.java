public class SecurityControl {

    public boolean doSecurityControl(Passenger passenger) {
        passenger.setDoneSecurityCheck(true);
        return true;
    }
}