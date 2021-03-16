package EYExercise.assignment.consignmentTrack;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsignmentTrackerDemo {
	public static void main(String[] args) {
		ConsignmentTrack obj = new ConsignmentTrack();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter starting date in YYYY-MM-DD : ");
		String startDate = scan.next();
		System.out.println("Enter starting time in HH:MM:SS : ");
		String startTime = scan.next();
		System.out.println("Enter travel distance in KM : ");
		double distance = scan.nextDouble();
		System.out.println("Enter travel speed in KMPH: ");
		double speed = scan.nextDouble();
		System.out.println("Enter travel break in HH:MM:SS : ");
		String travelBreak = scan.next();
		
		obj.setStartDate(startDate);
		obj.setsTime(startTime);
		obj.setDist(distance);
		obj.setSpeed(speed);
		obj.setTravelBreak(travelBreak);
		
		LocalDateTime endDateTime = Container.getDeliveryDateTime(obj);
		
		System.out.println(endDateTime);
		
		scan.close();
	}
}

class Container {
	 static LocalDateTime getDeliveryDateTime(ConsignmentTrack obj) { 
		LocalTime breakTime = LocalTime.parse(obj.getTravelBreak());
		String str = obj.getStartDate()+" "+obj.getStartTime(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime endDateTime = LocalDateTime.parse(str, formatter);
		
		int totalTime = obj.calculateTotalTime(obj.getDist(), obj.getSpeed(), breakTime);
		endDateTime = obj.calculateBusinessDays(totalTime, endDateTime);
		endDateTime = obj.addTimeToBusinessDays(totalTime, endDateTime);
		return endDateTime;
	}
}    