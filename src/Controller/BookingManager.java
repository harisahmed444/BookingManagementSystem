package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Booking;
import Model.Classes;

public class BookingManager {

	private List<Booking> listOfBookings;
	
	public BookingManager() {
		listOfBookings = new ArrayList<>();
	}
	
	public int getCount() {
		return listOfBookings.size();
	}
	
	public int addBooking(Booking c) {
		listOfBookings.add(c);
		return listOfBookings.size();
	}
	
	public Booking getBookings(int index) {
		if(index < 0 || index >= getCount()) {
			return null;
		}
		return this.listOfBookings.get(index);
	}
	
	public void removeBooking(int index) {
		
		this.listOfBookings.remove(index);		
	}
}
