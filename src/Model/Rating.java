package Model;

public class Rating {
	
	String classId, review;
	int rating, scheduleId;
	
	public Rating(String classId, int scheduleId,  String review, int rating) {
		this.classId = classId;
		this.review = review;
		this.rating = rating;
		this.scheduleId = scheduleId;
	}
	
	public String getClassId() {
		return this.classId;
	}
	
	public String getReview() {
		return this.review;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public int getScheduleId() {
		return this.scheduleId;
	}

}
