public class Months {
	private ReceiptNT head;
	private ReceiptNT tail;
	private ReceiptSSP head2;
	private ReceiptSSP tail2;
	private int SSPCount=0, NTCount=0;
	
	public Months() {
		this.head=null;
		this.tail=null;
	}
	
	 public void receiptNT(int verFee, int regFee, String payor, String particulars) {
	        ReceiptNT newNode = new ReceiptNT(verFee, regFee, payor, particulars);
	        NTCount = newNode.getNumber();
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
	        SSPCount = newNode.getNumber();
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
		    int totalVer = 0;
		    int totalReg = 0;
		    int totalTotal = 0;
		    int receiptCount = 0;
		    while (current != null) {
		    	totalVer += current.getVerFee();
		    	totalReg += current.getRegFee();
		    	totalTotal += current.getTotalFee();
		    	receiptCount++;
		        aaa += current.toString() +"\n";
		        current = current.next;
		    }
		    return aaa += "\tTOTALS | Total No. of Receipts "+receiptCount+" | Total Verification Fees "+totalVer+
		    		" | Total Registration Fees "+totalReg+" | Total of Fees for this month "+totalTotal + "\n";
		}
	 
	 public String showSSP() {
		    String aaa = "";
		    ReceiptSSP current = head2;
		    int totalVer = 0;
		    int totalReg = 0;
		    int totalTotal = 0;
		    int receiptCount = 0;
		    while (current != null) {
		    	totalVer += current.getVerFee();
		    	totalReg += current.getRegFee();
		    	totalTotal += current.getTotalFee();
		        aaa += current.toString();
		        current = current.next;
		    }
		    return aaa += "\tTOTALS | Total No. of Receipts "+receiptCount+" | Total Verification Fees "+totalVer+
		    		" | Total Registration Fees "+totalReg+" | Total of Fees for this month "+totalTotal + "\n";
		}
	 
	 public int deleteNT(int value) {
		    ReceiptNT current = head;
		    int xd = -1;
		    
		    while (current != null) {
		        if (current.getNumber() == value) {
		            if (current.prev != null) {
		                current.prev.next = current.next;
		            } else {
		                head = current.next;
		            }
		            
		            if (current.next != null) {
		                current.next.prev = current.prev;
		            } else {
		                tail = current.prev;
		            }
		            current.prev = null;
		            current.next = null;
		            xd = 1;
		            break; 
		        }
		        
		        current = current.next;
		    }
		    
		    return xd;
		}

		public int deleteSSP(int value) {
		    ReceiptSSP current = head2;
		    int xd = -1;
		    
		    while (current != null) {
		        if (current.getNumber() == value) {
		            if (current.prev != null) {
		                current.prev.next = current.next;
		            } else {
		                head2 = current.next;
		            }
		            
		            if (current.next != null) {
		                current.next.prev = current.prev;
		            } else {
		                tail2 = current.prev;
		            }
		            current.prev = null;
		            current.next = null;
		            xd = 1;
		            break; 
		        }
		        
		        current = current.next;
		    }
		    
		    return xd;
		}
		
		public boolean replaceNT(int verFee, int regFee, String payor, String particulars, int value) {
		    ReceiptNT current = head;
		    
		    while (current != null) {
		        if (current.getNumber() == value) {
		        	int vf = verFee;
		        	int rf = regFee;
		        	String pyr = payor;
		        	String prt = particulars;
		        	current.replaceValues(vf, rf, pyr, prt);
		            return true; // Value replaced
		        }
		        
		        current = current.next;
		    }
		    
		    return false; 
		}

		public boolean replaceSSP(int verFee, int regFee, String payor, String particulars, int value) {
		    ReceiptSSP current = head2;
		    
		    while (current != null) {
		        if (current.getNumber() == value) {
		        	int vf = verFee;
		        	int rf = regFee;
		        	String pyr = payor;
		        	String prt = particulars;
		        	current.replaceValues(vf, rf, pyr, prt);
		            return true; 
		        }
		        current = current.next;
		    }
		    return false; 
		}

		
		public String searchNT(int value) {
		    ReceiptNT current = head;
		    while (current != null) {
		        if (current.getNumber() == value) {
		            return current.toString(); 
		        }
		        
		        current = current.next;
		    }
		    return null; 
		}
		
		public String searchSSP(int value) {
		    ReceiptSSP current = head2;
		    
		    while (current != null) {
		        if (current.getNumber() == value) {
		            return current.toString(); 
		        }
		        
		        current = current.next;
		    }
		    return null; 
		}
		
		public int getNTCount() {
			return NTCount;
		}
		
		public int getSSPCount() {
			return SSPCount;
		}
		
}
