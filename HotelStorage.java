import java.util.ArrayList;
import java.util.List;

public class HotelStorage {
	  
	 private List<Hotel> hotelListi = new ArrayList<Hotel>();
	 
	 public ArrayList<Hotel> getHotelListi(){
		 return (ArrayList<Hotel>) this.hotelListi;
	 }
	 
	 public void setHotelToDatabase(Hotel hotel){
		 
	 }
	 
	 public void getHotelFromDatabase(String leitarord) {
		 hotelListi = DatabaseManager.searchHotels(leitarord);
	 }

	 public ArrayList<Review> getReviewsFromDatabase(Hotel hotel) {
		 return DatabaseManager.getReviews(hotel);
	 }
	 
	 public void setHotelInfoToDatabase(){
	   
	 }
	 
	 public void deleteHotelFromDatabase(){
	   
	 }
	 
	 public void setReviewToDatabase(Traveler traveler, Hotel hotel, String review) {
		 
	 }
	 
	 public HotelStorage(){

	 }
	 
}
