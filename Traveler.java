public class Traveler {
  
  private String sSN;
  private String name;
  
  public void setSSN(String sSN){ //a ad vera void?
    this.sSN=sSN;
  } 
  public String getSSN(){
    return sSN;
  }
  public void setName(String name){ //a ad vera void?
    this.name=name;
  } 
  public String getName(){
    return name;
  }
  Traveler(String sSN, String name){
    this.sSN=sSN;
    this.name=name;
  }
}
