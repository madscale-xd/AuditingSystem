import java.util.*;

public class Branch {
    ArrayList<Object> months;
    Month January = new Month();
    Month February = new Month();
    Month March = new Month();
    Month April = new Month();
    Month May = new Month();
    Month June = new Month();
    Month July = new Month();
    Month August = new Month();
    Month September = new Month();
    Month October = new Month();
    Month November = new Month();
    Month December = new Month();

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