import java.util.ArrayList;
import java.util.Date;

public class DrivingLog {
    private ArrayList<Date> dates = new ArrayList<>();
    private ArrayList<String> routes = new ArrayList<>();
    private ArrayList<Integer> points = new ArrayList<>();

    public ArrayList<Date> getDates() {
        return dates;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    public void setRoutes(ArrayList<String> routes) {
        this.routes = routes;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }
}


