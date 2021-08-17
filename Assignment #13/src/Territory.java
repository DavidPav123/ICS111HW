import java.util.HashMap;
import java.util.Set;

public class Territory extends AdministrativeDivision{
    private static int nTerritories = 0;

    private static HashMap<String, String> territoryNames = new HashMap<String,String>();
    
    public Territory(String s){
        abbr = s;

        nTerritories++;
    }
    
    public static int getNTerritories() {
        return nTerritories;
    }

    public static Set<String> getAbbrs(){
        buildTerritoryList();
        return territoryNames.keySet();
    }

    public String getName(){
        buildTerritoryList();
        return territoryNames.get(getAbbr());
    }

    public String getRegion(){
        return "Territory";
    }

    private static void buildTerritoryList(){
        String[] terriAbbr = {
            "AS", "GU", "MP", "PR", "VI" 
            };
            for(int i = 0; i < terriAbbr.length; i++){
                switch(terriAbbr[i]){
                    case "AS":
					    territoryNames.put("AS","American Samoa");
                        continue;
				    case "GU":
					    territoryNames.put("GU","Guam");
                        continue;
				    case "MP":
					    territoryNames.put("MP", "Northern Marian");
                        continue;
				    case "PR":
					    territoryNames.put("PR","Puerto Rico");
                        continue;
				    case "VI":
					    territoryNames.put("VI", "U.S. Virgin Islands");
                        continue;
                }
            }
    }
}
