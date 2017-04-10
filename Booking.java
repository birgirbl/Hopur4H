import java.util.Date;

public class Booking {

	private Hotel hotel;
	private Date dateFrom;
	private Date dateTo;
	private Room room;
	private Traveler traveler;
	
	public Hotel getHotel(){
		return hotel;
	}
	
	public void setHotel(Hotel hotel){
		this.hotel = hotel;
	}
	
	public Room getRoom(){
		return room;
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public Traveler getTraveler(){
		return traveler;
	}
	
	public void setTraveler(Traveler traveler){
		this.traveler = traveler;
	}
	
	public Date getDateFrom(){
		return dateFrom;
	}
	
	public void setDateFrom(Date dateFrom){
		this.dateFrom = dateFrom;
	}
	
	public Date getDateTo(){
		return dateTo;
	}
	
	public void setDateTo(Date dateTo){
		this.dateTo = dateTo;
	}
	
	public String toString(){
			return hotel.getHotelName()  + " | " + dateFrom + "-" + dateTo + " | " + room.getRoomType() + " | " + traveler.getName();
		}
	
// Smidur
	
	public Booking(Hotel hotel, Traveler traveler, Date dateFrom, Date dateTo){
	this.hotel = hotel;
	this.traveler = traveler;
	this.dateFrom = dateFrom;
	this.dateTo = dateTo;
	

	}
	
}
