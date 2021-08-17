/*ICS 111 Assignment 2 
@David Pavlicek 
The purpose of this code is to calculate and output the expected infection and 
fatality rates over five succesive time periods as well as the stating values 
*/
public class InfectionCalculator {
    public static void main(String[] args) throws Exception {
        
    double R0 = 5.7, IFR = 1.15; //Initate reproduction number and infection fatality ratio as doubles 
    String DN = "Covid-19"; //Initiate 'Disease Name' as a string 
    int SNOC = 100; //Initiate the 'starting number of cases' as an integer

    System.out.println(DN + " spread using R0=" +R0+ " and starting at " + SNOC + " cases:");
    System.out.println("T0: " + SNOC);
    for (int i = 1; i < 6; i++) {
        double mulINF = Math.pow(R0, i);
        System.out.print("T" + i + ": ");
        System.out.printf("%,.2f %n", SNOC*mulINF);
    }
    
    System.out.println("\n" + DN + " fatalities using R0=" +R0+ ", IFR=" + IFR + ", and starting at " + SNOC + " cases:");
    for (int i = 0; i < 6; i++) {
        double mulINF = Math.pow(R0, i);
        System.out.print("T" + i + ": ");
        System.out.printf("%,d %n",Math.round(SNOC*mulINF*(IFR/100)));
    }
    }
}
