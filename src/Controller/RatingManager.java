package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Rating;
import Model.Schedule;

public class RatingManager {
	
	private List<Rating> listOfRatings;
	
	public RatingManager() {
		listOfRatings = new ArrayList<>();
	}
	
	public int getCount() {
		return listOfRatings.size();
	}
	
	public int addSchedule(Rating c) {
		listOfRatings.add(c);
		return listOfRatings.size();
	}
	
	public Rating getRating(int index) {
		if(index < 0 || index >= getCount()) {
			return null;
		}
		return this.listOfRatings.get(index);
	}
	

}
