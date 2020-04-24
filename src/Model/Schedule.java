package Model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	
	String  classId, time, Date;
	int noOfStd, id;
	
	public Schedule() {
	
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setNoOfStd() {
		noOfStd++;
	}
	
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public String getClassId() {
		return classId;
	}
	
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setDate(String Date) {
		this.Date = Date;
	}
	
	public int getId() {
		return id;
	}
	
	public String getClassName() {
		return classId;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return Date;
	}
	
	public int getNoOfStd() {
		return noOfStd;
	}

	public void setNoOfStd(boolean b) {
		if(!b) {
			noOfStd--;
		}
		
	}

}
