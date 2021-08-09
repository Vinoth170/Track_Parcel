package track.date;
/**
 * 
 * @author Vinoth
 * 
 */
import java.time.LocalDate;

public class TrackWithDate {
	/*
	 * This class is used to find traveling days
	 * and expected delivery date to reach the destination
	 * using the traveling days
	 */
	
	private LocalDate date;//Declaring LocalDate object
	private double workTime=12;//Declaring and initializing the working time as 12 hours
	
	public TrackWithDate() {
		//If the object is created without date, by default it will be taken as current date
		this.date=LocalDate.now();
	}
	
	public TrackWithDate(LocalDate date) {
		//The date provided will be considered to find the delivery date
		this.date=date;
	}
	
	public LocalDate deliveryDate(double travelingDays) {
		//Using the traveling days the delivery date will be found
		
		travelingDays=Math.ceil(travelingDays);
		for(int i=1;i<travelingDays;i++)
			if(date.getDayOfWeek().toString().equalsIgnoreCase("Sunday"))
				date=date.plusDays(2);
			else
				date=date.plusDays(1);
		
		return date;
	}
	
	public double calcDays(double timeTaken, double workTime) {
		/*
		 * To find the traveling days of a parcel with respect to 
		 * time taken by a parcel to reach the destination
		 * with the user given working time
		 */
		this.workTime=workTime;
		double travelingDays=timeTaken/workTime;
		return travelingDays;
	}
	
	public double calcDays(double timeTaken) {
		/*
		 * To find the traveling days of a parcel with respect to 
		 * time taken by a parcel to reach the destination
		 * with the default working time
		 */
		double travelingDays=timeTaken/workTime;
		return travelingDays;
	}
	
}
