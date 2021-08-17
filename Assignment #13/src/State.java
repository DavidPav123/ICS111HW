import java.util.HashMap;
import java.util.Set;

public class State extends AdministrativeDivision{
    private static int nStates = 0;

    private static HashMap<String, String> stateNames = new HashMap<>();
    
    public State(String s){
        abbr = s;

        nStates++;
    }

    public static int getNStates(){
        return nStates;
    }

    public static Set<String> getAbbrs(){
        buildStateList();
        return stateNames.keySet();
    } 

    public String getName(){
        buildStateList();
        return stateNames.get(getAbbr());
    }

    public String getRegion(){
        if(getAbbr() == "AK" |getAbbr() == "CA"|getAbbr() == "OR"|getAbbr() == "HI"|getAbbr() == "WA"){
            return "Pacific";
        }
        else if(getAbbr() == "ME" |getAbbr() == "VT"|getAbbr() == "NH"|getAbbr() == "MA"|getAbbr() == "CT"| getAbbr() == "RI"){
            return "New England";
        }
        else if(getAbbr() == "NY" |getAbbr() == "PA"|getAbbr() == "NJ"){
            return "Mid-Atlantic";
        }
        else if(getAbbr() == "MI" |getAbbr() == "WI"|getAbbr() == "OH"|getAbbr() == "IN"|getAbbr() == "IL"){
            return "East North Central";
        }
        else if(getAbbr() == "ND" |getAbbr() == "SD"|getAbbr() == "NE"|getAbbr() == "KS"|getAbbr() == "MN"| getAbbr() == "IA"| getAbbr() == "MO"){
            return "West North Central";
        }
        else if(getAbbr() == "DC" |getAbbr() == "DE"|getAbbr() == "MD"|getAbbr() == "VA"|getAbbr() == "WV"| getAbbr() == "NC"| getAbbr() == "SC"| getAbbr() == "GA"| getAbbr() == "FL"){
            return "South Atlantic";
        }
        else if(getAbbr() == "KY" |getAbbr() == "TN"|getAbbr() == "MS"|getAbbr() == "AL"){
            return "East South Centeral";
        }
        else if(getAbbr() == "TX" |getAbbr() == "LA"|getAbbr() == "OK"|getAbbr() == "AR"){
            return "West South Centeral";
        }
        else {
            return "Mountain";
        }

    }

    private static void buildStateList(){
        String[] stateAbbr = {
            "AK","AL","AR","AZ","CA","CO","CT","DE",
            "FL","GA","HI","IA","ID","IL","IN","KS","KY",
            "LA","MA","MD","ME","MI","MN","MO","MS","MT",
            "NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK",
            "OR","PA","RI","SC","SD","TN","TX","UT","VA",
            "VT","WA","WI","WV","WY","DC"
            };
        for(int i = 0; i < stateAbbr.length; i++){
			switch(stateAbbr[i]){
				case "AL":
					stateNames.put("AL","Alabama");
                    continue;
				case "HI":
					stateNames.put("HI", "Hawaii");
                    continue;
				case "OR":
					stateNames.put("OR", "Oregon");
                    continue;
				case "CA":
					stateNames.put("CA","California");
                    continue;
				case "WA":
					stateNames.put("WA", "Washington");
                    continue;
				case "AK":
					stateNames.put("AK","Alaska");
                    continue;
				case "AZ":
					stateNames.put("AZ", "Arizona");
                    continue;
				case "AR":
					stateNames.put("AR", "Arkansas");
                    continue;
				case "CO":
					stateNames.put("CO", "Colorado");
                    continue;
				case "CT":
					stateNames.put("CT", "Connecticut");
                    continue;
				case "DE":
					stateNames.put("DE", "Delaware");
                    continue;
				case "FL":
					stateNames.put("FL", "Florida");
                    continue;
				case "GA":
					stateNames.put("GA","Georiga");
                    continue;
				case "ID":
					stateNames.put("ID", "Idaho");
                    continue;
				case "IL":
					stateNames.put("IL", "Illinois");
                    continue;
				case "IN":
					stateNames.put("IN", "Indiana");
                    continue;
				case "IA":
					stateNames.put("IA", "Iowa");
                    continue;
				case "KS":
					stateNames.put("KS", "Kansas");
                    continue;
				case "KY":
					stateNames.put("KY","Kentucky");
                    continue;
				case "LA":
					stateNames.put("LA", "Louisiana");
                    continue;
				case "ME":
					stateNames.put("ME", "Maine");
                    continue;
				case "MD":
					stateNames.put("MD", "Maryland");
                    continue;
				case "MA":
					stateNames.put("MA", "Massachusets");
                    continue;
				case "MI":
					stateNames.put("MI", "Michigian");
                    continue;
				case "MN":
					stateNames.put("MN","Minnesota");
                    continue;
				case "MS":
					stateNames.put("MS", "Mississippi");
                    continue;
				case "MO":
					stateNames.put("MO", "Missouri");
                    continue;
				case "MT":
					stateNames.put("MT","Montana");
                    continue;
				case "NE":
					stateNames.put("NE","Nebraska");
                    continue;
				case "NV":
					stateNames.put("NV", "Nevada");
                    continue;
				case "NH":
					stateNames.put("NH", "New Hampshire");
                    continue;
				case "NJ":
					stateNames.put("NJ", "New Jersy");
                    continue;
				case "NM":
					stateNames.put("NM", "New Mexico");
                    continue;
				case "NY":
					stateNames.put("NY","New York");
                    continue;
				case "NC":
					stateNames.put("NC", "North Carolina");
                    continue;
				case "ND":
					stateNames.put("ND", "North Dakota");
                    continue;
				case "OH":
					stateNames.put("OH", "Ohio");
                    continue;
				case "OK":
					stateNames.put("OK","Oklahoma");
                    continue;
				case "PA":
					stateNames.put("PA","Pennsylvania");
                    continue;
				case "RI":
					stateNames.put("RI", "Rhode Island");
                    continue;
				case "SC":
					stateNames.put("SC", "South Carolina");
                    continue;
				case "SD":
					stateNames.put("SD", "South Dakota");
                    continue;
				case "TN":
					stateNames.put("TN","Tennese");
                    continue;
				case "TX":
					stateNames.put("TX","Texas");
                    continue;
				case "UT":
					stateNames.put("UT", "Utah");
                    continue;
				case "VT":
					stateNames.put("VT", "Vermont");
                    continue;
				case "VA":
					stateNames.put("VA","Virgina");
                    continue;
				case "WV":
					stateNames.put("WV","West Virginia");
                    continue;
				case "WI":
					stateNames.put("WI", "Wisconsin");
                    continue;
				case "WY":
					stateNames.put("WY","Wyoming");
                    continue;
                case "DC":
                    stateNames.put("DC","District of Columbia");
                    continue;
			}
		}
    }

}
