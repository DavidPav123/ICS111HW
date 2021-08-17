/*ICS 111 Assignment 4
@David Pavlicek 
The purpose of this code is to take user input of the name of a state and then read a file
using meathod to aquire the starting number of cases and the Rt. It then prints out the spread in 
that state over five periods. 
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InfectionCalculator3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myobj = new Scanner(getFile());
        String State = myobj.nextLine();
        double Rt = myobj.nextFloat();
        int SNOC = myobj.nextInt();
        makeFinalString(State, SNOC, Rt);
    }

    public static File getFile(){
        Scanner myobj = new Scanner(System.in);
        System.out.println("Name of the state:");
        String In = myobj.nextLine();
        File file = new File("src/" + In + ".txt");
        myobj.close();
        return file;
    }

    public static double tick(double nCases, double rt){
        return Math.round((nCases*rt) * 100.0) / 100.0;
    }

    public static long roundint(double n){
        return Math.round(n);
    }

    public static void makeFinalString(String state, double start, double r){
        System.out.print(state);
        for (int i = 0; i < 5; i++) {
            System.out.print(",");
            double mulINF = Math.pow(r, i);
            System.out.print(roundint(tick(start,mulINF)));
        }
        System.out.println();
    }
}