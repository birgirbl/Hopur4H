public class Room {

 private String roomType;
 private int price;
 
 public void setRoomType(String type) {
  this.roomType = type;
 }
 
 public String getRoomType() {
  return this.roomType;
 }

 public void setPrice(int price) {
  this.price = price;
 }
 
 public int getPrice() {
  return this.price;
 }
 
 public Room(String roomType, int price){
  setRoomType(roomType);
  setPrice(price);
 }
}
