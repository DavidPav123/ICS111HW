/*ICS 111 Assignment 3 Part 2
@David Pavlicek 
The purpose of this code is to take user input of the name of a state and then read a file
to aquire the starting number of cases and the Rt. It then prints out the spread in that 
state over five periods. 
*/
import java.util.Scanner;
import java.io.File;
public class InfectionCalculator3 {
    public static void main(String[] args) throws Exception {
        Scanner myobj = new Scanner(System.in);
        System.out.println("Name of the state:");
        String In = myobj.nextLine();
        File file = new File("src/" + In + ".txt");
        myobj = new Scanner(file);
        String State = myobj.nextLine();
        double Rt = myobj.nextFloat();
        int SNOC = myobj.nextInt();
        
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