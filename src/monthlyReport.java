
public class monthlyReport {
	
	 static home homeObj = new home();
	
	public static void monthlyReport() {

        System.out.println("Select A Month To View Monthly Report");
		System.out.println(homeObj.sm.getSchedule(0).getDate().charAt(6));
		System.out.println(homeObj.sm.getSchedule(homeObj.sm.getCount()-1).getDate().charAt(6));

		int choice = homeObj.sc.nextInt();
		getMonthlyReport(choice);
}

private static void getMonthlyReport(int choice) {
if(choice==4) {
	for(int i = 0; i<homeObj.cm.getCount(); i++) {
	   System.out.println( homeObj.getClassName(homeObj.cm.getClass(i).getId()) + " Students: " + getNoOfStd(homeObj.cm.getClass(i).getId(), 0)
	   + " Average Rating: " + getAverageRating(homeObj.cm.getClass(i).getId(), 0)/getNoOfStd(homeObj.cm.getClass(i).getId(), 0)
			   );
	}
}
else if(choice==5) {
	for(int i = 0; i<homeObj.cm.getCount(); i++) {
		   System.out.println( homeObj.getClassName(homeObj.cm.getClass(i).getId()) + " Students: " + getNoOfStd(homeObj.cm.getClass(i).getId(), 1)
		   + " Average Rating: " + getAverageRating(homeObj.cm.getClass(i).getId(), 1)/getNoOfStd(homeObj.cm.getClass(i).getId(), 1)
				   );
		}
}

}

public static int getAverageRating(String id, int c) {
int rating = 0;
if(c==0) {
	for(int i =0; i<homeObj.rm.getCount(); i++) {
		if(homeObj.rm.getRating(i).getClassId().equals(id) && homeObj.rm.getRating(i).getScheduleId()<24)
			 rating = rating + homeObj.rm.getRating(i).getRating();
	}
}
else {
	for(int i =0; i<homeObj.rm.getCount(); i++) {
		if(homeObj.rm.getRating(i).getClassId().equals(id) && homeObj.rm.getRating(i).getScheduleId()>=24)
			 rating = rating + homeObj.rm.getRating(i).getRating();
	}
}

return rating;
}

private static int getNoOfStd(String id, int c) {
int count = 0;
if(c==0) {
	for(int i = 0; i<23; i++) {
		  if(homeObj.sm.getSchedule(i).getClassId().equals(id)) {
			  count = count + homeObj.sm.getSchedule(i).getNoOfStd();
		  }
		}
}
else {		
	for(int i = 23; i<homeObj.sm.getCount(); i++) {
		  if(homeObj.sm.getSchedule(i).getClassId().equals(id)) {
			  count = count + homeObj.sm.getSchedule(i).getNoOfStd();
		  }
		}
}

return count;
}

}
