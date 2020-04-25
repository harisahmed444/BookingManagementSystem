import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class changeBooking {

	 static home homeObj = new home();
	
	public static void changeBooking() {
		homeObj.sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		List<Integer> choices = new ArrayList<>();
		for(int i = 0; i<homeObj.bm.getCount(); i++) {
		     choices.add(i+1);
			 System.out.println(i+1 + ": " + homeObj.getBookedInfo(homeObj.bm.getBookings(i).getScheduleId()));
			}
		 System.out.println("Select A Booking To Change ");
		
		 int choice = homeObj.sc.nextInt();
        if(choices.contains(choice)) {
        	homeObj.change = true;
        	 homeObj.classBookingMenu();
    		 if(homeObj.res) {
    			 System.out.println("Booking Changed");
    			
    			 for(int j = 0; j<homeObj.sm.getCount(); j++) {
    				 if(homeObj.sm.getSchedule(j).getId()==homeObj.bm.getBookings(choice-1).getScheduleId()) {
    					 homeObj.sm.getSchedule(j).setNoOfStd(false);
    					 homeObj.bm.removeBooking(choice-1);
    					 break;
    				 }
    			 }
    			
    			
    		 }
    		 else {
    			 System.out.println("Changing Of Booking Unsuccessfull");
    		 }
		 }
        
    	else {
			System.out.println("-------------Error: Please Select Out Of Given Choices------------");
			changeBooking();
		} 
	}
}
