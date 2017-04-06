package studio8;
import java.util.*;
import lab8.*;

/** Solution authored by:
 * 
 *  ( team members' names )
 *
 */

public class TeamSymtab extends Symtab implements SymtabInterface {
	
	/** Should never return a negative integer 
	 */
	
	public class Symbol extends TestInfo{
		public String name;
		public SymInfo ti;
		public int scope;
	}
	public class HashKey{
		public String name;
		public int scopeLevel;
		
		@Override
		public int hashCode() {
			return name.hashCode() + scopeLevel * 1337;
		}
		@Override 
		public boolean equals(Object o){
			return o.hashCode() == this.hashCode();
		}
	}
	
	public Hashtable<HashKey, SymInfo> symbolTable = new Hashtable<HashKey, SymInfo>();
	public static Integer currentNestLevel = 0;

	
	public int getCurrentNestLevel() {
		return currentNestLevel;
	}
	
	/** Opens a new scope, retaining outer ones */
	
	public void incrNestLevel() {
		currentNestLevel++;

	}
	
	/** Closes the innermost scope */
	
	public void decrNestLevel() {
		currentNestLevel--;
		Enumeration<HashKey> a = symbolTable.keys();
		
		while(a.hasMoreElements()){
		   HashKey b = a.nextElement();
		   if(b.scopeLevel == currentNestLevel+1){
			   symbolTable.remove(b);
		   }
		}
		

	}
	
	/** Enter the given symbol information into the symbol table.  If the given
	 *    symbol is already present at the current nest level, do whatever is most
	 *    efficient, but do NOT throw any exceptions from this method.
	 */
	public HashKey hk;
	public void enter(String s, SymInfo info) {
		HashKey hk = new HashKey();
		hk.name = s;
		hk.scopeLevel = currentNestLevel;
		this.hk = hk;
		if(info != null)
			symbolTable.put(hk, info);
	}
	
	/** Returns the information associated with the innermost currently valid
	 *     declaration of the given symbol.  If there is no such valid declaration,
	 *     return null.  Do NOT throw any excpetions from this method.
	 */
	
	public SymInfo lookup(String s) {
		HashKey hk = new HashKey();
		hk.scopeLevel = currentNestLevel;
		hk.name = s;

		for(int i = currentNestLevel; i >= 0; i--){
			hk.scopeLevel = i;
			SymInfo si = symbolTable.get(hk);
			if(si != null) return si;
		}
		return null;
	}

}
