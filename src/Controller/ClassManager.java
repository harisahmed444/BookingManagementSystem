package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Classes;

public class ClassManager {

	private List<Classes> listOfClasses;
	
	public ClassManager() {
		listOfClasses = new ArrayList<>();
	}
	
	public int getCount() {
		return listOfClasses.size();
	}
	
	public int addClass(Classes c) {
		listOfClasses.add(c);
		return listOfClasses.size();
	}
	
	public Classes getClass(int index) {
		if(index < 0 || index >= getCount()) {
			return null;
		}
		return this.listOfClasses.get(index);
	}
}
