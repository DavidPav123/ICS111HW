public abstract class AdministrativeDivision {
    private static int nAdminDivs = 0;

    protected String abbr;

    public AdministrativeDivision(){
        nAdminDivs++;
    }

    public static int getNAdminDivs(){
        return nAdminDivs;

    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String s){
        abbr = s;
    }

    public abstract String getName();

    public abstract String getRegion();


}
