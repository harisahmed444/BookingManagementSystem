import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Model.Rating;

public class CheckReiew {
	 static home homeObj = new home();
		
	public static void checkReview() {
        
		System.out.println("Select A Class To Check Reviews");
			System.out.println("1: Yoga" + "\n" + "2: Zumba" + "\n" + "3: Aquacise" + "\n" + "4: Box Fit" + "\n" +"5: Body Blitz" );
			String choice = homeObj.sc.next();
			getReviewsByClass(choice);
	}

	private static void getReviewsByClass(String choice) {
		    int count = 1;
	        for(int i = 0; i<homeObj.rm.getCount(); i++) {
	          if(homeObj.rm.getRating(i).getClassId().equals(choice)){
	        	  System.out.println("Review " + count + ": " + homeObj.rm.getRating(i).getReview() );
	        	  count++;
	          }
	        }
	}
	



}
