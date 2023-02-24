import java.time.LocalDateTime;
import java.util.ArrayList;

public class DrivingLog {
    private ArrayList<LocalDateTime> dates = new ArrayList<>();
    private ArrayList<String> routes = new ArrayList<>();
    private ArrayList<Integer> points = new ArrayList<>();

    public ArrayList<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(ArrayList<LocalDateTime> dates) {
        this.dates = dates;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<String> routes) {
        this.routes = routes;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }


    public int sumAllPoints() {
        int returnValue = 0;
        for (int point : points) {
            returnValue += point;
        }//end for
        return returnValue;
    }


}


