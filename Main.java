/*
 * USING JAVA VERSION 1.7.0_17 
 * 
 * Joshua Thames
 * 
 * CLASS: 	Main
 * 
 * PURPOSE: The purpose of this program is to simulate the creation of Methane (CH4) using a process synchronization 
 * 			technique called sempahores. To do so, the HydrogenAtomGenerator thread creates a new hydrogen atom every second
 * 			while the CarbonAtomGenerator thread creates a new carbon atom every 3 seconds. The two previous threads have also 
 * 			implemented a counting semaphore called cSem and hSem to keep track of the total available carbon and hydrogen atoms 
 * 			threads that have been created and that are available for bonding by the ChemicalBondingCreator which continually checks
 * 			to see if there are enough atoms to create the CH4 by calling acquire the appropriate amount of times. 
 * 
 * 			The process as a whole does mimic how CH4 is naturally created by acquiring one molecule at a time and "bonding" it 
 * 			and never releasing it back to the semaphore pool. Bonding naturally takes place over some delta t, not instantaneously. 
 *
 * NOTE:    This program does not terminate but runs indefinitely.
 */


public class Main {
	
	public static final void main(String args[]) {
		System.out.println("Project 2");
		
		// Create the bonding class
		ChemicalBondingCreator cbc = new ChemicalBondingCreator();
		Thread thread = new Thread(cbc);
		thread.start();
		
		// Create the hydrogen atom generator
		HydrogenAtomGenerator hag = new HydrogenAtomGenerator(cbc);
		thread = new Thread(hag);
		thread.start();
		
		// Create the Carbon atom generator
		CarbonAtomGenerator cag = new CarbonAtomGenerator(cbc);
		thread = new Thread(cag);
		thread.start();
		
	}// end main()
	
}// end Main class
