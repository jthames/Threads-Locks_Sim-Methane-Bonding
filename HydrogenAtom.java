/*
 * Joshua Thames
 * 
 * CLASS: HydrogenAtom
 * 
 * FUNCTION: This Class represents a single carbon atom that is created by the CarbonAtomGenerator and increases
 * 			 the amount of carbon semaphore permits available to ChemicalBondingCreator.
 * 			 This class ends its run function when ChemicalBondingCreator sets each instance of the object's 
 * 			 alive attribute to false.
 * 			 
 */

public class HydrogenAtom implements Runnable {

	private ChemicalBondingCreator cbc;
	public int count;
	public boolean alive;

	public HydrogenAtom(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
		this.alive = true;
	}

	@Override
	public void run() {
		
		// Add a Hydrogen atom to haList
		System.out.println("H+ # " + count + " created and waiting for bonding");
	
		// Add this hydrogen atom to the list!
		cbc.ha.add(this);
		
		// This increases the total number of Hydrogen atom permits available in the hSem semaphore
		cbc.hSem.release();
		
		// Keep this tread running until it is acquired
		while(alive)
			;

	}// end run
}// end HydrgoAtom
