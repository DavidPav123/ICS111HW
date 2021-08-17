import java.util.ArrayList;
import java.util.HashMap;

public class OOP3 {
	public static void main(String[] args) {
		HashMap<String,AdministrativeDivision> administrativeDivision = new HashMap<String,AdministrativeDivision>();
	
		// Create the State Objects
		for (String s : State.getAbbrs()) {
			administrativeDivision.put(s,new State(s));
		}
		
		// Create the Territory objects
		for (String s : Territory.getAbbrs()) { 
			administrativeDivision.put(s,new Territory(s));
		}
		
		// Print the number of all instances
		System.out.println(AdministrativeDivision.getNAdminDivs() + " objects were created.");
		System.out.println(State.getNStates() + " state objects (includes D.C.).");
		System.out.println(Territory.getNTerritories() + " territory objects.");

		// Print a formatted list of properties using getters
		for (AdministrativeDivision adminDiv : administrativeDivision.values()) {
			System.out.printf("\n%-5s%-25s%-25s",adminDiv.getAbbr(), adminDiv.getName(), adminDiv.getRegion());
		}
		
	}
}