/*ICS 111 Assignment 5
@David Pavlicek 
The purpose of this code is to take user input of the name of a state and then read a file
using meathod to aquire the starting number of cases and the Rt. It then corrects for any error 
in user input and prints out the spread over five periods in a readable and shortened format.  
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class IF {
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
        String in = myobj.nextLine();
        myobj.close();
        File file = new File("src/" + spelling(in) + ".txt");
        return file;
    }

    public static double tick(double nCases, double rt){
        return Math.round((nCases*rt) * 100.0) / 100.0;
    }

    public static int roundint(double n){
        return (int)Math.round(n);
    }

    public static void makeFinalString(String state, double start, double r){
        System.out.print(state);
        for (int i = 0; i < 5; i++) {
            System.out.print(",");
            double mulINF = Math.pow(r, i);
            System.out.print(shorten(roundint(tick(start,mulINF))));
        }
        System.out.println();
    }

    public static String spelling(String input){
        if(input.equals("Hawaai")){
            return "Hawaii";
        }
        else if(input.equals("Oreogon")){
            return "Oregon";
        }
        else if(input.equals("Warshington")){
            return "Washington";
        }
        else if(input.equals("Californai")){
            return "California";
        }
        else{
            return input; 
        }
    }
    
    public static String shorten(int input){
        int conv = input/100;
        if(conv < 10){
            return  conv + " hundred";
        }
        else if(conv > 10 & conv <1000){
            conv = conv/10;
            return conv + " thousand";
        }
        else if(conv > 990 & conv<10000){
            conv = conv/1000;
            return conv + " hundred thousand";
        }
        else{
            conv = conv/10000;
            return conv + " million";
        }
    }
}