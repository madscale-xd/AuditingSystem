import java.time.LocalDate;

public class ReceiptSSP {
    private static int count = 0; 
    private int number; 
    private LocalDate currentDate;
    private int verFee, regFee, totalFee;
    private String payor, particulars;
    public ReceiptSSP next, prev;

    public ReceiptSSP(int verFee, int regFee, String payor, String particulars) {
        this.number = ++count; 
        this.currentDate = LocalDate.now();
        this.verFee = verFee;
        this.regFee = regFee;
        this.totalFee = verFee + regFee;
        this.payor = payor;
        this.particulars = particulars;
        this.next = null;
        this.prev = null;
    }

    public int getNumber() {
        return number;
    }
    public int getVerFee() {
        return verFee;
    }
    public int getRegFee() {
        return regFee;
    }
    public int getTotalFee() {
        return totalFee;
    }
    public LocalDate getDate() {
    	return currentDate;
    }
    public String getPayor() {
    	return payor;
    }
    public String getParticulars() {
    	return particulars;
    }
    public void replaceValues(int verFee, int regFee, String payor, String particulars) {
    	this.verFee = verFee;
    	this.regFee = regFee;
    	this.payor = payor;
    	this.particulars = particulars;
    }
    @Override
    public String toString() {
    	return "\t| ID "+ number + " | Verification Fee " + verFee +" | Registration Fee "+ regFee +
    			" | Total Fee "+ totalFee + " | Current Date "+ currentDate
    			+" | Payor "+ payor +" | Particulars "+ particulars +" |\n";
    }
}