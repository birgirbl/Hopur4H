import java.util.List;

public class HotelController {
	private HotelStorage hS;
	
	public HotelController() {
		hS = new HotelStorage();
	}
	
	public void search(String leitarord) {
		hS.getHotelFromDatabase(leitarord);
		//displayResults();
	}
	
	public String displayResults(){
		if(hS.getHotelListi().size() == 0) {
			return "Engar niðurstöður fundust";
		}
		for(int i=0; i<hS.getHotelListi().size(); i++) {
			String hotelNafn = hS.getHotelListi().get(i).getHotelName();
			return hotelNafn;
		}
		return "";
	}
	
	public void displayHotelInformation(Hotel hotel) {
		List<Room> x = hS.getRoomsFromDatabase(hotel);
		for(int i=0; i<x.size(); i++) {
			String roomType = x.get(i).getRoomType();
			int price = x.get(i).getPrice();
			System.out.println(roomType + " : " + price);
		}
	}
	
	
	public String filter(String filter, int tala) {
		
		if(filter.equals("price")) {
			
			
			
		}
		
		return filter;
	}

	public void deleteHotel(String hotelName, String location) {
		//hS.deleteHotelFromDatabase();
	}
	
	////athuga
	public void overwrite(String , String ) {
		
	}
	
	////athuga
	public void delete(String , String ) {
		//bS.deleteBookingFromDatabase();
	}
	
	////athuga
	public void createBooking(Hotelname Hotel, Room room, Traveler traveler, Date dateFrom, Date dateTo) {
		bS.setBookingToDatabase(hotel, room, traveler, dateFrom, dateTo);
	}
	
	////athuga
	public boolean isRoomAvaivable() {
		
	}
	
	
	
	public void createReview(Traveler traveler, Hotel hotel, String review) {
		hS.setReviewToDatabase(traveler, hotel, review);
	}
	
	public void showPictures(Hotel hotel) {
		for(int i=0; i<hS.getHotelListi().size(); i++) {
			if(hS.getHotelListi().get(i).equals(hotel)) {
				hS.getHotelListi().get(i).showPictures();
			}
		}
	}


	
	public String sort(String sort) {
		return sort;
	}
	
	public static void main(String[] args) {
		HotelController hotelController = new HotelController();
		System.out.println(hotelController.displayResults());
	}
	
	
	
	
	
	
	
	// Hafa þetta sem sækja info f. allan listann eða bara hvert tilvik
	// fyrir sig í einu
	//hS.getHotelInfoFromDatabase();
	// eða þá 
	// hS.getHotelList().get(i).getHotelInfoFromDatabase();
	
	// getReview, getRoom etc.. sækja annars allt um hótel fyrst
}
