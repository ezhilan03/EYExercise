package EYExercise.day16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
public class DateDemo {
	public static void main(String[] args) {
		LocalDateTime currentDateTime=LocalDateTime.now();
		
		System.out.println("Current Time...:"+currentDateTime);
		
		LocalDate currentDate=currentDateTime.toLocalDate();
		System.out.println("CurrentDate..:"+currentDate);
		
		LocalTime currentTime=currentDateTime.toLocalTime();
		System.out.println("CurrentTime..:"+currentTime);
		
		Month month=currentDateTime.getMonth();
		int year=currentDateTime.getYear();
		int day=currentDateTime.getDayOfMonth();
		
		int hr=currentDateTime.getHour();
		int mts=currentDateTime.getMinute();
		int scs=currentDateTime.getSecond();
		
		System.out.println(day+"/"+month.getValue()+"/"+year);
		
		System.out.println(hr+":"+mts+":"+scs);
		
		LocalDate customDate=LocalDate.of(2018, Month.JANUARY, 1);
		
		System.out.println(customDate.getDayOfMonth());
		
		LocalTime customTime=LocalTime.of(2,20, 15);
		System.out.println(customTime);
		
		LocalTime parseTime=LocalTime.parse("02:15:30");
		System.out.println(parseTime.getMinute());
		
		LocalDate nextCentury=customDate.plus(10,ChronoUnit.MONTHS);
		System.out.println(nextCentury);
		
		LocalTime nextTime=customTime.plus(1,ChronoUnit.HOURS);
		System.out.println(nextTime);
		
		ZonedDateTime internationalDateTime=ZonedDateTime.now();
		System.out.println(internationalDateTime);
		
		ZonedDateTime ktime=ZonedDateTime.parse("2021-03-09T13:55:36.591593100+05:30[Asia/Karachi]");
		System.out.println(ktime);
		
	}
}
/*
 * 1. XML to Excel
 * 2. XML to PDF
 * 3. Multithreaded server
 * (one to one and one to all)(private and public)
 * 4. xml to email - invoice details to go in body of email
 * 5. xml to sms (onlye invno, customer name and total)
 * 6. Pacel tracking / consignment tracking (domestic and international)
 *
 * 1. You are asked to calculate the Date and Time on which the consignment will reach.
 * a. Domestic (within India)
 * b. International (all over world) - Time zones have to be considered.
 * Input parameters will be
 * Start Date:
 * Start Time:
 * Place of Origin:
 * Place of Destination:
 * Distance:
 * Travel Speed:
 * Travel Break in hrs and mts.
 * conditions
 * Consignment does not move on Saturday and Sunday - holiday (Morning 6 to Next day Morning 6)
 * Consignment does not move on jan1, aug15, oct 2, jan 26. (Morning 6 to Next day Morning 6)
 */