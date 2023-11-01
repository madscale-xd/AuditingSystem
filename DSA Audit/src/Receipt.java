import java.time.LocalDate;

public class Receipt{
		private LocalDate currentDate;
		private int number=0, verFee, regFee=0, totalFee;
		private String payor, particulars;
		private Receipt next, prev;
		
		public Receipt(int verFee, int regFee, String payor, String particulars){
			this.number+=1;
			this.currentDate = LocalDate.now();
			this.verFee = verFee;
			this.regFee = regFee;
			this.totalFee = verFee + regFee;
			this.payor = payor;
			this.particulars = particulars;
			this.next = null;
			this.prev = null;
		}
	}