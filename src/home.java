import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Controller.BookingManager;
import Controller.ClassManager;
import Controller.RatingManager;
import Controller.ScheduleManager;
import Model.Booking;
import Model.Classes;
import Model.Rating;
import Model.Schedule;


public class home {
	
	 static ClassManager cm = new ClassManager();
	 static ScheduleManager sm = new ScheduleManager();
	 static BookingManager bm = new BookingManager();
	 static RatingManager rm = new RatingManager();
	 private static List<String> classNames;
	 private static List<String> classIds;
	 private static List<String> schedules;
	 private static List<String> ratings;
	 private static List<String> bookings;
	 static Scanner sc;
	 static Boolean res = false;
	 static Boolean change = false;

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 sc= new Scanner(System.in); 
		classNames = new ArrayList<>();
		schedules = new ArrayList<>();
		classIds = new ArrayList<>();
		ratings = new ArrayList<>();
		
		getSchedule();
		getAllClasses();

		
		while(true) {
			System.out.println("------Select Option-------");
			System.out.println("1) Book A Class");
			System.out.println("2) Change A Booking");
			System.out.println("3) Attend A Class");
			System.out.println("4) Monthly Class Report");
			System.out.println("5) Monthly Champion Report");
			System.out.println("6) Check Reviews");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				classBookingMenu();
				break;
			case 2:
				if(bm.getCount()>0)
				{changeBooking obj = new changeBooking();
				obj.changeBooking();
				}
				else
				System.out.println("Book a class first");
				break;
			case 3:
				if(bm.getCount()>0) {
				attendClass obj = new attendClass();
				obj.attendClass();
				}
				else
				System.out.println("Book a class first");
				break;
			case 4:
				monthlyReport obj = new monthlyReport();
				obj.monthlyReport();
				break;
			case 5:
				championReport obj2 = new championReport();
				obj2.monthlyChampionReport();
				break;
			case 6:
				CheckReiew obj3 = new CheckReiew();
				obj3.checkReview();
				break;
			}
		}
	}


	public static int getNoOfStd(String id, int c) {
		int count = 0;
		if(c==0) {
			for(int i = 0; i<23; i++) {
				  if(sm.getSchedule(i).getClassId().equals(id)) {
					  count = count + sm.getSchedule(i).getNoOfStd();
				  }
				}
		}
		else {		
			for(int i = 23; i<sm.getCount(); i++) {
				  if(sm.getSchedule(i).getClassId().equals(id)) {
					  count = count + sm.getSchedule(i).getNoOfStd();
				  }
				}
		}

		return count;
	}


	public static String getBookedInfo(int id) {
		String result = " ";
		for(int i = 0; i<sm.getCount(); i++) {
			   if(sm.getSchedule(i).getId()==id)
				   result = "Class Name: " + getClassName(sm.getSchedule(i).getClassId()) + " Date: " + sm.getSchedule(i).getDate()
				   + "Time: " + sm.getSchedule(i).getTime();
			}
		return result;
	}

	public static void classBookingMenu() {
		System.out.println("Select Search Type" + "\n" + "1: By Name" + "\n" + "2: By Date");
		int choice = sc.nextInt();
		if(choice==1) {
			searchByName();
		}
		else if(choice==2) {
			searchByDate();
		}
		
	}


	private static void getSchedule() {
	    final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date currentDate = new Date("2020/04/04");
        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

		String[] ids = {"1","2","3","4", "5"};
		String[] timings = {"Morning", "Afternoon", "Evening"};
		int count = 0;
		int timeCount = 0;
		int add= 1;
		int DateCount = 0;
		for(int i =0; i<48; i++) {
			if(count>4) {
				count=0;
			}
			
			if(timeCount>2) {
				timeCount = 0;
			}
			
			if(DateCount>5) {
				DateCount = 0;
			}
			

	       
	        // convert calendar to date
	      

			int id = i+1;
			String classId = ids[count];
     		String time = timings[timeCount];
			Schedule obj = new Schedule();
			
			
			if(DateCount==0) {
				if(i==0) {
//					c.add(Calendar.DATE, add-1);
				}
				else {
					c.add(Calendar.DATE, add+5);
				}
			obj.setNoOfStd();
			obj.setNoOfStd();
			obj.setNoOfStd();
			obj.setNoOfStd();
			Rating rating = new Rating(classId, id, "Good", 5);
			rm.addSchedule(rating);
			Rating rating2 = new Rating(classId, id, "Normal", 3);
			rm.addSchedule(rating2);
			Rating rating3 = new Rating(classId, id, "Bad", 5);
			rm.addSchedule(rating3); 
			Rating rating4 = new Rating(classId, id,  "Worse", 1);
			rm.addSchedule(rating4);
			}
			
            if(DateCount==3)  {
				c.add(Calendar.DATE, add);
				obj.setNoOfStd();
				obj.setNoOfStd();
				obj.setNoOfStd();
				Rating rating = new Rating(classId, id, "Best", 5);
				rm.addSchedule(rating);
				Rating rating2 = new Rating(classId, id,  "Normal", 3);
				rm.addSchedule(rating2);
				Rating rating3 = new Rating(classId, id,  "Bad", 2);
				rm.addSchedule(rating3);
			}
            Date currentDatePlusOne = c.getTime();
			String date = dateFormat.format(currentDatePlusOne);
			obj.setDate(date);
			obj.setId(id);
			obj.setTime(time);
			obj.setClassId(classId);
			sm.addSchedule(obj);
			count++;
			timeCount++;
			DateCount++;
		}
				
	}

	private static void getAllClasses() {
		String classes[] = {"Yoga","Zumba","Aquacise","Box Fit","Body Blitz" };
        String prices[] = {"200 Pounds", "180 Pounds","260 Pounds", "100 Pounds","300 Pounds"};
		for(int i = 0; i<5; i++) {
			String name = classes[i];
			String id = String.valueOf(i+1);
			String price = prices[i];
			
			Classes obj = new Classes();
			obj.setId(id);
			obj.setName(name);
			obj.setPrice(price);
			
			cm.addClass(obj);
			
		}
	}

	public static void searchByDate() {
		// TODO Auto-generated method stub
		List<Integer> choices = new ArrayList<>();
		String date = " ";
		int count = 1;
		List<String> dates = new ArrayList<>();
		for(int i = 0; i<sm.getCount(); i++) {
			if(i%3==0 || i==0) {
			choices.add(i+1);
			System.out.println( i+1 + ":" + sm.getSchedule(i).getDate());
			dates.add(sm.getSchedule(i).getDate());
			count++;
			}
			 
		}
		System.out.println("\n");
		System.out.println("------Select Date-------");
		int choice = sc.nextInt();
		if(choices.contains(choice)) {
			getTimeTable(choice);
		}
		else {
			System.out.println("-------------Error: Please Select Out Of Given Choices------------");
			searchByDate();
		}
	}

	private static void getTimeTable(int id) {
		List<Integer> choices  = new ArrayList<>(); 
		for(int i = 0; i<sm.getCount(); i++) {
			if(sm.getSchedule(i).getId()==id) {
				choices.add(i);
				choices.add(i+1);
				choices.add(i+2);
				System.out.println( sm.getSchedule(i).getId() + " Timing: " + sm.getSchedule(i).getTime() + " " + getClassName(sm.getSchedule(i).getClassId()));
				System.out.println( sm.getSchedule(i+1).getId() + " Timing: " + sm.getSchedule(i+1).getTime() + " " + getClassName(sm.getSchedule(i+1).getClassId()));
				System.out.println( sm.getSchedule(i+2).getId() + " Timing: " + sm.getSchedule(i+2).getTime() + " " + getClassName(sm.getSchedule(i+2).getClassId()));
			}
			}
		System.out.println("------Select Class-------");
		int choice = sc.nextInt();
		if(choices.contains(choice)) {
			bookClass(choice);
		}
		else {
			System.out.println("-------------Error: Please Select Out Of Given Choices------------");
			getTimeTable(id);
		}
		
	}

	public static void bookClass(int choice) {
		for(int i = 0; i<sm.getCount(); i++) {
			if(sm.getSchedule(i).getId()==choice) {
				if(sm.getSchedule(i).getNoOfStd()>=4) {
				System.out.println("No Space Available");
				break;
				}
				else {
					if(bm.getCount()>0) {
					    sm.register(i);
					    for(int j = 0; j<bm.getCount(); j++) {
					    	if(change) {
					    		 System.out.println("Class Booked");
					    		 Booking obj = new Booking(sm.getSchedule(i).getClassId(), sm.getSchedule(i).getId(), false);
								 bm.addBooking(obj);
								 res = true;
								 change = false;
								 break;
					    	}
					    	else {
					    		if(sm.getSchedule(i).getClassId()==bm.getBookings(j).getClassId()) {
						    		System.out.println("Class Already Booked By You");
						    		break;
						    	}
						    	else {
						    		 System.out.println("Class Booked");
						    		 Booking obj = new Booking(sm.getSchedule(i).getClassId(), sm.getSchedule(i).getId(), false);
									 bm.addBooking(obj);
									 res = true;
									 break;
						    	}
					    	}
					    	
					    }
					}
					else {
						 sm.register(i);
						 System.out.println("Class Booked");
			    		 Booking obj = new Booking(sm.getSchedule(i).getClassId(), sm.getSchedule(i).getId(), false);
						 bm.addBooking(obj);
						 res = true;
						 break;
					}

				   
					
				}
				
			}
			}
	}

	public static String getClassName(String classId) {
		String name = " ";
		for(int i = 0; i<cm.getCount(); i++) {
			if(cm.getClass(i).getId().equals(classId)) {
				name = "Class Name:" + " " + cm.getClass(i).getName() + " Price: " + cm.getClass(i).getPrice();
			}
		}
		return name;
	}

	private static void searchByName() {
		System.out.println("Select Class By Name");
		System.out.println("1: Yoga" + "\n" + "2: Zumba" + "\n" + "3: Aquacise" + "\n" + "4: Box Fit" + "\n" +"5: Body Blitz" );
		int choice = sc.nextInt();
		getTimeTableByClassName(choice);
	}

	private static void getTimeTableByClassName(int choice) {
		List<Integer> choices = new ArrayList<>();
		for(int i = 0; i<sm.getCount(); i++) {
			if(String.valueOf(choice).equals(sm.getSchedule(i).getClassId())) {
				choices.add(sm.getSchedule(i).getId());
			System.out.println(sm.getSchedule(i).getId() + " Date: " + sm.getSchedule(i).getDate() + " Time: " + sm.getSchedule(i).getTime());
			}
		}
		System.out.println("Select a class");
		int c = sc.nextInt();
		if(choices.contains(c)) {
			bookClass(c);
		}
		else {
			System.out.println("-------------Error: Please Select Out Of Given Choices------------");
			getTimeTableByClassName(choice);
		}
		
	}

}
