public class Review{
	private String name;
	private String reviewText;
	private Date date;  
	
	public 	Review(Traveler traveler, String reviewText) {
		this.name = traveler.getName();
		this.reviewText = reviewText;
		this.date = new Date();
	}
	public Review getReviewText { 
		return reviewText;	
	}
	public void setReviewText(String reviewText){
		this.reviewtext=reviewtext;
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
}
