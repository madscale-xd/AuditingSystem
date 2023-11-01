public class Month {
	private Receipt head;
	private Receipt tail;
	
	public Month() {
		this.head=null;
		this.tail=null;
	}
	
	 public void newReceipt(int verFee, int regFee, String payor, String particulars) {
	        Receipt newNode = new Receipt(verFee, regFee, payor, particulars);
	        if (tail == null) {
	            head = newNode;
	            tail = newNode;
	        } else {
	            tail.next = newNode;
	            newNode.prev = tail;
	            tail = newNode;
	        }
	    }
	 
	 public String show() {
		    String aaa = "";
		    Receipt current = head;
		    while (current != null) {
		        aaa += current.getNumber() + " " + current.getTotalFee() + " "+current.getDate()+"\n"; // Concatenate the value and a space
		        current = current.next;
		    }
		    return aaa;
		}

}
