package Calender;
import java.awt.Font;
import java.io.Console;
import java.io.IOException;
import java.text.DateFormat.Field;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import java.util.Calendar;
import Calender.*;
import javafx.scene.input.DataFormat;

import java.time.Month;

public class App  {
	static public Scanner scan=new Scanner(System.in);

	public static void main(String[] args)  {
		
		
			printYear();
			scan.close();
	}
	
	
	 static void printYear()  {
		Year y;LocalDate inputDate=null;int select=isDefault();
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM),dateTimePattern=DateTimeFormatter.ofPattern("MMMM dd yyyy, hh:mm");
		
		if(select==1) {
			inputDate=LocalDate.now();
			LocalTime time=LocalTime.now();
			LocalDateTime dateTime=LocalDateTime.of(inputDate, time);
			System.out.println("Your input is: "+dateTimeFormatter.format(dateTime));
			System.out.println(dateTimePattern.format(dateTime));
		}
		else if(select==2) {
			inputDate=input();
			System.out.println("Your input is: "+inputDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));}
			Year.printCustomized(y=new Year(LocalDate.from(inputDate)));
			System.out.printf("\t\t\t\t\t\t\t\t-----------=============<<( YEAR  %1$-5d)>>============----------",y.getNumOfYear());
			System.out.println("");
			for(Calender.Month m:y.getArrayMonthOfYear()) {
				int month=1,week=0;
				System.out.println("\t\t\t\t\t\t\t\t\t\t|--------------------------------|");
				System.out.printf("\t\t\t\t\t\t\t\t\t\t|            %1$-13s       |\n\t\t\t\t\t\t\t\t\t\t|--------------------------------|\n\n",m.getNameOfMonth());
				for(Week w:m.getArrayWeekOfMonth()) {
					if(w==null)continue;
					if(month==0)System.out.printf("\t\t\t\t\t\t\t\t|        |        |        |        |        |        |        |\n");
					System.out.printf("\t\t\t\t\t\t\t\t----------------------------WEEK%1$2d------------------------------\n",w.getNumOfWeekBaseOnYear());
					System.out.printf("\t\t\t\t\t\t\t\t|        |        |        |        |        |        |        |\n");
					if(month==1)System.out.printf("\t\t\t\t\t\t\t\t|---MON--|--TUE---|--WEN---|--THU---|--FRI---|--SAT---|--SUN---|\n",w.getNumOfWeekBaseOnYear());
					
					month=0;
		
					if(week==0)System.out.printf("\t\t\t\t\t\t\t\t|        |        |        |        |        |        |        |\n");
					System.out.print("\t\t\t\t\t\t\t\t");
					for(LocalDate date:w.getArrayDaysOfWeek()) {
						if(date.getDayOfYear()==y.getDate().getDayOfYear()) 
							System.out.printf("|<-(%1$-2d)->",date.getDayOfMonth());
						else
							System.out.printf("| %1$4d   ",date.getDayOfMonth());
						
					}
					week++;
					System.out.print("|\n");
					
				}
				System.out.printf("\t\t\t\t\t\t\t\t|        |        |        |        |        |        |        |\n");	
				System.out.printf("\t\t\t\t\t\t\t\t----------------------------------------------------------------\n");
			}
			System.out.printf("\t\t\t\t\t\t\t\t----------------------------------------------------------------\n");
		
	}
	
	 static int isDefault() {
		System.out.println(">>>PRESS 1<<<\n"+"SHOW THE CALENDER WITH CURRENT DATE\n\n");
		System.out.println(">>>PRESS 2<<<\n"+"YOU CAN PUT A SELECTION DATE\n\n");
		int i=0;
		while (scan.hasNext())
		{
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				
				if (i==1||i==2) {
					break;
				}
			}
			
			scan.nextLine();  
			System.out.println("wrong choice, try again");
		}
		
//		scan.close();
		
		return i;
		
		}
	 static void clearBuffer() {
		 while(scan.hasNext()) {
			 scan.next();
		 }
	 }
	  static LocalDate input() {
		String input;
		String strIn="";LocalDate inputDate=null;//clearBuffer();
		DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyyy MM dd",Locale.ENGLISH);
		System.out.println("<<<<Enter a correct Date according the pattern>>>>\n"+"YYYY MM dd");
		while (inputDate==null && scan.hasNext())
		{
			try {
				strIn=scan.nextLine();
				if (strIn.length()==0)
				strIn=scan.nextLine();
				
				inputDate=LocalDate.parse(strIn, dateFormat); 
				return inputDate;
				
			} catch (Exception e) {
				System.out.println("wrong input\n Try Again!!!  "+e.getMessage());
				//scan.nextLine();
				System.out.println("Enter a correct Date according the pattern YYYY MM dd");
			}

	}
		return null;
		}
	 static void printAloop(LocalDate start,LocalDate end,Period p) {
		int j=0,numOfWeek;
		System.out.println(" \n");
		LocalDate upTo=start;Week w=new Week(start);
		String str="";
		while(upTo.isBefore(end)|end.isEqual(upTo)) {
			str="";
			System.out.println("------------------------------------------------------------------------");
			System.out.printf("%1$-12s>>>> week:%2$-2d>>>>",upTo,w.getNumOfWeekBaseOnYear());
			for(LocalDate i : w.getArrayDaysOfWeek()) 
				str+=String.format("| %1$2d |",i.getDayOfMonth());
			System.out.print(str+"\n");
			
			int offset=upTo.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()-upTo.getDayOfMonth();
			if(upTo.getMonthValue()==12 & offset!=0 && offset<7 )
				{
				 upTo=end;
				 w=new Week(upTo);
					j++;
				}
			else {
				upTo=upTo.plus(p);
				w=new Week(upTo);
				j++;}
		}
		
	}
	
	}

