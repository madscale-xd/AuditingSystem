
public class testAudit {
	public static void main(String[] args) {
		Year yr2023 = new Year();
		yr2023.NT = new Branch();
		yr2023.SSP = new Branch();
		
		Months january = yr2023.JanuaryNT;
		Months february = yr2023.FebruaryNT;
		Months march = yr2023.MarchNT;
		Months march2 = yr2023.MarchSSP;
		Months april = yr2023.AprilNT;
		
		january.receiptNT(23, 23, "a", "b");
		january.receiptNT(23, 24, "a	", "b");
		february.receiptNT(24, 25, "a", "b");
		march.receiptNT(24, 25, "a", "b");
		march2.receiptSSP(0, 0, "xd", "xd");
		System.out.println(january.showNT());
		january.replaceNT(23, 23, "xd", "bababooe", 1);
		System.out.println(january.searchNT(1));
		if(january.deleteNT(3)==1) {
			System.out.println("Boang");
		}
		System.out.println(january.showNT());
		System.out.println(february.showNT());
		System.out.println(march2.showSSP());
		System.out.println("hi girl "+march.showNT());
		System.out.println("april would be here "+april.showNT());
	}
}
