
public class Project019 {
	/**
	 * 1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, 
but not on a century unless it is divisible by 400.
	 * 
	 * How many Sundays fell on the first of the month during 
	 * the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 *  This wont be that easy;
	 */

	public static void main(String[] args) {
		int sundaysOnFirstCount = 0;
		int currentDay = 1;//starts on a Monday
		int currentMonth = 1;//starts in January
		int currentDayOfMonth = 1;
		int currentYear = 1900;
		while(currentYear < 2001) {
			//advance a day
			currentDay = currentDay + 1;
			currentDayOfMonth = currentDayOfMonth + 1;
			if(currentDay == 8) {currentDay = 1;}
			//for thirty-one day months(1,3,5,7,8,10,12)
			if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || 
					currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || 
					currentMonth == 12) {
				if(currentDayOfMonth == 32) {
					currentDayOfMonth = 1;
					currentMonth = currentMonth + 1;
					if(currentMonth == 13) {
						currentYear = currentYear + 1;
						System.out.println("Happy New Year: " + currentYear);
						currentMonth = 1;
					}
				}
			}
			//for 30 day months(4,6,9,11)
			if(currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || 
					currentMonth == 11) {
				if(currentDayOfMonth == 31) {
					currentDayOfMonth = 1;
					currentMonth = currentMonth + 1;
				}
				
			}
			//for friggin' february
			if(currentMonth == 2) {
				if(currentYear %4 == 0) {
					//has 29 days
					if(currentDayOfMonth == 30) {
						currentDayOfMonth = 1;
						currentMonth = currentMonth + 1;
					}
				}
				else {
					if(currentDayOfMonth == 29) {
						currentDayOfMonth = 1;
						currentMonth = currentMonth + 1;
					}
					
				}
			}
			//now count the sundays
			if(currentYear > 1900) {
				if(currentDayOfMonth == 1) {
					if(currentDay == 7) {
						sundaysOnFirstCount++;
					}
				}
			}
		}
		System.out.println("\n"+ sundaysOnFirstCount + " Sundays on the First.");
		//171 is the correct answer.

	}

}
