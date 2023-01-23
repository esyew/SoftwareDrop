//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work
package car;

public class Car {


	

private int speed;
private boolean isRunning;


private Tire[] tires;
private Engine engine;
private boolean goodEngine;
private boolean runningEngine;


/**
 * 
 * 
 * @param tires[]
 * @param engine
 * @return void
 */
public Car(Tire [] tires, Engine engine) {
	this.tires = tires;
	this.engine = engine;
}


/**
 * 
 * @return true/false of whether car was able to start
 */
public boolean StartCar() {
	//Start the engine
	runningEngine = engine.StartEngine(tires);
	isRunning = runningEngine;
	goodEngine = runningEngine;
	if (runningEngine) {
		System.out.println("Car running");
	}
	return runningEngine;
}
/**
 * @param None, car will always stop
 * 
 * 
 */
public void StopCar() {
	speed = 0;
	//engine.setRunning(false);
	//isRunning = false;
	System.out.println("Car stopped");
}

/**
 * @param None
 * @return true/false of whether the car was able to start. 
 */
public boolean RestartCar() {
	StopCar();
	return StartCar();
}


/**
 * 
 * @return int speed for car
 */

public int getSpeed() {
	return speed;
}

/**
 * 
 * @param speed to set car to between 1-60 MPH.
 */
public void setSpeed(int speed) {
	if ((runningEngine) && (speed >= 1) && (speed <= 60)) {
		this.speed = speed;
		System.out.println("Car now going: " + speed);
		
	}else if (speed > 60) {
		System.out.println("Slow down!");
	} else {
		StopCar();
		this.speed = 0;
	}
	
	
	
}

/**
 * 
 * @return is car running true/false
 */


public boolean isRunning() {
	return isRunning;
}



/**
 * 
 * @return the Tire class for all four tires
 */

public Tire[] getTires() {
	return tires;
}
/**
 * 
 * @param tires, set the tires for the Car Class.
 */

public void setTires(Tire[] tires) {
	this.tires = tires;
}
/**
 * 
 * @return was the engine able to start, also ensures the tires are okay.
 */
public boolean isGoodEngine() {
	return goodEngine;
}

}
