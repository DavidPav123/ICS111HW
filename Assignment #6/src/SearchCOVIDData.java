import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SearchCOVIDData {
    public static void main(String[] args) throws Exception {
         Scanner myobj = new Scanner(System.in); System.out.println("State:"); 
         String State = myobj.nextLine(); 
         State = State.toUpperCase();
         System.out.println("Date (MM/DD/YY):"); 
         String Date = myobj.nextLine();
         String row = findRow(Date, State);
         if(row.equals("Data not found.")){
             System.out.println("Data not found.");
         }
         else{
            int Cases = Integer.parseInt(getColumn(21, row));
            int Deaths = Integer.parseInt(getColumn(4, row));
            System.out.printf("%-15s%-15s%-15s%-15s%n","Date","State","Cases","Deaths");
            System.out.printf("%-15s%-15s%-15s%-15s%n",Date,getStateName(State),String.format("%,d",Cases),String.format("%,d",Deaths));
         }
    }

    public static String findRow(String Date, String State) throws FileNotFoundException {
        String row;
        Scanner scanFile = new Scanner(new File("/src/all-states-history.csv")).useDelimiter(",");
        while(scanFile.hasNext()){
            row = scanFile.nextLine();
            Scanner look = new Scanner(row).useDelimiter(",");
            String date = look.next();
            if(date.equals(Date)){
                date = look.next();
                if(date.equals(State)){
                    return row;
                }
            }
        }
        return "Data not found.";
    }
    public static String getStateName(String State){
        switch(State){
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
        }
        return "State not found";
    }

    public static String getColumn(int Column, String row){
        String data = "";
        Scanner col = new Scanner(row).useDelimiter(",");
        for(int i = 0; i < Column; i++){
            data = col.next();
        }
        return data;
    }
}

