public class DailyData {
    
    private String date;

    private String state;

    private int cases;

    private int deaths;

    public DailyData(String s1, String s2, int c, int d){
        date = s1;

        state = s2;

        cases = c;

        deaths = d;
    }

    public String getDate(){
        return date;
    }

    public String getState(){
        return state;
    }

    public int getNCases(){
        return cases;
    }

    public int getNDeaths(){
        return deaths;
    }

    public String toString(){
        return String.format("%-25s%-15s%-15s%n",getState(),getNCases(),getNDeaths());
    }
}
