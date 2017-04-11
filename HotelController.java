import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelController {
	private HotelStorage hotelStorage;
	private List<Hotel> hotelListi;
	private List<Hotel> originalList;
	
	public HotelController() {
		hotelStorage = new HotelStorage();
	}
	
	public void search(String leitarord) {
		hotelStorage.getHotelFromDatabase(leitarord);
		originalList = hotelStorage.getHotelListi();
		hotelListi = new ArrayList<Hotel>(originalList);
	}
	
	public void displayResults(){
		String[] hotel = new String[hotelListi.size()];
		
		if(hotelListi.size() == 0) {
			System.out.println("Engar niðurstöður fundust");
		}
		System.out.println("Hótel\tStaðsetning\tStjörnur");
		for(int i=0; i<hotelListi.size(); i++) {
			String hotelNafn = hotelListi.get(i).getHotelName();
			String hotelLocation = hotelListi.get(i).getLocation();
			int quality = hotelListi.get(i).getQuality();
			System.out.println(hotelNafn + "\t" + hotelLocation + "\t" + quality);
		}
	}
	
	public void displayReviews(String hotelName) {
		for(int i=0; i<hotelListi.size(); i++) {
			if(hotelListi.get(i).getHotelName().equals(hotelName)) {
				List<Review> reviewListi = hotelListi.get(i).getReview();
				for(Review x : reviewListi) {
					System.out.println(x.toString());
				}
			}
		}
	}
	
	public void filter(String filter, int tala) {
		hotelListi = new ArrayList<Hotel>();
		if(filter.toLowerCase().equals("price")) {
			for(int i=0; i<originalList.size(); i++) {
				List<Room> roomList = originalList.get(i).getRooms();
				if(priceFilter(roomList, tala)) {
					hotelListi.add(originalList.get(i));
				}
			}
		}
		if(filter.toLowerCase().equals("quality")) {
			for(int i=0; i<originalList.size(); i++) {
				if(originalList.get(i).getQuality() <= tala) {
					hotelListi.add(originalList.get(i));
				}
			}
		}
	}
	
	public void getReviews(Hotel hotel) {
		hotelStorage.getReviewsFromDatabase(hotel);
	}
	
	public boolean priceFilter(List<Room> roomList, int tala) {
		for(int i=0; i<roomList.size(); i++) {
			if(roomList.get(i).getPrice() < tala) {
				return true;
			}
		}
		return false;
	}

	public void deleteHotel(String hotelName, String location) {
		hotelStorage.deleteHotelFromDatabase();
	}
	
	public void createReview(Traveler traveler, Hotel hotel, String review) {
		hotelStorage.setReviewToDatabase(traveler, hotel, review);
	}
	
	public void showPictures(Hotel hotel) {
		for(int i=0; i<hotelListi.size(); i++) {
			if(hotelListi.get(i).equals(hotel)) {
				hotelListi.get(i).showPictures();
			}
		}
	}
	
	public void sort(String sorteraEftir, String order) {
		if(sorteraEftir.equals("price")) {
	        Collections.sort(hotelListi,new Comparator<Hotel>() {
	            @Override
	            public int compare(Hotel h1, Hotel h2) {
	                Integer h1Min = findLowestPrice(h1.getRooms());
	                Integer h2Min = findLowestPrice(h2.getRooms());
	            	return h1Min.compareTo(h2Min);
	            }
	        });
		}
		if(sorteraEftir.equals("quality")) {
	        Collections.sort(hotelListi,new Comparator<Hotel>() {
	            @Override
	            public int compare(Hotel h1, Hotel h2) {
	                Integer h1Min = h1.getQuality();
	                Integer h2Min = h2.getQuality();
	            	return h1Min.compareTo(h2Min);
	            }
	        });
		}
        if(order.equals("descending")) {
        	Collections.reverse(hotelListi);
        }
	}

	private int findLowestPrice(List<Room> roomList) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<roomList.size(); i++) {
			if(roomList.get(i).getPrice() < min) {
				min = roomList.get(i).getPrice();
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		HotelController hotelController = new HotelController();
		hotelController.search("Icelandair");
		hotelController.filter("price", 30000);
		hotelController.sort("quality","descending");
		hotelController.displayResults();
	}
}
