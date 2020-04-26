import static org.junit.Assert.*;

import org.junit.Test;

import Controller.BookingManager;
import Controller.ScheduleManager;

public class TestCases {

	@Test
	public void TestCase1() {
		home obj = new home();
		int result = obj.getNoOfStd("1", 0);
		assertEquals(7, result);
	}
	
	@Test
	public void TestCase2() {
		home obj = new home();
		String result = obj.getBookedInfo(1);
		assertEquals("Class Name: Date:2020/04/04Time:Morning", result);
	}
	
	@Test
	public void TestCase3() {
		home obj = new home();
		String result = obj.getClassName("1");
		assertEquals("Class Name: Yoga Price: 200 Pounds", result);
	}
	
	@Test
	public void TestCase4() {
		monthlyReport obj = new monthlyReport();
		int result = obj.getAverageRating("1", 0);
		assertEquals(24, result);
	}
	
	@Test
	public void TestCase5() {
		championReport obj = new championReport();
		int result = obj.getTotalIncome("1", 0);
		assertEquals(1400, result);
	}
	
	@Test
	public void TestCase6() {
		home obj = new home();
		int prevCount = obj.bm.getCount();
		obj.bookClass(6);
		assertEquals(prevCount+1, obj.bm.getCount());
	}
	
	@Test
	public void TestCase7() {
		home homeObj = new home();
		attendClass obj = new attendClass();
		Boolean reviewed = homeObj.bm.getBookings(0).getreviewed();
		obj.attendClass();
		assertEquals(!reviewed , homeObj.bm.getBookings(0).getreviewed());
	}

}
