import java.util.*;

public class Branch {
    ArrayList<Object> months;
    public Month January = new Month();
    public Month February = new Month();
    public Month March = new Month();
    public Month April = new Month();
    public Month May = new Month();
    public Month June = new Month();
    public Month July = new Month();
    public Month August = new Month();
    public Month September = new Month();
    public Month October = new Month();
    public Month November = new Month();
    public Month December = new Month();

    public Branch() {
        this.months = new ArrayList<>();
        months.add(January);
        months.add(February);
        months.add(March);
        months.add(April);
        months.add(May);
        months.add(June);
        months.add(July);
        months.add(August);
        months.add(September);
        months.add(October);
        months.add(November);
        months.add(December);
    }
}