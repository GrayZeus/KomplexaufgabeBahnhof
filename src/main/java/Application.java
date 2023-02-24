import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Application {

    public static void main(String... args){
        TrainStation trainStation = new TrainStation();
        for(int i = 0 ; i < 150; i++){
            trainStation.startDailyBusiness();
            trainStation.writeSeparatorToSout(i);
        }//end
    }//end main
}
