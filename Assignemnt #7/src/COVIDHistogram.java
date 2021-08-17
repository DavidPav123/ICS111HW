import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class COVIDHistogram {
    public static void main(String[] args) throws Exception {
        int[] COVIDCat = {0};
        Scanner myobj = new Scanner(System.in); 
        System.out.print("Enter a date (YYYY-MM-DD): "); 
        String Date = myobj.nextLine();
        COVIDCat = findRow(Date);
        for(int i = 0; i<12; i++){
            printLabel(i);
            printBar(COVIDCat[i]);
            System.out.println();
        }
    }

    //Change this to iterate throught the whole file and find all fo the matching dates and whenit finds a match add its value to the array
    public static int[] findRow(String Date) throws FileNotFoundException {
        int[] COVIDCat = {0,0,0,0,0,0,0,0,0,0,0,0};
        String row;
        Scanner scanFile = new Scanner(new File("/Users/davidpavlicek/Desktop/ICS 111 /Assignemnt #7/src/all-states-history-new.csv")).useDelimiter(",");
        while(scanFile.hasNext()){
            row = scanFile.nextLine();
            Scanner look = new Scanner(row).useDelimiter(",");
            String date = look.next();
            if(date.equals(Date)){
                int Info = Integer.parseInt(getColumn(22, row));
                if(Info == 0){
                    COVIDCat[0] = COVIDCat[0] + 1; 
                }
                else if(Info >=1 & Info <= 500){
                    COVIDCat[1] = COVIDCat[1] + 1; 
                }
                else if(Info >=501 & Info <= 1000){
                    COVIDCat[2] = COVIDCat[2] + 1; 
                }
                else if(Info >=1001 & Info <= 1500){
                    COVIDCat[3] = COVIDCat[3] + 1; 
                }
                else if(Info >=1501 & Info <= 2000){
                    COVIDCat[4] = COVIDCat[4] + 1; 
                }
                else if(Info >=2001 & Info <= 2500){
                    COVIDCat[5] = COVIDCat[5] + 1; 
                }
                else if(Info >=2501 & Info <= 3000){
                    COVIDCat[6] = COVIDCat[6] + 1; 
                }
                else if(Info >=3001 & Info <= 3500){
                    COVIDCat[7] = COVIDCat[7] + 1; 
                }
                else if(Info >=3501 & Info <= 4000){
                    COVIDCat[8] = COVIDCat[8] + 1; 
                }
                else if(Info >=4001 & Info <= 4500){
                    COVIDCat[9] = COVIDCat[9] + 1; 
                }
                else if(Info >=4501 & Info <= 5000){
                    COVIDCat[10] = COVIDCat[10] + 1; 
                }
                else{
                    COVIDCat[11] = COVIDCat[11] + 1; 
                }

            }
        }
        return COVIDCat;
    }

    public static String getColumn(int Column, String row){
        String data = "";
        Scanner col = new Scanner(row).useDelimiter(",");
        for(int i = 0; i < Column; i++){
            data = col.next();
        }
        return data;
    }

    public static void printBar(int n){
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
        System.out.print("(" + n + ")");
    }

    public static void printLabel(int n){
        switch(n){
            case 0:
                System.out.print("        0: ");
                break;
            case 1:
                System.out.print("    1-500: ");
                break;
            case 2:
                System.out.print(" 501-1000: ");
                break;
            case 3:
                System.out.print("1001-1500: ");
                break;
            case 4:
                System.out.print("1501-2000: ");
                break;
            case 5:
                System.out.print("2001-2500: ");
                break;
            case 6:
                System.out.print("2501-3000: ");
                break;
            case 7:
                System.out.print("3001-3500: ");
                break;
            case 8:
                System.out.print("3501-4000: ");
                break;
            case 9:
                System.out.print("4001-4500: ");
                break;
            case 10:
                System.out.print("4501-5000: ");
                break;
            case 11:
                System.out.print("    >5000: ");
                break;
        }
    }
}

