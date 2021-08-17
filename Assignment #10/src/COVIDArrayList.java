import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class COVIDArrayList {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> table = new ArrayList<String>();
        String file;
        String country = getCountryName();
       
        getRows(country,table);
        if (table.size() > 0) {
            file = writeRowsToFile(country,table);
            System.out.println(table.size() + " rows of data were successfully written to the file: " + file + "\n");
        }
        else System.out.println("The country name \"" + country + "\" could not be found in the data file");
    }

    public static String getCountryName(){
        Scanner myobj = new Scanner(System.in);
        System.out.print("Enter a country name: ");
        String In = myobj.nextLine();
        myobj.close();
        return In;
    }

    public static void getRows(String country, ArrayList<String> table) throws FileNotFoundException{
        String row;
        double percent = 0;
        Scanner scanFile = new Scanner(new File("owid-covid-data.csv")).useDelimiter(",");
        while(scanFile.hasNext()){
            row = scanFile.nextLine();
            String[] arrOfStr = row.split(",", 0);
            if(arrOfStr[2].equals(country)){
                if(arrOfStr[4].length() > 0 & arrOfStr[44].length() > 0){
                    percent = (Double.parseDouble(arrOfStr[4])/Double.parseDouble(arrOfStr[44])*100);
                }
                String Conc = arrOfStr[3]+ "," + arrOfStr[4]+ "," + arrOfStr[7]+ "," + percent;
                table.add(Conc);
            }
        }

    }

    public static String writeRowsToFile(String country, ArrayList<String> table) throws FileNotFoundException{
        String fileName = country.replaceAll("\\s+", "_") + ".csv";
        PrintWriter outputFile = new PrintWriter(fileName);
        outputFile.println("Date,Total Cases, Total Deaths, Cases As %Population");
        for(int i = 0; i < table.size(); i++){
            outputFile.println(table.get(i));
        }
        outputFile.close();
        return fileName;
    }

}
