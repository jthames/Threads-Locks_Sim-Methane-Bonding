/* 
 * USING JAVA VERSION 1.7.0_17 
 * 
 * Joshua Thames
 * 
 * CLASS: HydrogenAtomGenerator.java
 * 
 * PURPOSE: This class creates a new HydrogenAtom thread every second.
 * 
 */


import java.util.Random;

public class HydrogenAtomGenerator implements Runnable {

	private Random random = new Random();
	int count = 1;
	private ChemicalBondingCreator cbc;

	public HydrogenAtomGenerator(ChemicalBondingCreator cbc) {
		this.cbc = cbc;
	}

	@Override
	public void run() {
		while (true) {
			
			// Wait 1 second to create a new Hydrogen atom
			try {
				Thread.sleep((long) (1000.0 * random.nextDouble()));
			} catch (InterruptedException e) {
				System.out.println("Error in Hydrogen Atom.");
				e.printStackTrace();
			}
			
			// Create a new instance of a Hydrogen atom thread
			HydrogenAtom ha = new HydrogenAtom(cbc, count++);
			Thread thread = new Thread(ha);
			thread.start();
		}
	}
}
