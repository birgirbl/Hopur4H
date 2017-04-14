import java.util.Date;

public class Review{

	private String name;
	private String reviewText;
	private Date date;  
	
	public String getReviewText() { 
		return reviewText;	
	}
	
	public void setReviewText(String reviewText){
		this.reviewText=reviewText;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String toString() {
		return name + " | " + reviewText + " | " + date;
	}
	
	//smidur skrifa inn
	public Review(Traveler traveler, String reviewText) {
		this.name = traveler.getName();
		this.reviewText = reviewText;
		this.date = new Date();
	}
}
