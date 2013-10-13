Threads-Locks_Sim-Methane-Bonding
=================================

This program is written in Java and implements Threads and Locks via semaphore pooling. Simulates the bonding of Methane - CH4.

Joshua Thames

PURPOSE: 
	The purpose of this program is to simulate the creation of Methane using a process synchronization technique implementing sempahores. To do so, the HydrogenAtomGenerator threadcreates a new hydrogen atom every second while the CarbonAtomGenerator thread creates a new carbon atom every 3 seconds. The two previous threads have also implemented a counting semaphore called cSem and hSem to keep track of the total available carbon and hydrogen atoms threads that have been created and that are available for bonding by the ChemicalBondingCreator which continually checks to see if there are enough atoms to create the CH4 by calling acquire the appropriate amount of times. 

	The process as a whole does mimic how CH4 is naturally created by acquiring one molecule at a time and "bonding" it and never releasing it back to the semaphore pool. Bonding naturally takes place over some delta t, not instantaneously. 

NOTE:    
	This program does not terminate but runs indefinitely.
