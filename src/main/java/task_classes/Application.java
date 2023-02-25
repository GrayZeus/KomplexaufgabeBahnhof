package task_classes;

public class Application {

    public static void main(String... args) {
        TrainStation trainStation = new TrainStation();
        for (int i = 0; i < 150; i++) {
            trainStation.startDailyBusiness();
            trainStation.writeSeparatorToSout(i);
        }//end
    }//end main
}
