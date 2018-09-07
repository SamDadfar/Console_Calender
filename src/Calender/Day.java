package Calender;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Day {

	private LocalDate date;
	private int numOfDay;
	private int numOfMonth;
	private int numOfYear;
	private float temp;
	public  static String[] weekDays={DayOfWeek.MONDAY.toString(),DayOfWeek.TUESDAY.toString(),DayOfWeek.WEDNESDAY.toString(),
			DayOfWeek.THURSDAY.toString(),DayOfWeek.FRIDAY.toString(),DayOfWeek.SATURDAY.toString(),DayOfWeek.SUNDAY.toString()};
	
	public static  float default_temp=25;
	
	
	
	public Day() {
		this(LocalDate.now());	
	}	
	public Day(LocalDate date) {
		setDate(date);
		setNumOfDay(date);
		setNumOfMonth(date);
		setNumOfYear(date);
		setTemp(default_temp);
	}
	public void setNumOfDay(LocalDate date) {
		numOfDay=date.getDayOfMonth();
	}
	public void setNumOfMonth(LocalDate date) {
		numOfMonth=date.getMonthValue();
	}
	public void setNumOfYear(LocalDate date) {
		numOfYear=date.getYear();
	}
	public int getNumOfYear() {
		return numOfYear;
	}
	public int getNumOfMonth() {
		return numOfMonth;
	}
	public int getNumOfDay() {
		return numOfDay;
	}
	public void setDate(LocalDate date) {
		this.date=date;
	}
	public LocalDate getDate() {
		return date;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	
}
