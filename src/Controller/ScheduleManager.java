package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Classes;
import Model.Schedule;

public class ScheduleManager {
	private List<Schedule> listOfSchedules;
	
	public ScheduleManager() {
		listOfSchedules = new ArrayList<>();
	}
	
	public int getCount() {
		return listOfSchedules.size();
	}
	
	public int addSchedule(Schedule c) {
		listOfSchedules.add(c);
		return listOfSchedules.size();
	}
	
	public Schedule getSchedule(int index) {
		if(index < 0 || index >= getCount()) {
			return null;
		}
		return this.listOfSchedules.get(index);
	}
	
	public void register(int index) {
		listOfSchedules.get(index).setNoOfStd();
	}
}
