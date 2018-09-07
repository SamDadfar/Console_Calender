package Calender;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAdjusters.*;
public class Month extends Week {
	public final static TemporalAdjuster NEXT_WEEK,LAST_DAY_MONTH,FIRST_DAY_MONTH;
	private Week[] arrayWeeksOfMonth;
	private String nameOfMonth;
	private LocalDate firstDayOfMonth,LastDayOfMonth;
	public static String[] NAME_OF_MONTH={" ",java.time.Month.JANUARY.toString(),java.time.Month.FEBRUARY.toString(),java.time.Month.MARCH.toString(),java.time.Month.APRIL.toString()
			,java.time.Month.MAY.toString(),java.time.Month.JUNE.toString(),java.time.Month.JULY.toString(),java.time.Month.AUGUST.toString(),
			java.time.Month.SEPTEMBER.toString(),java.time.Month.OCTOBER.toString(),java.time.Month.NOVEMBER.toString(),java.time.Month.DECEMBER.toString()};;
static {
		NEXT_WEEK=TemporalAdjusters.ofDateAdjuster(date -> date.plusWeeks(1));
		LAST_DAY_MONTH=TemporalAdjusters.lastDayOfMonth();
		FIRST_DAY_MONTH=TemporalAdjusters.firstDayOfMonth();
	}
	public Month() {
		this(LocalDate.now());
	}
	
	public Month(LocalDate date) {
		super(date);
		setFirstDayOfMonth(date);
		setArrayWeeksOfMonth(date);
		setNameOfMonth(date);
	}
	public void setNameOfMonth(LocalDate date) {
		int month=date.getMonthValue();
		for(int i=0;i<=NAME_OF_MONTH.length;i++) {
			if(month==i) {
			nameOfMonth=NAME_OF_MONTH[i];
			break;}
		}	
	}
	public String getNameOfMonth() {
		return nameOfMonth;
	}
	public boolean findOverLoad() {
		if((getFirstDayOfMonth().getDayOfWeek().getValue()>6 & getDate().lengthOfMonth()>29)
			||(getDate().lengthOfMonth()>30 & getFirstDayOfMonth().getDayOfWeek().getValue()>5))
			return true;
		else 
			return false;
	}
	public void setArrayWeeksOfMonth(LocalDate date) {
		if(findOverLoad())
			arrayWeeksOfMonth=new Week[6];
		else
			arrayWeeksOfMonth=new Week[5];
		for(int i=0;i<arrayWeeksOfMonth.length;i++) {
			
			arrayWeeksOfMonth[i]=new Week(date.plusWeeks(i));
		}
	}
	public Week[] getArrayWeekOfMonth() {
		return arrayWeeksOfMonth;
	}
	public  void setFirstDayOfMonth(LocalDate date) {
		firstDayOfMonth=date.with(FIRST_DAY_MONTH);
	}
	public LocalDate getFirstDayOfMonth() {
		return firstDayOfMonth;
	}
	public void setLastDayOfMonth(LocalDate date) {
		LastDayOfMonth=date.with(LAST_DAY_MONTH);
	}
	public LocalDate getLastDayOfMonth() {
		return LastDayOfMonth;
	}
	
	

}
