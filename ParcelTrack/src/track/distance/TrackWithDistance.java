package track.distance;
/**
 * 
 * @author Vinoth
 *
 */
public class TrackWithDistance {
	/*
	 *This class is used to set the distance to travel in kilometer
	 *and speed of the parcel moving per hour
	 */
	private double timeTaken,distance,speed;
	public void setDistance(double distance) {
		//Set distance in Kilometer
		this.distance=distance;
	}
	
	public void setSpeed(double speed) {
		//Set speed per hour
		this.speed=speed;
	}
	
	public double getTimeTaken() {
		//To find time taken to travel the distance with respect to speed of moving
		timeTaken=distance/speed;
		return timeTaken;
	}
	
	protected double getDistance() {
		//We can get the distance to travel for the subclass of TrackWithDistance class
		return distance;
	}
	
	protected double getSpeed() {
		//We can get the speed to travel for the subclass of TrackWithDistance class
		return speed;
	}
}
