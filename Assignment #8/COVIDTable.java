import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class COVIDTable {
    public static void main(String[] args) throws Exception {
     String[][] table = new String[56][4];
     String date = getDate();
     getData(date,table);
     printTable(table);
    }

    public static String getDate(){
        Scanner myobj = new Scanner(System.in); 
        System.out.print("Enter a date (YYYY-MM-DD): "); 
        String Date = myobj.nextLine();
        myobj.close();
        return Date;
    }

    public static void getData(String Date, String[][] table) throws FileNotFoundException{
        String row;
        int tableRow = 0;
        Scanner scanFile = new Scanner(new File("/Users/davidpavlicek/Desktop/ICS 111 /Assignment #8/all-states-history-new.csv")).useDelimiter(",");
        while(scanFile.hasNext()){
            row = scanFile.nextLine();
            Scanner look = new Scanner(row).useDelimiter(",");
            String date = look.next();
            if(date.equals(Date)){
                for(int j = 0; j < 4; j++){
                    if(j == 0){
                        table[tableRow][0] = getColumn(2,row);
                    }
        
                    else if(j == 1){
                        table[tableRow][1] = getColumn(22,row);
                    }
        
                    else if(j == 2){
                        table[tableRow][2] = getColumn(10,row);
                    }
        
                    else{
                            table[tableRow][3] = getColumn(5,row);
                    }
                }
                tableRow = tableRow +1;
            }
            look.close();
        }

    }

    public static void printTable(String[][] table){
        System.out.printf("%-22s%-15s%-15s%-15s%n","State","Cases","Hosp","Deaths");
        for(int i=0; i < 56; i++){
            System.out.printf("%-22s%-15s%-15s%-15s%n",getStateName(table[i][0]),table[i][1],table[i][2],table[i][3]);
        }
    }

    public static String getColumn(int Column, String row){
        String data = "";
        Scanner col = new Scanner(row).useDelimiter(",");
        for(int i = 0; i < Column; i++){
            data = col.next();
        }
        col.close();
        return data;
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
}
