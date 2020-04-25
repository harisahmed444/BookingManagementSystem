import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Model.Rating;

public class attendClass {
	 static home homeObj = new home();
	
	public static void attendClass() {
		 homeObj.sc= new Scanner(System.in);
		List<Integer> choices = new ArrayList<>();
		System.out.println("Your Bookings ");
		for(int i = 0; i<homeObj.bm.getCount(); i++) {
			 choices.add(i+1);
			 System.out.println(i+1 + ": " + homeObj.getBookedInfo(homeObj.bm.getBookings(i).getScheduleId()));
			}
		System.out.println("Select A Class To Give Review");
		int choice = homeObj.sc.nextInt();
	    if(choices.contains(choice)) {
	    	if(homeObj.bm.getBookings(choice-1).getreviewed()) {
	    		System.out.println("Class already reviewed by you");
	    	}
	    	else
	    	giveReview(choice);
	    }
	    else
	    {
			System.out.println("-------------Error: Please Select Out Of Given Choices------------");
			attendClass();
		}
	}

	public static void giveReview(int choice) {
		homeObj.sc= new Scanner(System.in);
		System.out.println("Write A Review");
		String review = homeObj.sc.nextLine();
		System.out.println("Rate The Class 1) Very Dissatisfied 2) Dissatisfied 3) Ok 4) Sattisfied 5) Very Sattisfied");
		
		try {
			int rating = homeObj.sc.nextInt();
				if(rating>0&&rating<6)
				{
					Rating obj = new Rating(homeObj.bm.getBookings(choice-1).getClassId(), homeObj.bm.getBookings(choice-1).getScheduleId(), review, rating);
					homeObj.rm.addSchedule(obj);
					homeObj.bm.getBookings(choice-1).setReviewed(true);
				}
				else {
					System.out.println("Rating must be between 1 to 5");
					giveReview(choice);
				}
		}
		catch(InputMismatchException e ) {
			System.out.println("Error: Rating must be an integer ranging from 1 to 5");
			giveReview(choice);
		}


	}


}
