import java.util.ArrayList;

public class DatabaseManager {
	private static ArrayList<Hotel> hotelResults;
	private static ArrayList<Room> roomResults;
	private static ArrayList<Review> reviewResults;
	
	public static ArrayList<Hotel> searchHotels(String leitarord) {
		hotelResults = new ArrayList<Hotel>();
		Hotel a = new Hotel("Icelandair", "Reykjavik");
		Hotel b = new Hotel("Hilton", "Reykjavik");
		//Hotel c = new Hotel("Deluxe Suite", "London");
		//Hotel d = new Hotel("Hótel Rangá", "Rangá");
		a.setQuality(3);
		b.setQuality(4);
		a.setRoom("Eitt einbreitt rúm", 15000);
		a.setRoom("Tvö einbreið rúm", 20000);
		a.setRoom("Svíta", 40000);
		b.setRoom("Eitt einbreitt rum", 10000);
		b.setRoom("Eitt einbreitt rum", 10000);
		b.setRoom("Fjölskylduherbergi", 15000);
		hotelResults.add(a);
		hotelResults.add(b);
		//results.add(c);
		//results.add(d);
		return hotelResults;
	}
	
	public static ArrayList<Hotel> getRooms(Hotel hotel) {
		if(hotel.getHotelName().equals("Icelandair")) {

		}
		if(hotel.getHotelName().equals("Hilton")) {
			hotelResults.get(1).setRoom("Eitt einbreitt rum", 10000);
			hotelResults.get(1).setRoom("Eitt einbreitt rum", 10000);
			hotelResults.get(1).setRoom("Fjölskylduherbergi", 15000);
		}
		return hotelResults;
	}
	
	public static ArrayList<Review> getReviews(Hotel hotel) {
		reviewResults = new ArrayList<Review>();
		if(hotel.getHotelName().equals("Icelandair")) {
			Traveler tinna = new Traveler("1981275", "Tinna");
			Traveler birgir = new Traveler("120528", "Birgir");
			hotelResults.get(0).setReview(tinna, "mjög fínt");
			hotelResults.get(0).setReview(birgir, "Jájá, allt í lagi");
			reviewResults = hotelResults.get(0).getReview();
		}
		if(hotel.getHotelName().equals("Hilton")) {
			Traveler einar = new Traveler("12056668", "Einar");
			hotelResults.get(1).setReview(einar, "flott");
			reviewResults = hotelResults.get(1).getReview();
		}
		return reviewResults;
	}
}
