
package action.form;

import java.util.Calendar;

import org.apache.struts.action.ActionForm;


public class ReserveListForm extends ActionForm {
	private int building;
	private int year;
	private int month;
	private int day;
	
	public ReserveListForm(){
		//1)初期化について
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DATE);
		building = 1;
	}
	
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
