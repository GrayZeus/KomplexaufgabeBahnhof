import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Application {

    public static void main(String... args){


        TrainStation trainStation = new TrainStation();

        for(int i = 0 ; i < 50; i++){
            trainStation.startDailyBusiness();

            System.out.println();
            System.out.println();
            System.out.println("#####################################################################################");
            System.out.println("END OF ROUND: " + i);
            System.out.println("#####################################################################################");
            System.out.println();
            System.out.println();
        }//end

    }//end main
}
