import java.util.ArrayList;
import java.util.List;

public class Hotel{

	private String hotelName;
	private ArrayList<Room> rooms; //athuga með tagið, þetta er listi eða fylki
	private String location;
	private ArrayList<Review> review;  //athuga með tagið, þetta er listi eða fylki
	private Picture picture; //athuga með tagið, þetta er listi eða fylki
	private int quality;
	
	public String getHotelName() {
		return hotelName;
	}
	
	public ArrayList<Review> getReview() { //athuga með tagið, þetta er listi eða fylki
		return review;	
	}
	
	public void setReview(Traveler traveler, String reviewText){
		review.add(new Review(traveler, reviewText));
	}
	
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	public int getQuality() {
		return quality;
	}
	
	public void setPic(Picture picture){
		this.picture=picture;
	}
	
	public Picture getPic(){
		return picture;
	}
	public void setRoom(String roomType,int price){
		Room x = new Room(roomType, price);
		rooms.add(x);
	}
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	public void setLocation(String city)
	{
		this.location=location;
	}
	public String getLocation(){
		return location;
	}
	
	public void showPictures() {
		
	}
	
	public Hotel(String hotelName, String location) {
		this.hotelName = hotelName;
		this.location = location;
		this.review = new ArrayList<Review>();
		rooms = new ArrayList<Room>();
	}
	
	public Hotel(String hotelName) {
		this.hotelName = hotelName;
		this.review = new ArrayList<Review>();
		rooms = new ArrayList<Room>();
	}

}