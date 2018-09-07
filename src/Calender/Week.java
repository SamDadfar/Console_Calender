package Calender;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Calendar;

public class Week extends Day {
	
	private int numOfWeekBaseOnYear;
	private LocalDate[] arrayDaysOfWeek,arrayM;
	private int dayOfWeek;
	private TemporalField dayOfWeekField,numOfWeekField;
	
	Calendar cal=Calendar.getInstance();
	{
		arrayDaysOfWeek=new LocalDate[weekDays.length];
		dayOfWeekField=WeekFields.of(Locale.getDefault()).dayOfWeek();
		numOfWeekField=WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		
	}
	public Week() {
		this(LocalDate.now());
	}
	public Week(LocalDate date) {
		super(date);
		setDayOfWeek(date);
		setNumOfWeekBaseOnYear(date);
		setArrayDaysOfWeek();	
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	
	public LocalDate[] getArrayDaysOfWeek() {
		return arrayDaysOfWeek;
	}
	
	public void setNumOfWeekBaseOnYear(LocalDate date) {
		numOfWeekBaseOnYear=date.get(numOfWeekField);
	}
	public int getNumOfWeekBaseOnYear() {
		return numOfWeekBaseOnYear;
	}
	public void setDayOfWeek(LocalDate date) {
		dayOfWeek=date.get(dayOfWeekField);
	}
	public void setArrayDaysOfWeek() {
		int nod,dow;
		nod=getNumOfDay();dow=getDayOfWeek();
		if(nod < dow)
			firstWeekOfMonth();
		else {
			
			switch(dayOfWeek) {
			case 1:{
				for(int i=0;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(i);
				break;
			}
			case 2:{
				for(int i=1,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=2,plus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(plus++);
				break;
			}
			case 3:{
				for(int i=2,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=3,plus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(plus++);
				break;
			}
			case 4:{
				for(int i=3,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=4,plus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(plus++);
				break;
			}
			case 5:{
				for(int i=4,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=5,plus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(plus++);
				break;
				}
			case 6:{
				for(int i=5,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
					arrayDaysOfWeek[6]=getDate().plusDays(1);
				break;
				}
			default:{
				for(int i=6,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				}
			}
		
		}}
	
	public void firstWeekOfMonth() {
		
		switch(dayOfWeek) {
			case 2:{
				arrayDaysOfWeek[0]=getDate().minusDays(1);
				for(int i=1,plus=0;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(plus++);
				break;
			}
			case 3:{
				for(int i=2,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=3,minus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(minus++);
				break;
			}
			case 4:{
				for(int i=3,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=4,minus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(minus++);
				break;
			}
			case 5:{
				for(int i=4,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				for(int i=5,minus=1;i<weekDays.length;i++) 
					arrayDaysOfWeek[i]=getDate().plusDays(minus++);
				break;
				}
			case 6:{
				for(int i=5,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
					arrayDaysOfWeek[6]=getDate().plusDays(1);
				break;
				}
			default:{
				for(int i=6,minus=0;i>=0;i--,minus++)
					arrayDaysOfWeek[i]=getDate().minusDays(minus);
				}
	}
	}
}
	
		
		
		
	

