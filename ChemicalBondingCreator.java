/* 
 * USING JAVA VERSION 1.7.0_17 
 * 
 * Joshua Thames
 * 
 * CLASS: ChemicalBondingCreator
 * 
 * FUNCTION: Continually check if there are 1 carbon and 4 hydrogen atoms available in the semaphore counters 
 * cSem and hSem to "bond" a CH4 Methane molecule. 
 *
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ChemicalBondingCreator implements Runnable {

	int count = 1;
	
	public Semaphore hSem      = new Semaphore(0, true);
	public Semaphore cSem      = new Semaphore(0, true);
	
	public List<CarbonAtom>      ca = new ArrayList<CarbonAtom>();
	public List<HydrogenAtom>    ha = new ArrayList<HydrogenAtom>();
	public List<MethaneMolecule> mm = new ArrayList<MethaneMolecule>();


	@Override
	public void run() {
		while (true) {
			System.out.println("C.B.C.: looking for bonding");
			
			try{
				this.cSem.acquire();
				System.out.println("C.B.C.: Acquired 1 C- waiting for 4 H+");
				this.hSem.acquire();
				System.out.println("C.B.C.: Acquired 1 H+ waiting for 3 more");
				this.hSem.acquire();
				System.out.println("C.B.C.: Acquired 2 H+ waiting for 2 more");
				this.hSem.acquire();
				System.out.println("C.B.C.: Acquired 3 H+ waiting for 1 more");
				this.hSem.acquire();
				System.out.println("C.B.C.: Acquired all Atoms for CH4");
				
				// Create and printout the new Methane Molecule
				MethaneMolecule meth = new MethaneMolecule(this, count++);
				Thread thread = new Thread(meth);
				thread.start();
				
				// Acquired all atoms at this point so remove them from the lists
				// and make them dead.
				CarbonAtom c = ca.get(0);
				c.alive = false;		// This should stop the thread from running
				meth.carbonAtom = c;

				ca.remove(0);
				System.out.println("Carbon atom # " + c.count + " bonded, done.");
				
				for(int i=0; i<4; i++){
					HydrogenAtom h = ha.get(0);
					h.alive = false;	// This should stop the thread from running
					meth.setHydro(ha.remove(0), i);
					
					System.out.println("Hydrogen atom # " + h.count + " bonded, done.");
				}
						
			}catch (InterruptedException e){
				System.out.println("Whoops! - Exception in C.B.C.");
				e.printStackTrace();
			}
		}
	}

}
