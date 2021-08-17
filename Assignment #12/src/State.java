import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class State  {
    private static int nStates = 0;

    private static HashMap<String, String> stateNames = new HashMap<>();

    private String abbr;
    
    private ArrayList<DailyData> dailyData = new ArrayList<>();

    
    public State(String s){
        abbr = s;

        nStates++;
    }

    public static int getNStates(){
        return nStates;
    }

    public static Set<String> getAllAbbrs(){
        buildStatesMap(stateNames);
        return stateNames.keySet();
    }

    public String getAbbr(){
        return abbr;
    }

    public void addData(String date, int cases, int deaths){
        dailyData.add(new DailyData(date, getAbbr(), cases, deaths));
    }

    public ArrayList<DailyData> getData(){
        return dailyData;
        
    }

    private static void buildStatesMap(HashMap<String, String> states){
        String[] stateAbbr = {
            "AK","AL","AR","AS","AZ","CA","CO","CT","DC","DE",
            "FL","GA","GU","HI","IA","ID","IL","IN","KS","KY",
            "LA","MA","MD","ME","MI","MN","MO","MP","MS","MT",
            "NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK",
            "OR","PA","PR","RI","SC","SD","TN","TX","UT","VA",
            "VI","VT","WA","WI","WV","WY"
            };
        for(int i = 0; i < stateAbbr.length; i++){
			switch(stateAbbr[i]){
				case "AL":
					states.put("AL","Alabama");
                    continue;
				case "HI":
					states.put("HI", "Hawaii");
                    continue;
				case "OR":
					states.put("OR", "Oregon");
                    continue;
				case "CA":
					states.put("CA","California");
                    continue;
				case "WA":
					states.put("WA", "Washington");
                    continue;
				case "AK":
					states.put("AK","Alaska");
                    continue;
				case "AZ":
					states.put("AZ", "Arizona");
                    continue;
				case "AR":
					states.put("AR", "Arkansas");
                    continue;
				case "CO":
					states.put("CO", "Colorado");
                    continue;
				case "CT":
					states.put("CT", "Connecticut");
                    continue;
				case "DE":
					states.put("DE", "Delaware");
                    continue;
				case "FL":
					states.put("FL", "Florida");
                    continue;
				case "GA":
					states.put("GA","Georiga");
                    continue;
				case "ID":
					states.put("ID", "Idaho");
                    continue;
				case "IL":
					states.put("IL", "Illinois");
                    continue;
				case "IN":
					states.put("IN", "Indiana");
                    continue;
				case "IA":
					states.put("IA", "Iowa");
                    continue;
				case "KS":
					states.put("KS", "Kansas");
                    continue;
				case "KY":
					states.put("KY","Kntucky");
                    continue;
				case "LA":
					states.put("LA", "Louisiana");
                    continue;
				case "ME":
					states.put("ME", "Maine");
                    continue;
				case "MD":
					states.put("MD", "Maryland");
                    continue;
				case "MA":
					states.put("MA", "Massachusets");
                    continue;
				case "MI":
					states.put("MI", "Michigian");
                    continue;
				case "MN":
					states.put("MN","Minnesota");
                    continue;
				case "MS":
					states.put("MS", "Mississippi");
                    continue;
				case "MO":
					states.put("MO", "Missouri");
                    continue;
				case "MT":
					states.put("MT","Montana");
                    continue;
				case "NE":
					states.put("NE","Nebraska");
                    continue;
				case "NV":
					states.put("NV", "Nevada");
                    continue;
				case "NH":
					states.put("NH", "New Hampshire");
                    continue;
				case "NJ":
					states.put("NJ", "New Jersy");
                    continue;
				case "NM":
					states.put("NM", "New Mexico");
                    continue;
				case "NY":
					states.put("NY","New York");
                    continue;
				case "NC":
					states.put("NC", "North Carolina");
                    continue;
				case "ND":
					states.put("ND", "North Dakota");
                    continue;
				case "OH":
					states.put("OH", "Ohio");
                    continue;
				case "OK":
					states.put("OK","Oklahoma");
                    continue;
				case "PA":
					states.put("PA","Pennsylvania");
                    continue;
				case "RI":
					states.put("RI", "Rhode Island");
                    continue;
				case "SC":
					states.put("SC", "South Carolina");
                    continue;
				case "SD":
					states.put("SD", "South Dakota");
                    continue;
				case "TN":
					states.put("TN","Tennese");
                    continue;
				case "TX":
					states.put("TX","Texas");
                    continue;
				case "UT":
					states.put("UT", "Utah");
                    continue;
				case "VT":
					states.put("VT", "Vermont");
                    continue;
				case "VA":
					states.put("VA","Virgina");
                    continue;
				case "WV":
					states.put("WV","West Virginia");
                    continue;
				case "WI":
					states.put("WI", "Wisconsin");
                    continue;
				case "WY":
					states.put("WY","Wyoming");
                    continue;
				case "AS":
					states.put("AS","American Samoa");
                    continue;
				case "GU":
					states.put("GU","Guam");
                    continue;
				case "MP":
					states.put("MP", "Northern Marian");
                    continue;
				case "PR":
					states.put("PR","Puerto Rico");
                    continue;
				case "VI":
					states.put("VI", "U.S. Virgin Islands");
                    continue;
				case "DC":
					states.put("DC","District of Columbia");
                    continue;
			}
		}
    }
}