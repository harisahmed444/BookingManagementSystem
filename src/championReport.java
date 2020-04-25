import java.util.ArrayList;
import java.util.List;

public class championReport {
	
	 static home homeObj = new home();
	
	public static void monthlyChampionReport() {
		// TODO Auto-generated method stub
		 System.out.println("Select A Month To View Monthly Champion Report");
			System.out.println(homeObj.sm.getSchedule(0).getDate().charAt(6));
			System.out.println(homeObj.sm.getSchedule(homeObj.sm.getCount()-1).getDate().charAt(6));

			int choice = homeObj.sc.nextInt();
			getMonthlyChampionReport(choice);
	}

	private static void getMonthlyChampionReport(int choice) {
		List<Integer> incomes = new ArrayList<>();
		List<String> classNames = new ArrayList<>();
		int selected = 0;
	    
	    for(int i =0; i<homeObj.cm.getCount(); i++) {
	    	if(choice==4) {
	    		int a = getTotalIncome(homeObj.cm.getClass(i).getId(), 0);
		    	String names = homeObj.cm.getClass(i).getName();
		    	incomes.add(a);
		    	classNames.add(names);
		    	System.out.println("Class Name: " + homeObj.cm.getClass(i).getName() + " Total Income: " + getTotalIncome(homeObj.cm.getClass(i).getId(), 0));
		   
	    	}
	    	else {
	    		int a = getTotalIncome(homeObj.cm.getClass(i).getId(), 1);
		    	String names = homeObj.cm.getClass(i).getName();
		    	incomes.add(a);
		    	classNames.add(names);
		    	System.out.println("Class Name: " + homeObj.cm.getClass(i).getName() + " Total Income: " + getTotalIncome(homeObj.cm.getClass(i).getId(), 1));
		   
	    	}
	    }
	    
	    int max = incomes.get(0);
	    for(int i = 1; i < incomes.size();i++)
		{
			if(incomes.get(i) > max)
			{
				max = incomes.get(i);
				selected = i;
			}
		}
	    System.out.println("----------------------");
	    System.out.println("Champion Class is " +classNames.get(selected) + " with a total income of: " + max);
	    
	    
		
	}

	public static int getTotalIncome(String id, int c) {
		  int result = 0;
		 for(int i =0; i<homeObj.cm.getCount(); i++) {
		    	if(homeObj.cm.getClass(i).getId().equals(id)){
			    		result = getTotalIncomeByClassId(homeObj.cm.getClass(i).getId(), c) * Integer.parseInt(homeObj.cm.getClass(i).getPrice().split(" ")[0]) ;
		    	}
		    }
		return result;
	}

	private static int getTotalIncomeByClassId(String id, int c) {
		return homeObj.getNoOfStd(id, c);
		
	}


}
