public class HotelVerkefni {
	private HotelController hotelController;

	public void nyLeit() {
		hotelController = new HotelController();
		System.out.println("Ný Leit\nSkrifaðu inn nafn hótels eða staðsetningu.\n");
		String leitarord = StdIn.readString();
		hotelController.search(leitarord);
		hotelController.displayResults();
		
		searchResults();
	}
	
	public void prentaSkodaSpurningar() {
	}

	public void skoda(Hotel hotel) {
		StdOut.print("*****Options*****" + '\n' + "To see picture press 1" + '\n' + "To see review press 2" + '\n' + "To see rooms press 3" + '\n' + "To book a room press 4\n" + "To go back press 5"+ '\n' + "To start a new search press 6");
		int x = StdIn.readInt();
		if (x == 1) {
			hotelController.showPictures(hotel);
			skoda(hotel);
		}
		if (x == 2){
			hotelController.displayReviews(hotel);
			skoda(hotel);
		}
		if (x == 3){
			hotelController.displayRooms(hotel);
			skoda(hotel);
		}
		if (x == 4){
			bookRoom(hotel);
		}
		if(x == 5) {
			searchResults();
		}
		if(x == 6) {
			nyLeit();
		}
		else{
			System.out.println("Please choose a number from the list");
			skoda(hotel);
		}
	}
	
	public void bookRoom(Hotel hotel){
		
		StdOut.print("Choose the starting date on the format DDMMYY");
			
		int dateFrom = StdIn.readInt();
		
		StdOut.print("Choose the final date on the format DDMMYY");
		
		int dateTo = StdIn.readInt();
		
		StdOut.print("These rooms are available on the chosen dates please choose a room from 1-10");
		
		hotelController.displayRooms(hotel);
		
		int roomNr = StdIn.readInt();
		
		StdOut.print("You have chosen room number " + roomNr + "Press 1 to confirm your booking or 2 to cancel");
		
		int val = StdIn.readInt();
		
		if (val == 1){
			System.out.print("Booking complete, you have booked a room at " + hotel + "from " + dateFrom + "to " + dateTo);
			nyLeit();
		}
		if (val == 2){
			StdOut.print("If you want to choose another date press 1, if you want to start a new search press 2");
			 int newDate = StdIn.readInt();
			 if (newDate == 1){
				bookRoom(hotel);
			 }
			 if (newDate == 2){
				nyLeit();
			 }
		}
	
		
	}
	public void searchResults() {

		StdOut.print("To filter press 1" + '\n' + "To sort press 2" + '\n' + "To choose a hotel press 3" + '\n' + "To start a new search press 4");
		
		int val = StdIn.readInt();

		//filter
		if (val==1) {
			StdOut.println('\n' + "*****options*****" + '\n' + "To filter by price press 1" + '\n' + "To filter by quality press 2" + '\n'+ "To go back press 3"+ '\n'+ "To start a new search press 4");
			val = StdIn.readInt();
			//filter by price
			if(val == 1) {
				StdOut.println('\n' + "*****options*****" + '\n' + "Enter maximum price in euros");
				int maxprice =StdIn.readInt();
				hotelController.filter("price", maxprice);
				hotelController.displayResults();
				searchResults();
			}

		
			//filter by quality
			else if(val == 2) {
				StdOut.println('\n' + "*****options*****" + '\n' + "Enter maximum number of stars");
				int maxstars =StdIn.readInt();
				 hotelController.filter("quality", maxstars);
				 hotelController.displayResults(); 
				 searchResults();
			}

			else if(val == 3) {}
			else if (val==4) nyLeit();
			else{
				System.out.println("Please choose a number from the list");
				searchResults();
			}
		}

		//sort
		else if(val==2) {
			 StdOut.println('\n' + "*****options*****" + '\n' + "To sort by price press 1" + '\n' + "To sort by quality press 2" + '\n'+ "To go back press 3"+ '\n'+ "To start a new search press 4" );
			 val = StdIn.readInt();
			 
			 //sortbyprice
			 if(val == 1) {
				StdOut.println('\n' + "*****options*****" + '\n' + "To display results in ascending order press 1" + '\n' + "To display results in descending order press 2");
				val =StdIn.readInt();
			
				//ascending order
				if(val==1){
					hotelController.sort("price", "");
					hotelController.displayResults(); 
					searchResults();
				}
				//descending order
				else if(val==2) {
					hotelController.sort("price", "descending");
					hotelController.displayResults(); 
					searchResults();
				}
				else{
					System.out.println("Please choose a number from the list");
					searchResults();
				}
			}
			 //sortbyquality
			 else if(val == 2) {
				StdOut.println('\n' + "*****options*****" + '\n' + "To display results in ascending order press 1" + '\n' + "To display results in descending order press 2");
				val =StdIn.readInt();
				//asscending order
				if(val==1){
					hotelController.sort("quality", "");
					hotelController.displayResults(); 
					searchResults();
				}
				//descending order
				else if(val==2) {
					hotelController.sort("quality", "descending");
					hotelController.displayResults(); 
					searchResults();
				}
				else{
					System.out.println("Please choose a number from the list");
					searchResults();
				}

			}
			 
			 else if (val==3) {}
			
			 else if(val==4) nyLeit();
			else{
				System.out.println("Please choose a number from the list");
				searchResults();
			}
			
	 }

	//choose a hotel
		else if (val==3) 
		{
		 hotelController.displayResults();
		 StdOut.println('\n' + "*****options*****" + '\n' + "Type the number of the hotel you would like to choose"+ '\n' + "To go back press -1" + '\n' + "To start a new search press -2");
		 val = StdIn.readInt();
		 if (val==-1) {searchResults();}
		 else if(val==-2) {nyLeit();}
		 else {
			 skoda(hotelController.getHotelList().get(val-1));
		 }
		}

		else if (val == 4) { nyLeit();}		 
		else{
			System.out.println("Please choose a number from the list");
			searchResults();
		}
	}

	public static void main(String[] args) {
		HotelVerkefni hV = new HotelVerkefni();
		hV.nyLeit();

	}
}

