//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work
package car;


public class Engine {
	private boolean isRunning;
	private boolean goodTires;
	/**
	 * Checks all the tires to make sure the engine can start. ig
	 * @param tires
	 * @return did the engine start
	 */
	public boolean StartEngine(Tire [] tires){
		if (tires.length != 4) {
			isRunning = false;
			System.out.println("Error: Are you missing a tire?");
			goodTires = false;
			return false;
			
			
		}
		for (int i = 0; i < tires.length; i++) {
			if (tires[i].getPsi() >= 32) {
				
			} else {
				System.out.println("Error: Low tire Pressure on tire: " + (i + 1));
				isRunning = false;
				goodTires = false;
				return false;
				
			}
		}
		System.out.println("Engine started");
		goodTires = true;
		isRunning = true;
		return true;
		
		
	}
	/**
	 * Create a Engine 
	 */
	public Engine() {
		
	}
	/**
	 * 
	 * @return is the engine running? T/F
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * 
	 * @param isRunning (start or stop the engine) True for Start
	 */
	public void setRunning(boolean isRunning) {
		if (isRunning && goodTires) {
			this.isRunning = true;
		}
		
		this.isRunning = false;
		System.out.println("Engine Stopped");
	}
	/**
	 * Are the tires okay? allows the engine to start
	 * @return tires Status
	 */
	public boolean isGoodTires() {
		return goodTires;
	}



	
	
}
