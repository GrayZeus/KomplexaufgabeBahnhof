public class Repository {
    private Passenger[] passengers = new Passenger[5000];

    public Repository() {
        for (int i = 0; i < 5000; i++) {
            passengers[i] = new Passenger(i);
        }
        //System.out.println(passengers[4999].getId());
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}