//Erick Grant
//CST 239
//Jan 22 2022
//This is my own work
package car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class tests {

	private Boolean runningEngine;

	@Test
	void TireTestGoodPSI() {
		Tire[] tires;
		Engine engine = new Engine();
		tires = new Tire[4];
		int[] tirePSI = {42, 35, 42, 34};
		for (int i = 0; i < 4; i++) {
			
			
			tires[i] = new Tire(tirePSI[i]);
		}
		
		 runningEngine = engine.StartEngine(tires);
		 assertEquals(true, runningEngine);
		
	}
	@Test
	void TireTestBadPSI() {
		Tire[] tires;
		Engine engine = new Engine();
		tires = new Tire[4];
		int[] tirePSI = {45, 35, 23, 34};
		for (int i = 0; i < 4; i++) {
			
			
			tires[i] = new Tire(tirePSI[i]);
		}
		
		 runningEngine = engine.StartEngine(tires);
		 assertEquals(false, runningEngine);
		
	}

}
