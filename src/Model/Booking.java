package Model;

public class Booking {

	String classId;
	int scheduleId;
	Boolean reviewed;
	
	public Booking(String classId, int scheduleId, Boolean reviewed) {
		this.classId = classId;
		this.scheduleId = scheduleId;
		this.reviewed = reviewed;
	}
	
	public String getClassId() {
		return classId;
	}
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setReviewed(Boolean reviewed){
		this.reviewed = reviewed;
	}
	
	public Boolean getreviewed() {
		return this.reviewed;
	}

	
}
