package task_classes;

import classesToMoreThanOnePattern.Passenger;

public class SecurityControl {

    public boolean doSecurityControl(Passenger passenger) {
        passenger.setDoneSecurityCheck(true);
        return true;
    }
}