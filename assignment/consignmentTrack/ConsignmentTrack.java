package EYExercise.assignment.consignmentTrack;
 
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.IntFunction;

interface ConsignmentTracker {
	public int calculateTotalTime(double dist, double speed, LocalTime breakTime);
	public LocalDateTime calculateBusinessDays(int totalTime, LocalDateTime endDateTime);
	public LocalDateTime addTimeToBusinessDays(int totalTime, LocalDateTime endDateTime);
}

public class ConsignmentTrack implements ConsignmentTracker {
	private String startDate;	
	private String startTime;			
	private double distance; 		
	private double speed;	
	private String travelBreak;	
		
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String sDate) {
		this.startDate = sDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setsTime(String startTime) {
		this.startTime = startTime;
	}

	public double getDist() {
		return distance;
	}

	public void setDist(double distance) {
		this.distance = distance;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getTravelBreak() {
		return travelBreak;
	}

	public void setTravelBreak(String travelBreak) {
		this.travelBreak = travelBreak;
	}

	@Override
	public LocalDateTime addTimeToBusinessDays(int totalTime, LocalDateTime endDateTime) {
		endDateTime = endDateTime.plusMinutes(totalTime);
		return endDateTime;
	}
	
	@Override
	public LocalDateTime calculateBusinessDays(int totalTime, LocalDateTime endDateTime) {
		Duration d = Duration.ofMinutes(totalTime);
        long day = d.toDays();
			    
	    IntFunction<TemporalAdjuster> addBusinessDays = days -> TemporalAdjusters.ofDateAdjuster(
        	    date -> {
        	      LocalDate baseDate =
        	          days > 0 ? date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        	              : days < 0 ? date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) : date;
        	      int businessDays = days + Math.min(Math.max(baseDate.until(date).getDays(), -4), 4);
        	      return baseDate.plusWeeks(businessDays / 5).plusDays(businessDays % 5);
        	    });
	    
	    if((endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 1, 1))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 1, 26))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 8, 15))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 10, 2))) {
	    	//endDateTime.withDayOfMonth(1);
	    	day+=1;
	    } 
		    
	    endDateTime = endDateTime.with(addBusinessDays.apply((int)day));
	    return endDateTime;
	}
	
	@Override
	public int calculateTotalTime(double dist, double speed, LocalTime breakTime) {
		int hourSum=0, minSum=0, secs=0;
		double time = (dist/speed)*60; //value in minutes
		int hrs=0, mts=0, sec=0;
		
		if(time > 59) { 
			hrs = (int)(time/60);
			mts = (int)(time%60);
			if(mts > 59) {
				minSum = (int)(mts/60);
				sec = (int)(mts%60);
			}
			if(minSum > 59) {
				mts += (minSum/60);
				sec += (minSum%60);
			}
			hourSum = breakTime.getHour()+hrs;
			minSum = breakTime.getMinute()+mts;
			secs = breakTime.getSecond()+sec;
			System.out.println("time....."+hourSum+":"+minSum+":"+secs);
		} else {
			minSum = breakTime.getMinute()+(int)time;
			if(minSum > 59) {
				mts += (minSum/60);
				sec += (minSum%60);
			}
		}
		return (hourSum*60)+minSum+(secs/60);	
	}
}