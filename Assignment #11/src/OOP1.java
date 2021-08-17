import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OOP1  {
    public static void main(String[] args) throws FileNotFoundException {
        String[] stateCodes = {
            "AK","AL","AR","AS","AZ","CA","CO","CT","DC","DE",
            "FL","GA","GU","HI","IA","ID","IL","IN","KS","KY",
            "LA","MA","MD","ME","MI","MN","MO","MP","MS","MT",
            "NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK",
            "OR","PA","PR","RI","SC","SD","TN","TX","UT","VA",
            "VI","VT","WA","WI","WV","WY"
            };
            String target;
            Scanner in = new Scanner(System.in);
            ArrayList<State> states = new ArrayList<>();
            // Create a State instance for every abbreviation.
            // aAdd them all to the states ArrayList
            buildStateList(stateCodes,states);
            System.out.println(State.getNStates() + " state/territory objects were created.");
            // Populate the data elements for every State object
            // by reading from the all-states-history.csv data file
            fillStateList(states);
            // Nicely print the number of data entries for each state
            for (String code : stateCodes) {
            System.out.println(getState(code,states));
            }
            // Loop to ask the user to enter state abbreviations.
            // Returns a table of all data for the state.
            // Throws NullPointerException if no data or unrecognized abbreviation.
            // Extra credit for handling the NullPointerException.
            do {
            System.out.print("\nState Abbreviation: ");
            target = in.nextLine();
            try{
            printTable(getState(target,states).getData());
            }
            catch(NullPointerException e ){
                if(target.equals("STOP")){
                    System.out.println("");
                }
                else{
                    System.out.println("State not recognised");
                }
            }
            } while (! target.equals("STOP"));
            in.close();
     }

    public static void buildStateList(String[] stateCodes, ArrayList<State> states){
        for(int i = 0; i < stateCodes.length; i++){
            states.add(new State(stateCodes[i]));
        }
    }

    public static void fillStateList(ArrayList<State> states) throws FileNotFoundException{
        String row;
        Scanner scanFile = new Scanner(new File("/Users/davidpavlicek/Desktop/ICS 111 /Assignment #11/src/all-states-history.csv")).useDelimiter(",");
        while(scanFile.hasNext()){
            row = scanFile.nextLine();
            String[] arrOfStr = row.split(",", 0);
            String Conc = arrOfStr[0]+ "," + arrOfStr[21]+ "," + arrOfStr[4];
            inner: for (int i = 0; i < states.size(); i++) {
                if(arrOfStr[1].equals(states.get(i).getAbbr())){
                    states.get(i).addData(Conc);
                    break inner;
                }
              }
        }
    }

    public static State getState(String target, ArrayList<State> states){
        for (int i = 0; i < states.size(); i++) {
            if(target.equals(states.get(i).getAbbr())){
                return states.get(i);
            }
        }
        return null;
    }
    
    public static void printTable(ArrayList<String> Strings){
        String row;
        System.out.printf("%-15s%-10s%-10s%n","Date","Cases","Deaths");
        for (int i = 0; i < Strings.size(); i++) {
            row = Strings.get(i);
            String[] arrOfStr = row.split(",", 0);
            System.out.printf("%-15s%-10s%-10s%n",arrOfStr[0],arrOfStr[1],arrOfStr[2]);
        }
    }
}
