package state;

import classesToMoreThanOnePattern.Passenger;

public interface IFTPState {
    void promote(Passenger passenger);
}