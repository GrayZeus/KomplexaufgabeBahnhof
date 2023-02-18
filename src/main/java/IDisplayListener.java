public interface IDisplayListener {

	int id = 0;
	int[] loungePlace = new int[2];
	boolean updateEvent(String city, String track);

	public int[] getLoungePlace();

	public int getId();


}