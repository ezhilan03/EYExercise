package InternExercise.assignment.consignmentTrack;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsignmentTrackerDemo {
	public static void main(String[] args) {
		ConsignmentTrack obj = new ConsignmentTrack(LocalDateTime.now(),35000,100,new BreakInterval(48, 0, 0));
		System.out.println(obj.getDeliveryDateAndTime());
	}
}
