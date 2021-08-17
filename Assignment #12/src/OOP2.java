import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Iterator;

public class OOP2 {
	public static void main(String[] args) throws FileNotFoundException {
		String target="GO"; // flag to control the input loop
		Scanner in = new Scanner(System.in);
		int answer= 0;
		HashMap<String,State> states = new HashMap<>(); // Abbreviations are keys and State objects are values
		ArrayList<DailyData> outputList = new ArrayList<>(); // Holds all the data resulting from a search on a date
		// Create a State instance for every abbreviation.
		// Add them all to the states ArrayList
		buildStateList(states);	
		answer = JOptionPane.showConfirmDialog(null,State.getNStates() + " state/territory objects were created. OK to continue?","Progress Report",JOptionPane.YES_NO_OPTION);
		if(answer ==0){
		// Populate the state objects with data from file.
		fillStateList(states);
		// Loop to ask the user to enter a date.
		while (! target.toUpperCase().equals("STOP")) { 
			System.out.print("\nDate (YYYY-MM-DD): ");
			target = in.nextLine();
			outputList = getDataOnDate(target,states);
			if (! target.toUpperCase().equals("STOP")) {
				if (outputList.size() > 0) {
					System.out.println(listToString(outputList));	
				}
				else {
					JOptionPane.showMessageDialog(null,target + " is not a valid date or is out of range.","Input Error",JOptionPane.ERROR_MESSAGE);
					//System.out.println(target + " is not a valid date or is out of range.");
				}
			}
		}
		in.close();
		}
		System.out.println("Done.");	
	}

	public static void buildStateList(HashMap<String, State> states) {
		Iterator<String> stateabbr = State.getAllAbbrs().iterator();
		for(int i = 0; i < State.getAllAbbrs().size(); i++){
			switch(stateabbr.next()){
				case "AL":
					states.put("AL", new State("Alabama"));
					continue;
				case "HI":
					states.put("HI", new State("Hawaii"));
					continue;
				case "OR":
					states.put("OR", new State("Oregon"));
					continue;
				case "CA":
					states.put("CA", new State("California"));
					continue;
				case "WA":
					states.put("WA", new State("Washington"));
					continue;
				case "AK":
					states.put("AK", new State("Alaska"));
					continue;
				case "AZ":
					states.put("AZ", new State("Arizona"));
					continue;
				case "AR":
					states.put("AR", new State("Arkansas"));
					continue;
				case "CO":
					states.put("CO", new State("Colorado"));
					continue;
				case "CT":
					states.put("CT", new State("Connecticut"));
					continue;
				case "DE":
					states.put("DE", new State("Delaware"));
					continue;
				case "FL":
					states.put("FL", new State("Florida"));
					continue;
				case "GA":
					states.put("GA", new State("Georiga"));
					continue;
				case "ID":
					states.put("ID", new State("Idaho"));
					continue;
				case "IL":
					states.put("IL", new State("Illinois"));
					continue;
				case "IN":
					states.put("IN", new State("Indiana"));
					continue;
				case "IA":
					states.put("IA", new State("Iowa"));
					continue;
				case "KS":
					states.put("KS", new State("Kansas"));
					continue;
				case "KY":
					states.put("KY", new State("Kntucky"));
					continue;
				case "LA":
					states.put("LA", new State("Louisiana"));
					continue;
				case "ME":
					states.put("ME", new State("Maine"));
					continue;
				case "MD":
					states.put("MD", new State("Maryland"));
					continue;
				case "MA":
					states.put("MA", new State("Massachusets"));
					continue;
				case "MI":
					states.put("MI", new State("Michigian"));
					continue;
				case "MN":
					states.put("MN", new State("Minnesota"));
					continue;
				case "MS":
					states.put("MS", new State("Mississippi"));
					continue;
				case "MO":
					states.put("MO", new State("Missouri"));
					continue;
				case "MT":
					states.put("MT", new State("Montana"));
					continue;
				case "NE":
					states.put("NE", new State("Nebraska"));
					continue;
				case "NV":
					states.put("NV", new State("Nevada"));
					continue;
				case "NH":
					states.put("NH", new State("New Hampshire"));
					continue;
				case "NJ":
					states.put("NJ", new State("New Jersy"));
					continue;
				case "NM":
					states.put("NM", new State("New Mexico"));
					continue;
				case "NY":
					states.put("NY", new State("New York"));
					continue;
				case "NC":
					states.put("NC", new State("North Carolina"));
					continue;
				case "ND":
					states.put("ND", new State("North Dakota"));
					continue;
				case "OH":
					states.put("OH", new State("Ohio"));
					continue;
				case "OK":
					states.put("OK", new State("Oklahoma"));
					continue;
				case "PA":
					states.put("PA", new State("Pennsylvania"));
					continue;
				case "RI":
					states.put("RI", new State("Rhode Island"));
					continue;
				case "SC":
					states.put("SC", new State("South Carolina"));
					continue;
				case "SD":
					states.put("SD", new State("South Dakota"));
					continue;
				case "TN":
					states.put("TN", new State("Tennese"));
					continue;
				case "TX":
					states.put("TX", new State("Texas"));
					continue;
				case "UT":
					states.put("UT", new State("Utah"));
					continue;
				case "VT":
					states.put("VT", new State("Vermont"));
					continue;
				case "VA":
					states.put("VA", new State("Virgina"));
					continue;
				case "WV":
					states.put("WV", new State("West Virginia"));
					continue;
				case "WI":
					states.put("WI", new State("Wisconsin"));
					continue;
				case "WY":
					states.put("WY", new State("Wyoming"));
					continue;
				case "AS":
					states.put("AS", new State("American Samoa"));
					continue;
				case "GU":
					states.put("GU", new State("Guam"));
					continue;
				case "MP":
					states.put("MP", new State("Northern Marian"));
					continue;
				case "PR":
					states.put("PR", new State("Puerto Rico"));
					continue;
				case "VI":
					states.put("VI", new State("U.S. Virgin Islands"));
					continue;
				case "DC":
					states.put("DC", new State("District of Columbia"));
					continue;
			}
		}
	}

	public static void fillStateList(HashMap<String, State> states) throws FileNotFoundException {
		String row;
        Scanner scanFile = new Scanner(new File("all-states-history.csv")).useDelimiter(",");
        row = scanFile.nextLine();
		while(scanFile.hasNext()){
            row = scanFile.nextLine();
            String[] arrOfStr = row.split(",", 0);
			int cases = Integer.parseInt(arrOfStr[21]);
			int deaths = Integer.parseInt(arrOfStr[4]);
            states.get(arrOfStr[1]).addData(arrOfStr[0],cases,deaths);
        }
	}
	
	public static ArrayList<DailyData> getDataOnDate(String target, HashMap<String, State> states) {
		ArrayList<DailyData> DD = new ArrayList<>();
		Iterator<String> stateabbr = State.getAllAbbrs().iterator();
		ArrayList<String> stateAbbr = new ArrayList<>();
		for(int i = 0; i< State.getAllAbbrs().size(); i++){
			stateAbbr.add(stateabbr.next());
		}
		for (int i = 0; i < states.size(); i++) {
			inner: for (int q = 0; q < states.get(stateAbbr.get(i)).getData().size(); q++) {
				if(states.get(stateAbbr.get(i)).getData().get(q).getDate().equals(target)){
					DD.add(states.get(stateAbbr.get(i)).getData().get(q));
					break inner;
				}
			}
		}
		return DD;
	}

	public static String listToString (ArrayList<DailyData> dailyData){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-25s%-15s%-15s\n", "State","Cases","Deaths"));
		for (DailyData dd : dailyData) {
		  sb.append(dd.toString());
		}
		return sb.toString();
	  }
}