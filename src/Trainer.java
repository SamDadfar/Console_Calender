import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import  java.util.Collections.*;
import java.util.function.*;

public class Trainer{
	
	public static void main(String... args) {
		//Trainer train=new Trainer();
		List<Text> list=new ArrayList<Text>();
		List<Plant> plantList=new ArrayList<>();
		list.add(new Text("Love Story","Some Text About Nothing",true));
		list.add(new Text("Persian History","Some Text in it",false));
		plantList.add(new Plant("Earth",true));plantList.add(new Plant("Mars",false));
		print(list,a -> a.isForeign());
		plantPrint(plantList,a -> a.isPlant() );
		
	}
	

	private static void print(List<Text> list,Predicate<Text> a) {
		for(Text t:list) {
			if(a.test(t))
				System.out.println("Text is A Foreign Language: "+t);
		}
	}
	 
	private static void plantPrint(List<Plant> list,Predicate<Plant> p) {
		for(Plant item:list) {
			if(p.test(item))
				System.out.println("Name of Plant is: ");
		}
	}
	
  static class Text{
	public String title,body,footer;
	public StringBuilder strBuilder;
	public boolean foreignLang;
	public boolean isForeign() {
		return foreignLang;
	}
	public Text(String title,String body,boolean foreignLang) {
		this.title=title;
		this.body=body;
		this.foreignLang=foreignLang;
	}
	public String toString() {
		return title;
	}
}
 static class Plant {
	 public String name;boolean isAplanet;
	 public Plant(String s,boolean b) {
		 name=s;isAplanet=b;
	 }
	public boolean isPlant() {
		return isAplanet;
	}
}
 public interface Predicate<T>{
	//String addString(T t);
	boolean test(T t);
}}



