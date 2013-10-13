/*
 * Joshua Thames
 * 
 * CLASS: CarbonAtom
 * 
 * FUNCTION: This Class represents a single carbon atom that is created by the CarbonAtomGenerator and increases
 * 			 the amount of carbon semaphore permits available to ChemicalBondingCreator.
 * 			 This class ends its run function when ChemicalBondingCreator sets each instance of the object's 
 * 			 alive attribute to false. 
 * 			 
 */

public class CarbonAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	public int count;
	public boolean alive;

	public CarbonAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
		this.alive = true;
	}

	@Override
	public void run() {
		
		// Add a Carbon atom to the caList
		System.out.println("C- # " + count + " created and waiting for bonding.");
		
		// Add this carbon atom to the list!
		cbc.ca.add(this);
		
		// This increases the total number of Carbon atom permits available in the cSem semaphore
		cbc.cSem.release();
		
		// Keep this atom's thread running while alive
		while(alive)
			;
	
	}// end run()
}