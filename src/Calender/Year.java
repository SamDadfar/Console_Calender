package Calender;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Year extends Month {
	
private Month[] arrayMonthOfYear;
private int numOfdays;
public static int numOfmonths=12;
public enum season {SPRING,SUMMER,AUTUMN,WINTER}

public Year() {
	this(LocalDate.now());
}
public Year(LocalDate date) {
	super(date);
	setarrayMonthOfYear(date);
}
public Month[] getArrayMonthOfYear() {
	return arrayMonthOfYear;
}
public void setarrayMonthOfYear(LocalDate date) {
	arrayMonthOfYear=new Month[12];
	for(int i=0;i<12;i++) 
		arrayMonthOfYear[i]=new Month(date.with(TemporalAdjusters.firstDayOfYear()).plusMonths(i));
	
}
public static void printCustomized(Year year) {
	for(int i=1,j=0;i<year.getArrayMonthOfYear().length;i++,j++) {
		if(year.getArrayMonthOfYear()[j].getArrayWeekOfMonth()[year.getArrayMonthOfYear()[j].getArrayWeekOfMonth().length-1].getArrayDaysOfWeek()[6].getDayOfMonth()==
				year.getArrayMonthOfYear()[j].getArrayWeekOfMonth()[year.getArrayMonthOfYear()[j].getArrayWeekOfMonth().length-1].getArrayDaysOfWeek()[6].lengthOfMonth())
			continue;	
		year.getArrayMonthOfYear()[i].getArrayWeekOfMonth()[0]=null;
		
	}
}

}
