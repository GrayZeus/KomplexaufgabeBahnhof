import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class DrivingLog {
    private ArrayList<LocalDateTime> dates = new ArrayList<>();
    private ArrayList<String> routes = new ArrayList<>();
    private ArrayList<Integer> points = new ArrayList<>();

    public ArrayList<LocalDateTime> getDates() {
        return dates;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setDates(ArrayList<LocalDateTime> dates) {
        this.dates = dates;
    }

    public void setRoutes(ArrayList<String> routes) {
        this.routes = routes;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }
}


