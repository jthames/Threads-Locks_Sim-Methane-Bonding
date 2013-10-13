/* 
 * USING JAVA VERSION 1.7.0_17 
 * 
 * Joshua Thames
 * 
 * CLASS: CarbonAtomGenerator.java
 * 
 * PURPOSE: This class creates a new CarbonAtom thread every 3 seconds
 * 
 */
import java.util.Random;

public class CarbonAtomGenerator implements Runnable {

	private Random random = new Random();
	int count = 1;
	private ChemicalBondingCreator cbc;

	public CarbonAtomGenerator(ChemicalBondingCreator cbc) {
		this.cbc = cbc;
	}

	@Override
	public void run() {
		while (true) {
			
			// Wait 3 seconds to create a new Carbon atom.
			try {
				Thread.sleep((long) (3000.0 * random.nextDouble()));
			} catch (InterruptedException e) {
				System.out.println("Error in CarbonAtomGenerator Atom.");
				e.printStackTrace();
			}
			
			// New instance of a carbon atom thread
			CarbonAtom ca = new CarbonAtom(cbc, count++);
			Thread thread = new Thread(ca);
			thread.start();
		}
	}

}
