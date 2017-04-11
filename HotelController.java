import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelController {
	private HotelStorage hotelStorage;
	private List<Hotel> hotelListi;
	
	public HotelController() {
		hotelStorage = new HotelStorage();
		hotelListi = hotelStorage.getHotelListi();
	}
	
	public void search(String leitarord) {
		hotelStorage.getHotelFromDatabase(leitarord);
	}
	
	public void displayResults(){
		String[] hotel = new String[hotelListi.size()];
		
		if(hotelListi.size() == 0) {
			System.out.println("Engar niðurstöður fundust");
		}
		int count = 0;
		for(int i=0; i<hotelListi.size(); i++) {
			String hotelNafn = hotelListi.get(i).getHotelName();
			System.out.println(hotelNafn);
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
		String[] hotel = new String[hotelListi.size()];
		int count = 0;
		if(filter.toLowerCase().equals("price")) {
			for(int i=0; i<hotelListi.size(); i++) {
				List<Room> roomList = hotelListi.get(i).getRooms();
				if(priceFilter(roomList, tala)) {
					System.out.println(hotelListi.get(i).getHotelName());
				}
			}
		}
		if(filter.toLowerCase().equals("quality")) {
			for(int i=0; i<hotelListi.size(); i++) {
				if(hotelListi.get(i).getQuality() <= tala) {
					System.out.println(hotelListi.get(i).getHotelName());
				}
			}
		}
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
		hotelController.sort("quality", "descending");
		hotelController.displayResults();
		//hotelController.filter("quality", 4);
	}
}
