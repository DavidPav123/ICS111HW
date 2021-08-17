/*ICS 111 Assignment 3 Part 1 
@David Pavlicek 
The purpose of this code is to take user input of the name of a state,
the number of cases, and the Rt. It then prints out the spread in that 
state over five periods 
*/
import java.util.Scanner;
public class InfectionCalculator2 {
    public static void main(String[] args) throws Exception {
        Scanner myobj = new Scanner(System.in);
        System.out.println("State:");
        String State = myobj.nextLine();
        System.out.println("Current number of cases in " + State + ":");
        int SNOC = myobj.nextInt();
        System.out.println("Current Rt in " + State + ":");
        double Rt = myobj.nextFloat();
        
        System.out.print("COVID-19 spread in " + State + " using Rt=" +Rt+ " and starting at ");
        System.out.printf("%,d",SNOC);
        System.out.println(" cases");
        for (int i = 0; i < 6; i++) {
            double mulINF = Math.pow(Rt, i);
            System.out.print("T" + i + ": ");
            System.out.printf("%,d %n", Math.round(SNOC*mulINF));
        }
    }
}


