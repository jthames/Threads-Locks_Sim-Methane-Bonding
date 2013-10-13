/*
 * USING JAVA VERSION 1.7.0_17
 * 
 * Joshua Thames
 * 
 * CLASS: 		MethaneMolecule
 * 
 * FUNCTION: 	This class represents the creation of a single methane molecule and holds the atoms 
 * 				have been "bound" as attributes.
 */
public class MethaneMolecule implements Runnable{

	private ChemicalBondingCreator cbc;
	public int count;
	public boolean alive;
	CarbonAtom carbonAtom;
	HydrogenAtom[] hydroAtoms;

	public MethaneMolecule(ChemicalBondingCreator cbc, int count) {
		this.cbc = cbc;
		this.count = count;
		this.alive = true;
		hydroAtoms = new HydrogenAtom[4];
	}
	
	public void setHydro(HydrogenAtom h, int ix){	
		this.hydroAtoms[ix] = h;
	}
	
	@Override
	public void run() {
		
		// Add a Methane to the mm list
		System.out.println("CH4 # " + count + " created.");
				
		// Add this Methane molecule to the list!
		cbc.mm.add(this);
	}
}

