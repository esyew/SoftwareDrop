//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work
package car;
import java.util.Scanner;

public class Race {

	private static Tire[] tires;
	private static Engine carEngine;
	private static Car car;
	private static Boolean carStarted;
	private static int speed;

	public static void main(String[] args) {
		tires = new Tire[4];
		carEngine = new Engine();
		System.out.println("Enter the PSI of your tires");
		Scanner myObj = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.print("Tire " + (i + 1) + ": ");
			int tirePSI = myObj.nextInt();
			tires[i] = new Tire(tirePSI);
		}
		car = new Car(tires, carEngine);
		//Ask user to start engine
		System.out.println("Run the engine? (true/false)");
		if (myObj.nextBoolean()) {
			carEngine.StartEngine(tires);
		} else {
			carEngine.setRunning(false);
		}
		System.out.println("Run the car? (true/false)");
		if (myObj.nextBoolean()) {
			carStarted = car.StartCar();
			while (car.isRunning()) {
				System.out.println("Set speed 1-60, 0 to stop the car");
				speed = myObj.nextInt();
				if (speed > 0) {
					car.setSpeed(speed);
				} else {
					car.StopCar();
					System.out.println("Restart the car? true/false");
					if (myObj.nextBoolean()) {
						car.RestartCar();
					} else {
						System.out.println("Car stopped for good");
						break;
					}
				}
			}
			
		} else {
			carEngine.setRunning(false);
			
		}
		
		//The following code does the same thing as the above, without user interaction.
		/*

		//Create tire array
		
		//Would be good to ask user this...
		
		int[] carTirePressures = {32, 65, 38, 45};
		tires = new Tire[carTirePressures.length];
		
		for (int i = 0; i < carTirePressures.length; i++) {
		
			tires[i] = new Tire(carTirePressures[i]);
		}
		
		
		
		
		//This part is not used, and is already part of Car, but can independently toggle engine, without affecting car
		//Create Engine
		carEngine = new Engine();
		
		//Start engine
		carEngine.StartEngine(tires);
		
		//Stop Engine
		carEngine.setRunning(false);
		
		
		
		
//Needed parts
		
		//Create Car
		car = new Car(tires, carEngine);
		
		
		//Start the car
		carStarted = car.StartCar();
		
		//Set speed
		//Ask user for speed
		car.setSpeed(45);
		
		
		
		//Restart Car
		car.RestartCar();
		
		//Stop Car
		car.StopCar();
		
		*/
	}




}
