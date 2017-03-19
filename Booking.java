public class Booking{

private String HotelName;
private String room;
private Traveler traveler; 
private Date dateFrom;
private Date dateTo; 

public String getHotelName { 
return HotelName; 
}
public void setHotelName(String HotelName){
 this.HotelName=HotelName;
}
public String getRoom(){
 return room;
}
public void setRoom(String room)
{
 this.room=room;
}
public Traveler getTraveler(){
 return traveler;
}
public Date getDateFrom() { 
return dateFrom; 
}
public void setDateFrom(Date DateFrom){
 this.dateFrom=dateFrom;
}
public Date getDateTo(){
 return dateTo;
}
public void setDateTo(Date dateTo){
 this.dateTo=dateTo;
}
//smidur skrifa inn
//Booking(hotelName:String, room:String, traveler:Traveler, dateFrom:Date, dateTo:Date)
}