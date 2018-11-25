package data;

public interface Constants {
	
	
	public final int add			= 0x1;	// sequential 
	public final int edit			= 0x2;	//
	public final int update			= 0x3;	//
	
	public final int numActions		= 0x5;	//make bigger than last action

	public final int doc			= 23;	// 23 is prime
	public final int person			= 59;	// 59 is prime
	
	public final int addDoc			= (doc * numActions) + add;
	public final int editDoc		= (doc * numActions) + edit;
	public final int updateDoc		= (doc * numActions) + update;
	
	public final int addPerson		= (person * numActions) + add;
	public final int editPerson		= (person * numActions) + edit;
	public final int updatePerson	= (person * numActions) + update;
	
	// since person and doc are primes you can determine the type and action, knowing neither
}
