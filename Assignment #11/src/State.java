import java.util.ArrayList;

public class State  {
    private static int nStates = 0;

    private String abbr;

    private ArrayList<String> weekData = new ArrayList<>();

    public State(String s){
        abbr = s;
        nStates = nStates + 1;
    }

    public static int getNStates(){
        return nStates;
    }

    public String getAbbr(){
        return abbr;
    }

    public String getName(){
        switch(abbr){
            case "AL":
                return "Alabama";
            case "HI":
                return "Hawaii";
            case "OR":
                return "Oregon";
            case "CA":
                return "California";
            case "WA":
                return "Washington";
            case "AK":
                return "Alaska";
            case "AZ":
                return "Arizona";
            case "AR":
                return "Arkansas";
            case "CO":
                return "Colorado";
            case "CT":
                return "Connecticut";
            case "DE":
                return "Delaware";
            case "FL":
                return "Florida";
            case "GA":
                return "Georgia";
            case "ID":
                return "Idaho";
            case "IL":
                return "Illinois";
            case "IN":
                return "Indiana";
            case "IA":
                return "Iowa";
            case "KS":
                return "Kansas";
            case "KY":
                return "Kentucky";
            case "LA":
                return "Louisiana";
            case "ME":
                return "Maine";
            case "MD":
                return "Maryland";
            case "MA":
                return "Massachusetts";
            case "MI":
                return "Michigan";
            case "MN":
                return "Minnesota";
            case "MS":
                return "Mississippi";
            case "MO":
                return "Missouri";
            case "MT":
                return "Montana";
            case "NE":
                return "Nebraska";
            case "NV":
                return "Nevada";
            case "NH":
                return "New Hampshire";
            case "NJ":
                return "New Jersey";
            case "NM":
                return "New Mexico";
            case "NY":
                return "New York";
            case "NC":
                return "North Carolina";
            case "ND":
                return "North Dakota";
            case "OH":
                return "Ohio";
            case "OK":
                return "Oklahoma";
            case "PA":
                return "Pennsylvania";
            case "RI":
                return "Rhode Island";
            case "SC":
                return "South Carolina";
            case "SD":
                return "South Dakota";
            case "TN":
                return "Tennessee";
            case "TX":
                return "Texas";
            case "UT":
                return "Utah";
            case "VT":
                return "Vermont";
            case "VA":
                return "Virgina";
            case "WV":
                return "West Virgina";
            case "WI":
                return "Wisconsin";
            case "WY":
                return "Wyoming";
            case "AS":
                return "American Samoa";
            case "GU":
                return "Guam";
            case "MP":
                return "Northern Mariana";
            case "PR":
                return "Puerto Rico";
            case "VI":
                return "U.S. Virgin Islands";
            case "DC":
                return "District of Columbia";
        }
        return "State not found";
    }

    public void addData(String d){
        weekData.add(d);
    }

    public ArrayList<String> getData(){
        return weekData;
    }
 
    public String toString(){
        return getName() + " has " + weekData.size() + " data entries";
    }
}