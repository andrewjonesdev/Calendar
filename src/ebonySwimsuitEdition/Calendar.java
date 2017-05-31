package ebonySwimsuitEdition;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		int currentMonth = 0;
		int birthDay = 0;
		int givenMonth = 0;
		int givenYear = 0;
		int age = 0;
		String yesOrNo = "";
		boolean again = false;
		String jan = "Jan";
		String two = "Feb";
		String mar = "Mar";
		String apr = "Apr";
		String may = "May";
		String jun = "Jun";
		String jul = "Jul";
		String aug = "Aug";
		String sep = "Sep";
		String oct = "Oct";
		String nov = "Nov";
		String dec = "Dec";
		String mon = "Mon";
		String tue = "Tue";
		String wed = "Wed";
		String thu = "Thu";
		String fri = "Fri";
		String sat = "Sat";
		String sun = "Sun";
		int givenDay = 1;
		LocalDate date = LocalDate.now();
		Month stringMonth = date.getMonth();
		currentMonth = stringMonth.getValue();
		Scanner numScan = new Scanner(System.in);
		Scanner strScan = new Scanner(System.in);
		int weekDay = 0; 
		//System.out.println(currentMonth==5);
	
	//do{
		
		do{
			//set to negatives so the default will kick the Birthday inputs back to the start if non integers are entered
			birthDay = -10;
			givenMonth = -10;
			givenYear = -10;
			
			//Month Input
			do{
				System.out.println("Enter the month you want a calendar for (ex. January 2, 2017 = 1): ");
				//checks if letters are input
				if (numScan.hasNextInt()){
					givenMonth = numScan.nextInt();
					//checks if the day is valid
					if(givenMonth < 1 || givenMonth > 13){
						System.out.println("The month you entered wasn't valid. Please try again.");					
					}
					//checks if the day exists in this month
					
				}else{
					System.out.println("You didn't submit a whole number. Please try again.");
					numScan.next();
					continue;
				}
			}while(givenMonth < 1 || givenMonth > 13);
			//Year Input
			do{
				System.out.println("Enter the year you want a calendar for (ex. January 2, 2017 = 2017): ");
				//checks if letters are input
				if (numScan.hasNextInt()){
					givenYear = numScan.nextInt();
					//checks if the user has given a date that hasn't occured yet
					
					//checks if date is real or not. B.C. is not accepted
					if(givenYear<0){
						System.out.println("The year you entered wasn't valid. Please try again.");	
					}
					else if ((Integer.toString(givenYear)).length()<4){
						System.out.println("Give a 4 digit year or greater (ex: 0001 0021 0201 2001):");
					}
					
				}else{
					System.out.println("You didn't submit a whole number. Please try again.");
					numScan.next();
					continue;
				}
			}while((givenYear<0) ||  ((Integer.toString(givenYear)).length()<4));
			//Verifies if your birthday has occurred this year and assigns a value. SEE NEXT COMMENT
			
			date = LocalDate.of(givenYear, givenMonth, givenDay);
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
			//System.out.println(LocalDate.parse(date, formatter));
			//System.out.println(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE));
			//DayOfWeek.of(3);
			System.out.println(date.getDayOfWeek());
			System.out.println((date.getDayOfWeek()).getValue());
			System.out.println(date.getMonth().length(givenYear%4==0));
			//System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s", sun, mon, tue, wed, thu, fri, sat);
			System.out.println("\t\t\t" + date.getMonth());
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s", (DayOfWeek.of(7)).toString().substring(0,3), (DayOfWeek.of(1)).toString().substring(0,3), (DayOfWeek.of(2)).toString().substring(0,3), (DayOfWeek.of(3)).toString().substring(0,3), (DayOfWeek.of(4)).toString().substring(0,3), (DayOfWeek.of(5)).toString().substring(0,3), (DayOfWeek.of(6)).toString().substring(0,3));
			System.out.println();
			int week = 1;
			for(int please = 0; please < ( /*(date.getMonth().length(givenYear%4==0) - */(date.getDayOfWeek()).getValue() )/*)*/; please ++ ){
				System.out.print("\t");
				week++;
			}
			for(int count = 1; count <= (date.getMonth().length(givenYear%4==0)); count++){
				
				
					if(((date.getDayOfWeek()).getValue())==7){
						System.out.print(count +"\t");
						
					}
					else{
						System.out.print(count + "\t");
					}
					if(week == 7){
						week=1;
						System.out.println();
					}
					else{
						week++;
					}
					date = LocalDate.of(givenYear, givenMonth, count);
				
				//System.out.println();
				
			}
			System.out.println();
		}while(letsGoAgain(yesOrNo, again, strScan));
	}
	
	public static boolean letsGoAgain(String yesOrNo, boolean again, Scanner strScan){
		do{
			System.out.println("Do you want to continue? Y or N");
			yesOrNo = strScan.nextLine();
			//in case the user types "y" or "n" it will still go through
			yesOrNo = yesOrNo.toUpperCase();
			if(yesOrNo.equals("Y")){
				again = true;
			}
			else if(yesOrNo.equals("N")){
				again = false;
			}
			else{
				System.out.println("You didn't type \"Y\" or \"N\". please try again");
			}
			
		}while((!(yesOrNo.equals("Y"))) && (!(yesOrNo.equals("N"))));
		
		return again;
	}
	
}
