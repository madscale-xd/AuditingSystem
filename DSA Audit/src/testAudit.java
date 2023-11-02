
public class testAudit {
	public static void main(String[] args) {
		Year yr2023 = new Year();
		yr2023.NT = new Branch();
		yr2023.SSP = new Branch();
		
		Month january = yr2023.NT.January;
		Month february = yr2023.NT.February;
		Month march = yr2023.SSP.March;
		Month march2 = yr2023.NT.March;
		
		january.receiptNT(23, 23, "a", "b");
		january.receiptNT(23, 23, "a", "b");
		february.receiptNT(24, 25, "a", "b");
		march.receiptNT(24, 25, "a", "b");
		march2.receiptSSP(0, 0, "xd", "xd");
		System.out.println(january.showNT());
		System.out.println(march2.showSSP());
		System.out.println(february.showNT());
		System.out.println(march.showNT());
	}
}
