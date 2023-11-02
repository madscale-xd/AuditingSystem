public class Month {
	private ReceiptNT head;
	private ReceiptNT tail;
	private ReceiptSSP head2;
	private ReceiptSSP tail2;
	
	public Month() {
		this.head=null;
		this.tail=null;
	}
	
	 public void receiptNT(int verFee, int regFee, String payor, String particulars) {
	        ReceiptNT newNode = new ReceiptNT(verFee, regFee, payor, particulars);
	        if (tail == null) {
	            head = newNode;
	            tail = newNode;
	        } else {
	            tail.next = newNode;
	            newNode.prev = tail;
	            tail = newNode;
	        }
	    }
	 
	 public void receiptSSP(int verFee, int regFee, String payor, String particulars) {
	        ReceiptSSP newNode = new ReceiptSSP(verFee, regFee, payor, particulars);
	        if (tail2 == null) {
	            head2 = newNode;
	            tail2 = newNode;
	        } else {
	            tail2.next = newNode;
	            newNode.prev = tail2;
	            tail2 = newNode;
	        }
	    }
	 
	 public String showNT() {
		    String aaa = "";
		    ReceiptNT current = head;
		    while (current != null) {
		        aaa += current.getNumber() + " " + current.getVerFee()+" "+current.getRegFee()+" "+current.getTotalFee() + " "+current.getDate()
		        +" "+current.getPayor()+" "+current.getParticulars()+"\n"; // Concatenate the value and a space
		        current = current.next;
		    }
		    return aaa;
		}
	 
	 public String showSSP() {
		    String aaa = "";
		    ReceiptSSP current = head2;
		    while (current != null) {
		        aaa += current.getNumber() + " " + current.getVerFee()+" "+current.getRegFee()+" "+current.getTotalFee() + " "+current.getDate()
		        +" "+current.getPayor()+" "+current.getParticulars()+"\n"; // Concatenate the value and a space
		        current = current.next;
		    }
		    return aaa;
		}

}
