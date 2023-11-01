public class AuditingSystem {
	public static void main(String[] args) {
		Month January = new Month();
		January.newReceipt(23, 46, "abc", "123");
		January.newReceipt(23, 47, "abc", "123");
		January.newReceipt(23, 48, "abc", "123");
		System.out.println(January.show());
	}
}
