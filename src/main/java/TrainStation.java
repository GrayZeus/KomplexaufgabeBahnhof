import java.util.HashMap;

public class TrainStation {
	private HashMap<String, Integer> distances = new HashMap<String,Integer>();
	private Track[] tracks = new Track[10];

	private City trainStationCity = new City("x");
	private Train[] trains = new Train[10];

	private SecurityControl securityControl = new SecurityControl();

	private Lounge[] lounges = new Lounge[3];

	public TrainStation() {
		for(int i = 0 ; i <= 8 ; i++){
			tracks[i] = new Track("T0" + (i+1));
			//System.out.println(tracks[i].getId());
		}
		tracks[9] = new Track("T10");
		//System.out.println(tracks[9].getId());
		for(Train train: trains){
			train = new Train();
		}

		distances.put("XA",125);
		distances.put("XB",225);
		distances.put("XC",185);
		distances.put("XD",85);
		distances.put("XE",85);
		distances.put("XF",50);
		distances.put("XG",85);
		distances.put("XH",250);
		distances.put("XI",115);
		distances.put("XJ",200);
	}
}