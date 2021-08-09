package parcel;
/**
 * 
 * @author Vinoth
 * 
 */
import java.time.LocalDate;
import java.util.Scanner;

import track.date.TrackWithDate;
import track.distance.TrackWithDistance;

public class TrackParcel {
	//Scanner object is created to scan user input at the console
	Scanner scan=new Scanner(System.in);
	
	private static LocalDate date;//LocalDate object is declared
	private static double workTime, timeTaken;//workTime and tikeTaken is declared
	public static void main(String[] args) {
		/*
		 * main method to display the delivery date of the parcel
		 * With the help of classes in the package called track
		 * 
		 * Sub-package of track package called distance contains the class called TrackWithDistance
		 * is used to find the time taken by the parcel service to deliver the parcel
		 * 
		 * Sub-package of track package called date contains the class called TrackWithDate
		 * is used to find the traveling days, with which the delivery date is calculate using the method
		 * deliveryDate in TrackWithDate class
		 */
		TrackWithDate trackDate;
		TrackWithDistance trackDist=new TrackWithDistance();
		TrackParcel track=new TrackParcel();
		try {
			//TrackWithDate object is created with the date provided in the command line
			trackDate=new TrackWithDate(LocalDate.parse(args[0]));
		}catch(IndexOutOfBoundsException ex) {
			//TrackWithDate object is created with the current date
			trackDate=new TrackWithDate();
		}
		
		//timeTaken is calculated using the method calc with parameter of object TrackWithDistance 
		timeTaken=track.calc(trackDist);
		
		//date is calculated using the method calc with parameter of object TrackWithDate
		date=track.calc(trackDate);
		
		System.out.println("Delivery Date: "+date);//Display the expected delivery date
	}
	
	public LocalDate calc(TrackWithDate trackDate) {
		
		/*
		 * This method is used to find the expected delivery date of the parcel
		 */
		double travelingDays;
		
		System.out.print("Enter the working time in hours else it will be considered as 12 hrs: ");
		try {
			workTime=Double.parseDouble(scan.nextLine());//To get the user input for the working time
			travelingDays= trackDate.calcDays(timeTaken, workTime);//Traveling days will be calculated with respect to user input working time
		}catch(NumberFormatException ex) {
			travelingDays= trackDate.calcDays(timeTaken);//Traveling days will be calculated with respect to default working time as 12 hr.
		}
		
		//Expected delivery date is calculated using the method deliveryDate of class TrackWithDate
		//and returned to the main method
		return trackDate.deliveryDate(travelingDays);
	}
	
	public double calc(TrackWithDistance trackDist) {
		//Initialize the distance to travel in kilometer from the user
		System.out.print("Enter the distance to travel in kilometer: ");
		double distance=Double.parseDouble(scan.nextLine());
		trackDist.setDistance(distance);//Set the distance variable of class TrackWithDistance
		
		while(true) {
			//Initialize the speed of the parcel moving per hour form user
			System.out.print("Enter moving speed of the parcel per hour: ");
			double speed=Double.parseDouble(scan.nextLine());
			trackDist.setSpeed(speed);//Set the speed variable of class TrackWithDistance
			if(speed==0)
				System.out.println("Speed shouldn't be zero");
			else if(speed!=0)
				break;
		}
		
		//Return time taken by the parcel service to reach the destination
		//Using the method getTimeTaken() TrackWithDistance
		return trackDist.getTimeTaken();
	}
}
