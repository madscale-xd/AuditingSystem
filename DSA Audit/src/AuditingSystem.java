import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import java.time.*;

public class AuditingSystem extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JLabel lblChoose, lblNTSSP, lblVerFee, lblRegFee, lblPayor, lblPart, lblDeleteVector, lblMonthChoice;
    private JTextField txtVerFee, txtRegFee, txtPayor, txtPart, txtDeleteVector;
    private JComboBox cboChoose, NTSSP, monthChoice;
    private JTextArea txtAreaUp, txtAreaDown;
    private JButton btnProcess, btnPrint;
    private Year yr2023;
    private LocalDate currDate = LocalDate.now();
    private Month currMonth = currDate.getMonth();
    String hold = "", traversal = "";

    AuditingSystem() {
        yr2023 = new Year(); 
        lblChoose = new JLabel("Choose");
        String menu[] = { "Add Receipt", "Delete Receipt", "Replace Receipt", 
        		"Find Receipt", "Show Monthly Report", "Show Yearly Report", "End"};
        String menu2[] = {"National Treasury", "Sariling Sikap Program"};
        String menu3[] = {"January", "February", "March", "April", "May", "June", "July", "August", 
        		"September", "October", "November", "December"};
        cboChoose = new JComboBox(menu);
        NTSSP = new JComboBox(menu2);
        monthChoice = new JComboBox(menu3);
        txtAreaUp = new JTextArea();
        txtAreaDown = new JTextArea();
        btnProcess = new JButton("Process");
        btnPrint = new JButton("Print to a file");
        lblNTSSP = new JLabel("Division");
        lblVerFee = new JLabel("Verification Fee");
        lblRegFee = new JLabel("Registration Fee");
        lblPayor = new JLabel("Payor");
        lblPart = new JLabel("Particulars");
        lblDeleteVector = new JLabel("Receipt ID to find/delete");
        lblMonthChoice = new JLabel("Month to view");
        txtVerFee = new JTextField();
        txtRegFee = new JTextField();
        txtPayor = new JTextField();
        txtPart = new JTextField();
        txtDeleteVector = new JTextField();
        setTitle("TESDA NT and SSP Auditing System");
        setSize(1280, 720);
        getContentPane().setBackground(new Color(0, 56, 168, 80));
        setLayout(null);
        txtAreaUp.setEditable(false);
        txtAreaDown.setEditable(false);
        display();
        add(txtAreaUp).setBounds(20, 20, 1220, 40);
        add(new JScrollPane(txtAreaDown)).setBounds(20, 70, 1220, 420);
        add(lblChoose).setBounds(360, 500, 60, 20);
        add(cboChoose).setBounds(360, 525, 150, 20);
        add(lblDeleteVector).setBounds(360, 550, 150, 20);
        add(txtDeleteVector).setBounds(360, 570, 150, 20);
        add(lblMonthChoice).setBounds(360, 597, 150, 20);
        add(monthChoice).setBounds(360, 620, 150, 20);
        add(btnProcess).setBounds(590, 505, 200, 120);
        add(btnPrint).setBounds(840, 505, 200, 120);
        add(lblNTSSP).setBounds(20, 500, 100, 20);
        add(NTSSP).setBounds(140, 500, 150, 20);
        add(lblVerFee).setBounds(20, 530, 100, 20);
        add(txtVerFee).setBounds(140, 530, 150, 20);
        add(lblRegFee).setBounds(20, 560, 100, 20);
        add(txtRegFee).setBounds(140, 560, 150, 20);
        add(lblPayor).setBounds(20, 590, 100, 20);
        add(txtPayor).setBounds(140, 590, 150, 20);
        add(lblPart).setBounds(20, 620, 100, 20);
        add(txtPart).setBounds(140, 620, 150, 20);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnProcess.addActionListener(this);
        NTSSP.addActionListener(this);
        btnPrint.addActionListener(this);
        cboChoose.addItemListener(this);
        NTSSP.addItemListener(this);
        monthChoice.addItemListener(this);
        txtVerFee.addKeyListener(this);
        txtRegFee.addKeyListener(this);
        txtPayor.addKeyListener(this);
        txtPart.addKeyListener(this);
        txtDeleteVector.addKeyListener(this);
        btnProcess.setEnabled(false);
        btnPrint.setEnabled(false);
        txtDeleteVector.setEditable(false);
        monthChoice.setEnabled(false);
    }

    public static void main(String[] args) {
        new AuditingSystem();
    }
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnProcess) {
        int i = cboChoose.getSelectedIndex();
        int j = NTSSP.getSelectedIndex();
        int k = monthChoice.getSelectedIndex();
        if (i == 0) {	//add receipt
        	try {
	            int verFee = Integer.parseInt(txtVerFee.getText());
	            int regFee = Integer.parseInt(txtRegFee.getText());
	            this.currDate = LocalDate.now();
                this.currMonth = currDate.getMonth();
	        	if(j==0) {		//nt
	        		if(currMonth==Month.JANUARY) {
	        			yr2023.JanuaryNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.JanuaryNT.getNTCount()+" added to January National Treasury. Information: "
	        					+yr2023.JanuaryNT.searchNT(yr2023.JanuaryNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.FEBRUARY) {
	        			yr2023.FebruaryNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.FebruaryNT.getNTCount()+" added to February National Treasury. Information: "
	        					+yr2023.FebruaryNT.searchNT(yr2023.FebruaryNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.MARCH) {
	        			yr2023.MarchNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.MarchNT.getNTCount()+" added to March National Treasury. Information: "
	        					+yr2023.MarchNT.searchNT(yr2023.MarchNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.APRIL) {
	        			yr2023.AprilNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.AprilNT.getNTCount()+" added to April National Treasury. Information: "
	        					+yr2023.AprilNT.searchNT(yr2023.AprilNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.MAY) {
	        			yr2023.MayNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.MayNT.getNTCount()+" added to May National Treasury. Information: "
	        					+yr2023.MayNT.searchNT(yr2023.MayNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.JUNE) {
	        			yr2023.JuneNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.JuneNT.getNTCount()+" added to June National Treasury. Information: "
	        					+yr2023.JuneNT.searchNT(yr2023.JuneNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.JULY) {
	        			yr2023.JulyNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.JulyNT.getNTCount()+" added to July National Treasury. Information: "
	        					+yr2023.JulyNT.searchNT(yr2023.JulyNT.getNTCount())); 
	        		}
	        		else if(currMonth==Month.AUGUST) {
	        			yr2023.AugustNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.AugustNT.getNTCount()+" added to August National Treasury. Information: "
	        					+yr2023.AugustNT.searchNT(yr2023.AugustNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.SEPTEMBER) {
	        			yr2023.SeptemberNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.SeptemberNT.getNTCount()+" added to September National Treasury. Information: "
	        					+yr2023.SeptemberNT.searchNT(yr2023.SeptemberNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.OCTOBER) {
	        			yr2023.OctoberNT.receiptNT(verFee, regFee, txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.OctoberNT.getNTCount()+" added to Octember National Treasury. Information: "
	        					+yr2023.OctoberNT.searchNT(yr2023.OctoberNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.NOVEMBER) {
	        			yr2023.NovemberNT.receiptNT(Integer.parseInt(txtVerFee.getText()), 
	        					Integer.parseInt(txtRegFee.getText()), txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.NovemberNT.getNTCount()+" added to November National Treasury. Information: "
	        					+yr2023.NovemberNT.searchNT(yr2023.NovemberNT.getNTCount()));
	        		}
	        		else if(currMonth==Month.DECEMBER) {
	        			yr2023.DecemberNT.receiptNT(Integer.parseInt(txtVerFee.getText()), 
	        					Integer.parseInt(txtRegFee.getText()), txtPayor.getText(), txtPart.getText());
	        			txtAreaDown.append("Receipt "+yr2023.DecemberNT.getNTCount()+" added to December National Treasury. Information: "
	        					+yr2023.DecemberNT.searchNT(yr2023.DecemberNT.getNTCount()));
	        		}
	        	}
	        	else if(j==1) {	//ssp
	            	if(currMonth==Month.JANUARY) {
	            			yr2023.JanuarySSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.JanuarySSP.getSSPCount()+" added to January Sariling Sikap Program. Information: "
	        					+yr2023.JanuarySSP.searchSSP(yr2023.JanuarySSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.FEBRUARY) {
	            			yr2023.FebruarySSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.FebruarySSP.getSSPCount()+" added to February Sariling Sikap Program. Information: "
	        					+yr2023.FebruarySSP.searchSSP(yr2023.FebruarySSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.MARCH) {
	            			yr2023.MarchSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.MarchSSP.getSSPCount()+" added to March Sariling Sikap Program. Information: "
	        					+yr2023.MarchSSP.searchSSP(yr2023.MarchSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.APRIL) {
	            			yr2023.AprilSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.AprilSSP.getSSPCount()+" added to April Sariling Sikap Program. Information: "
	        					+yr2023.AprilSSP.searchSSP(yr2023.AprilSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.MAY) {
	            			yr2023.MaySSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.MaySSP.getSSPCount()+" added to May Sariling Sikap Program. Information: "
	        					+yr2023.MaySSP.searchSSP(yr2023.MaySSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.JUNE) {
	            			yr2023.JuneSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.JuneSSP.getSSPCount()+" added to June Sariling Sikap Program. Information: "
	        					+yr2023.JuneSSP.searchSSP(yr2023.JuneSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.JULY) {
	            			yr2023.JulySSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.JulySSP.getSSPCount()+" added to July Sariling Sikap Program. Information: "
	        					+yr2023.JulySSP.searchSSP(yr2023.JulySSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.AUGUST) {
	            			yr2023.AugustSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.AugustSSP.getSSPCount()+" added to August Sariling Sikap Program. Information: "
	        					+yr2023.AugustSSP.searchSSP(yr2023.AugustSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.SEPTEMBER) {
	            			yr2023.SeptemberSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.SeptemberSSP.getSSPCount()+" added to September Sariling Sikap Program. Information: "
	        					+yr2023.SeptemberSSP.searchSSP(yr2023.SeptemberSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.OCTOBER) {
	            			yr2023.OctoberSSP.receiptSSP(verFee, regFee, txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.OctoberSSP.getSSPCount()+" added to October Sariling Sikap Program. Information: "
	        					+yr2023.OctoberSSP.searchSSP(yr2023.OctoberSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.NOVEMBER) {
	            			yr2023.NovemberSSP.receiptSSP(Integer.parseInt(txtVerFee.getText()), 
	            					Integer.parseInt(txtRegFee.getText()), txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.NovemberSSP.getSSPCount()+" added to November Sariling Sikap Program. Information: "
	        					+yr2023.NovemberSSP.searchSSP(yr2023.NovemberSSP.getSSPCount()));
	            	}
	            	else if(currMonth==Month.DECEMBER) {
	            			yr2023.DecemberSSP.receiptSSP(Integer.parseInt(txtVerFee.getText()), 
	            					Integer.parseInt(txtRegFee.getText()), txtPayor.getText(), txtPart.getText());
	            			txtAreaDown.append("Receipt "+yr2023.DecemberSSP.getSSPCount()+" added to December Sariling Sikap Program. Information: "
	        					+yr2023.DecemberSSP.searchSSP(yr2023.DecemberSSP.getSSPCount()));
	            	}
	        	}
        	} catch (NumberFormatException x) {
        		txtAreaDown.append("Invalid Receipt format. Please try again.\n");
        	}
        } else if (i == 1) {	//delete
        	try {
        		int deleteVector = Integer.parseInt(txtDeleteVector.getText());
        		if(j==0) {		//nt
	        		if(yr2023.JanuaryNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the January National Treasury.\n");
	        		}else if(yr2023.FebruaryNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the February National Treasury.\n");
	        		}else if(yr2023.MarchNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the March National Treasury.\n");
	        		}else if(yr2023.AprilNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the April National Treasury.\n");
	        		}else if(yr2023.MayNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the May National Treasury.\n");
	        		}else if(yr2023.JuneNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the June National Treasury.\n");
	        		}else if(yr2023.JulyNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the July National Treasury.\n");
	        		}else if(yr2023.AugustNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the August National Treasury.\n");
	        		}else if(yr2023.SeptemberNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the September National Treasury.\n");
	        		}else if(yr2023.OctoberNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the October National Treasury.\n");
	        		}else if(yr2023.NovemberNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the November National Treasury.\n");
	        		}else if(yr2023.DecemberNT.deleteNT(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the December National Treasury.\n");
	        		}else {
	        			txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the National Treasury Archive.\n");
	        		}
	        	}
	        	else if(j==1) {	//ssp
	        		if(yr2023.JanuarySSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the January Sariling Sikap Program.\n");
	        		}else if(yr2023.FebruarySSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the February Sariling Sikap Program.\n");
	        		}else if(yr2023.MarchSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the March Sariling Sikap Program.\n");
	        		}else if(yr2023.AprilSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the April Sariling Sikap Program.\n");
	        		}else if(yr2023.MaySSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the May Sariling Sikap Program.\n");
	        		}else if(yr2023.JuneSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the June Sariling Sikap Program.\n");
	        		}else if(yr2023.JulySSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the July Sariling Sikap Program.\n");
	        		}else if(yr2023.AugustSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the August Sariling Sikap Program.\n");
	        		}else if(yr2023.SeptemberSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the September Sariling Sikap Program.\n");
	        		}else if(yr2023.OctoberSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the October Sariling Sikap Program.\n");
	        		}else if(yr2023.NovemberSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the November Sariling Sikap Program.\n");
	        		}else if(yr2023.DecemberSSP.deleteSSP(deleteVector)==1) {
	        			txtAreaDown.append("Receipt "+deleteVector+" has been removed from the December Sariling Sikap Program.\n");
	        		}else {
	        			txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the Sariling Sikap Program Archive.\n");
	        		}
	        	}
        	}catch(NumberFormatException x) {
        		txtAreaDown.append("Enter the ID NUMBER of the receipt you want to delete.\n");
        	}
        } else if (i == 2) {	//replace
        	try {
        		int verFee = Integer.parseInt(txtVerFee.getText());
	            int regFee = Integer.parseInt(txtRegFee.getText());
        		int deleteVector = Integer.parseInt(txtDeleteVector.getText());
        		if(j==0) {			//nt
        			if(yr2023.JanuaryNT.searchNT(deleteVector)!=null) {
        				yr2023.JanuaryNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in January NT archive, and replaced with: "+
        				yr2023.JanuaryNT.searchNT(deleteVector));
        			}else if(yr2023.FebruaryNT.searchNT(deleteVector)!=null) {
        				yr2023.FebruaryNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in February NT archive, and replaced with: "+
        				yr2023.FebruaryNT.searchNT(deleteVector));
        			}else if(yr2023.MarchNT.searchNT(deleteVector)!=null) {
        				yr2023.MarchNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in March NT archive, and replaced with: "+
        				yr2023.MarchNT.searchNT(deleteVector));
        			}else if(yr2023.AprilNT.searchNT(deleteVector)!=null) {
        				yr2023.AprilNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in April NT archive, and replaced with: "+
        				yr2023.AprilNT.searchNT(deleteVector));
        			}else if(yr2023.MayNT.searchNT(deleteVector)!=null) {
        				yr2023.MayNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in May NT archive, and replaced with: "+
        				yr2023.MayNT.searchNT(deleteVector));
        			}else if(yr2023.JuneNT.searchNT(deleteVector)!=null) {
        				yr2023.JuneNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in June NT archive, and replaced with: "+
        				yr2023.JuneNT.searchNT(deleteVector));
        			}else if(yr2023.JulyNT.searchNT(deleteVector)!=null) {
        				yr2023.JulyNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in July NT archive, and replaced with: "+
        				yr2023.JulyNT.searchNT(deleteVector));
        			}else if(yr2023.AugustNT.searchNT(deleteVector)!=null) {
        				yr2023.AugustNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in August NT archive, and replaced with: "+
        				yr2023.AugustNT.searchNT(deleteVector));
        			}else if(yr2023.SeptemberNT.searchNT(deleteVector)!=null) {
        				yr2023.SeptemberNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in September NT archive, and replaced with: "+
        				yr2023.SeptemberNT.searchNT(deleteVector));
        			}else if(yr2023.OctoberNT.searchNT(deleteVector)!=null) {
        				yr2023.OctoberNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in October NT archive, and replaced with: "+
        				yr2023.OctoberNT.searchNT(deleteVector));
        			}else if(yr2023.NovemberNT.searchNT(deleteVector)!=null) {
        				yr2023.NovemberNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in November NT archive, and replaced with: "+
        				yr2023.NovemberNT.searchNT(deleteVector));
        			}else if(yr2023.DecemberNT.searchNT(deleteVector)!=null) {
        				yr2023.DecemberNT.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in December NT archive, and replaced with: "+
        				yr2023.DecemberNT.searchNT(deleteVector));
        			}else {
        				txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the National Treasury Archive.\n");
        			}
        		}
        		else if(j==1) {		//ssp
        			if(yr2023.JanuarySSP.searchSSP(deleteVector)!=null) {
        				yr2023.JanuarySSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in January SSP archive, and replaced with: "+
        				yr2023.JanuarySSP.searchNT(deleteVector));
        			}else if(yr2023.FebruarySSP.searchSSP(deleteVector)!=null) {
        				yr2023.FebruarySSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in February SSP archive, and replaced with: "+
        				yr2023.FebruarySSP.searchNT(deleteVector));
        			}else if(yr2023.MarchSSP.searchSSP(deleteVector)!=null) {
        				yr2023.MarchSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in March SSP archive, and replaced with: "+
        				yr2023.MarchSSP.searchNT(deleteVector));
        			}else if(yr2023.AprilSSP.searchSSP(deleteVector)!=null) {
        				yr2023.AprilSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in April SSP archive, and replaced with: "+
        				yr2023.AprilSSP.searchNT(deleteVector));
        			}else if(yr2023.MaySSP.searchSSP(deleteVector)!=null) {
        				yr2023.MaySSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in May SSP archive, and replaced with: "+
        				yr2023.MaySSP.searchNT(deleteVector));
        			}else if(yr2023.JuneSSP.searchSSP(deleteVector)!=null) {
        				yr2023.JuneSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in June SSP archive, and replaced with: "+
        				yr2023.JuneSSP.searchNT(deleteVector));
        			}else if(yr2023.JulySSP.searchSSP(deleteVector)!=null) {
        				yr2023.JulySSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in JulySSP archive, and replaced with: "+
        				yr2023.JulySSP.searchNT(deleteVector));
        			}else if(yr2023.AugustSSP.searchSSP(deleteVector)!=null) {
        				yr2023.AugustSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in August SSP archive, and replaced with: "+
        				yr2023.AugustSSP.searchNT(deleteVector));
        			}else if(yr2023.SeptemberSSP.searchSSP(deleteVector)!=null) {
        				yr2023.SeptemberSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in September SSP archive, and replaced with: "+
        				yr2023.SeptemberSSP.searchNT(deleteVector));
        			}else if(yr2023.OctoberSSP.searchSSP(deleteVector)!=null) {
        				yr2023.OctoberSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in October SSP archive, and replaced with: "+
        				yr2023.OctoberSSP.searchNT(deleteVector));
        			}else if(yr2023.NovemberSSP.searchSSP(deleteVector)!=null) {
        				yr2023.NovemberSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in November SSP archive, and replaced with: "+
        				yr2023.NovemberSSP.searchNT(deleteVector));
        			}else if(yr2023.DecemberSSP.searchSSP(deleteVector)!=null) {
        				yr2023.DecemberSSP.replaceNT(verFee, regFee, txtPayor.getText(), txtPart.getText(), deleteVector);
        				txtAreaDown.append("Receipt "+deleteVector+" found in December SSP archive, and replaced with: "+
        				yr2023.DecemberSSP.searchNT(deleteVector));
        			}else {
        				txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the Sariling Sikap Program Archive.\n");
        			}
        		}
        	}catch(NumberFormatException X) {
        		txtAreaDown.append("Check if your Verification Fee, Registration Fee, and ID Number are all NUMBERS.\n");
        	}
        } else if (i == 3) {	// find
        	try {
        		int deleteVector = Integer.parseInt(txtDeleteVector.getText());
        		if(j==0) {			//nt
        			if(yr2023.JanuaryNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JanuaryNT.searchNT(deleteVector));
        			}else if(yr2023.FebruaryNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.FebruaryNT.searchNT(deleteVector));
        			}else if(yr2023.MarchNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.MarchNT.searchNT(deleteVector));
        			}else if(yr2023.AprilNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.AprilNT.searchNT(deleteVector));
        			}else if(yr2023.MayNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.MayNT.searchNT(deleteVector));
        			}else if(yr2023.JuneNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JuneNT.searchNT(deleteVector));
        			}else if(yr2023.JulyNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JulyNT.searchNT(deleteVector));
        			}else if(yr2023.AugustNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.AugustNT.searchNT(deleteVector));
        			}else if(yr2023.SeptemberNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.SeptemberNT.searchNT(deleteVector));
        			}else if(yr2023.OctoberNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.OctoberNT.searchNT(deleteVector));
        			}else if(yr2023.NovemberNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.NovemberNT.searchNT(deleteVector));
        			}else if(yr2023.DecemberNT.searchNT(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.DecemberNT.searchNT(deleteVector));
        			}else {
        				txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the National Treasury Archive.\n");
        			}
        		}
        		else if(j==1) {		//ssp
        			if(yr2023.JanuarySSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JanuarySSP.searchSSP(deleteVector));
        			}else if(yr2023.FebruarySSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.FebruarySSP.searchSSP(deleteVector));
        			}else if(yr2023.MarchSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.MarchSSP.searchSSP(deleteVector));
        			}else if(yr2023.AprilSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.AprilSSP.searchSSP(deleteVector));
        			}else if(yr2023.MaySSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.MaySSP.searchSSP(deleteVector));
        			}else if(yr2023.JuneSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JuneSSP.searchSSP(deleteVector));
        			}else if(yr2023.JulySSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.JulySSP.searchSSP(deleteVector));
        			}else if(yr2023.AugustSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.AugustSSP.searchSSP(deleteVector));
        			}else if(yr2023.SeptemberSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.SeptemberSSP.searchSSP(deleteVector));
        			}else if(yr2023.OctoberSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.OctoberSSP.searchSSP(deleteVector));
        			}else if(yr2023.NovemberSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.NovemberSSP.searchSSP(deleteVector));
        			}else if(yr2023.DecemberSSP.searchSSP(deleteVector)!=null) {
        				txtAreaDown.append("Receipt found: "+yr2023.DecemberSSP.searchSSP(deleteVector));
        			}else {
        				txtAreaDown.append("Receipt "+deleteVector+" has NOT BEEN FOUND in the Sariling Sikap Program Archive.\n");
        			}
        		}
        	}catch(NumberFormatException x) {
        		txtAreaDown.append("Enter the ID NUMBER of the receipt you want to find.\n");
        	}
    	} else if (i == 4) {	//monthly
    		if(j==0) {//nt
    			if(k==0) { txtAreaDown.setText("January National Treasury Audit Report\n"+yr2023.JanuaryNT.showNT());}
    			else if(k==1) { txtAreaDown.setText("February National Treasury Audit Report\n"+yr2023.FebruaryNT.showNT());}
    			else if(k==2) { txtAreaDown.setText("March National Treasury Audit Report\n"+yr2023.MarchNT.showNT());}
    			else if(k==3) { txtAreaDown.setText("April National Treasury Audit Report\n"+yr2023.AprilNT.showNT());}
    			else if(k==4) { txtAreaDown.setText("May National Treasury Audit Report\n"+yr2023.MayNT.showNT());}
    			else if(k==5) { txtAreaDown.setText("June National Treasury Audit Report\n"+yr2023.JuneNT.showNT());}
    			else if(k==6) { txtAreaDown.setText("July National Treasury Audit Report\n"+yr2023.JulyNT.showNT());}
    			else if(k==7) { txtAreaDown.setText("August National Treasury Audit Report\n"+yr2023.AugustNT.showNT());}
    			else if(k==8) { txtAreaDown.setText("September National Treasury Audit Report\n"+yr2023.SeptemberNT.showNT());}
    			else if(k==9) { txtAreaDown.setText("October National Treasury Audit Report\n"+yr2023.OctoberNT.showNT());}
    			else if(k==10) { txtAreaDown.setText("November National Treasury Audit Report\n"+yr2023.NovemberNT.showNT());}
    			else if(k==11) { txtAreaDown.setText("December National Treasury Audit Report\n"+yr2023.DecemberNT.showNT());}
    		}
    		else if(j==1) {//ssp
    			if(k==0) { txtAreaDown.setText("January Sariling Sikap Program Audit Report\n"+yr2023.JanuarySSP.showSSP());}
    			else if(k==1) { txtAreaDown.setText("February Sariling Sikap Program Audit Report\n"+yr2023.FebruarySSP.showSSP());}
    			else if(k==2) { txtAreaDown.setText("March Sariling Sikap Program Audit Report\n"+yr2023.MarchSSP.showSSP());}
    			else if(k==3) { txtAreaDown.setText("April Sariling Sikap Program Audit Report\n"+yr2023.AprilSSP.showSSP());}
    			else if(k==4) { txtAreaDown.setText("May Sariling Sikap Program Audit Report\n"+yr2023.MaySSP.showSSP());}
    			else if(k==5) { txtAreaDown.setText("June Sariling Sikap Program Audit Report\n"+yr2023.JuneSSP.showSSP());}
    			else if(k==6) { txtAreaDown.setText("July Sariling Sikap Program Audit Report\n"+yr2023.JulySSP.showSSP());}
    			else if(k==7) { txtAreaDown.setText("August Sariling Sikap Program Audit Report\n"+yr2023.AugustSSP.showSSP());}
    			else if(k==8) { txtAreaDown.setText("September Sariling Sikap Program Audit Report\n"+yr2023.SeptemberSSP.showSSP());}
    			else if(k==9) { txtAreaDown.setText("October Sariling Sikap Program Audit Report\n"+yr2023.OctoberSSP.showSSP());}
    			else if(k==10) { txtAreaDown.setText("November Sariling Sikap Program Audit Report\n"+yr2023.NovemberSSP.showSSP());}
    			else if(k==11) { txtAreaDown.setText("December Sariling Sikap Program Audit Report\n"+yr2023.DecemberSSP.showSSP());}
    		}
        	btnPrint.setEnabled(true);
        	txtAreaDown.append("\n");
        } else if (i == 5) {	//yearly
        	if(j==0) {	//nt
        		int YearlyNTRec=0, YearlyNTVer=0, YearlyNTReg=0, YearlyNTTotal=0;
        		txtAreaDown.setText("TESDA YEAR 2023 NATIONAL TREASURY AUDIT REPORT\n\n");
        		txtAreaDown.append("January National Treasury Audit Report\n"+yr2023.JanuaryNT.showNT());
        		YearlyNTRec+=yr2023.JanuaryNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.JanuaryNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.JanuaryNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.JanuaryNT.getNTTotalTotal();
        		txtAreaDown.append("\nFebruary National Treasury Audit Report\n"+yr2023.FebruaryNT.showNT());
        		YearlyNTRec+=yr2023.FebruaryNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.FebruaryNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.FebruaryNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.FebruaryNT.getNTTotalTotal();
        		txtAreaDown.append("\nMarch National Treasury Audit Report\n"+yr2023.MarchNT.showNT());
        		YearlyNTRec+=yr2023.MarchNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.MarchNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.MarchNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.MarchNT.getNTTotalTotal();
        		txtAreaDown.append("\nApril National Treasury Audit Report\n"+yr2023.AprilNT.showNT());
        		YearlyNTRec+=yr2023.AprilNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.AprilNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.AprilNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.AprilNT.getNTTotalTotal();
        		txtAreaDown.append("\nMay National Treasury Audit Report\n"+yr2023.MayNT.showNT());
        		YearlyNTRec+=yr2023.MayNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.MayNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.MayNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.MayNT.getNTTotalTotal();
        		txtAreaDown.append("\nJune National Treasury Audit Report\n"+yr2023.JuneNT.showNT());
        		YearlyNTRec+=yr2023.JuneNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.JuneNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.JuneNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.JuneNT.getNTTotalTotal();
        		txtAreaDown.append("\nJuly National Treasury Audit Report\n"+yr2023.JulyNT.showNT());
        		YearlyNTRec+=yr2023.JulyNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.JulyNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.JulyNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.JulyNT.getNTTotalTotal();
        		txtAreaDown.append("\nAugust National Treasury Audit Report\n"+yr2023.AugustNT.showNT());
        		YearlyNTRec+=yr2023.AugustNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.AugustNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.AugustNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.AugustNT.getNTTotalTotal();
        		txtAreaDown.append("\nSeptember National Treasury Audit Report\n"+yr2023.SeptemberNT.showNT());
        		YearlyNTRec+=yr2023.SeptemberNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.SeptemberNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.SeptemberNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.SeptemberNT.getNTTotalTotal();
        		txtAreaDown.append("\nOctober National Treasury Audit Report\n"+yr2023.OctoberNT.showNT());
        		YearlyNTRec+=yr2023.OctoberNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.OctoberNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.OctoberNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.OctoberNT.getNTTotalTotal();
        		txtAreaDown.append("\nNovember National Treasury Audit Report\n"+yr2023.NovemberNT.showNT());
        		YearlyNTRec+=yr2023.NovemberNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.NovemberNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.NovemberNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.NovemberNT.getNTTotalTotal();
        		txtAreaDown.append("\nDecember National Treasury Audit Report\n"+yr2023.DecemberNT.showNT());
        		YearlyNTRec+=yr2023.DecemberNT.getNTTotalReceipt();
        		YearlyNTVer+=yr2023.DecemberNT.getNTTotalVer();
        		YearlyNTReg+=yr2023.DecemberNT.getNTTotalReg();
        		YearlyNTTotal+=yr2023.DecemberNT.getNTTotalTotal();
        		txtAreaDown.append("\n\n\tYEARLY NT TOTALS | Total No. of Receipts "+YearlyNTRec+" | Total Verification Fees "+YearlyNTVer+
		    		" | Total Registration Fees "+YearlyNTReg+" | Total of Fees for this YEAR "+ YearlyNTTotal + " |\n");
        	}
        	else if(j == 1) {	//ssp
        		int YearlySSPRec=0, YearlySSPVer=0, YearlySSPReg=0, YearlySSPTotal=0;
        		txtAreaDown.setText("TESDA YEAR 2023 SARILING SIKAP PROGRAM AUDIT REPORT\n\n");
        		txtAreaDown.append("\nJanuary Sariling Sikap Program Audit Report\n"+yr2023.JanuarySSP.showSSP());
        		YearlySSPRec+=yr2023.JanuarySSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.JanuarySSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.JanuarySSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.JanuarySSP.getSSPTotalTotal();
        		txtAreaDown.append("\nFebruary Sariling Sikap Program Audit Report\n"+yr2023.FebruarySSP.showSSP());
        		YearlySSPRec+=yr2023.FebruarySSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.FebruarySSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.FebruarySSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.FebruarySSP.getSSPTotalTotal();
        		txtAreaDown.append("\nMarch Sariling Sikap Program Audit Report\n"+yr2023.MarchSSP.showSSP());
        		YearlySSPRec+=yr2023.MarchSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.MarchSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.MarchSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.MarchSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nApril Sariling Sikap Program Audit Report\n"+yr2023.AprilSSP.showSSP());
        		YearlySSPRec+=yr2023.AprilSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.AprilSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.AprilSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.AprilSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nMay Sariling Sikap Program Audit Report\n"+yr2023.MaySSP.showSSP());
        		YearlySSPRec+=yr2023.MaySSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.MaySSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.MaySSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.MaySSP.getSSPTotalTotal();
        		txtAreaDown.append("\nJune Sariling Sikap Program Audit Report\n"+yr2023.JuneSSP.showSSP());
        		YearlySSPRec+=yr2023.JuneSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.JuneSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.JuneSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.JuneSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nJuly Sariling Sikap Program Audit Report\n"+yr2023.JulySSP.showSSP());
        		YearlySSPRec+=yr2023.JulySSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.JulySSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.JulySSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.JulySSP.getSSPTotalTotal();
        		txtAreaDown.append("\nAugust Sariling Sikap Program Audit Report\n"+yr2023.AugustSSP.showSSP());
        		YearlySSPRec+=yr2023.AugustSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.AugustSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.AugustSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.AugustSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nSeptember Sariling Sikap Program Audit Report\n"+yr2023.SeptemberSSP.showSSP());
        		YearlySSPRec+=yr2023.SeptemberSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.SeptemberSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.SeptemberSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.SeptemberSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nOctober Sariling Sikap Program Audit Report\n"+yr2023.OctoberSSP.showSSP());
        		YearlySSPRec+=yr2023.OctoberSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.OctoberSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.OctoberSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.OctoberSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nNovember Sariling Sikap Program Audit Report\n"+yr2023.NovemberSSP.showSSP());
        		YearlySSPRec+=yr2023.NovemberSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.NovemberSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.NovemberSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.NovemberSSP.getSSPTotalTotal();
        		txtAreaDown.append("\nDecember Sariling Sikap Program Audit Report\n"+yr2023.DecemberSSP.showSSP());
        		YearlySSPRec+=yr2023.DecemberSSP.getSSPTotalReceipt();
        		YearlySSPVer+=yr2023.DecemberSSP.getSSPTotalVer();
        		YearlySSPReg+=yr2023.DecemberSSP.getSSPTotalReg();
        		YearlySSPTotal+=yr2023.DecemberSSP.getSSPTotalTotal();
        		txtAreaDown.append("\n\n\tYEARLY SSP TOTALS | Total No. of Receipts "+YearlySSPRec+" | Total Verification Fees "+YearlySSPVer+
    		    		" | Total Registration Fees "+YearlySSPReg+" | Total of Fees for this YEAR "+ YearlySSPTotal + " |\n");
        	}
        	btnPrint.setEnabled(true);
        	txtAreaDown.append("\n");
        } else if (i == 6) {	//end
            System.exit(0);
        }
        display();
        btnProcess.setEnabled(false);
      }else if(e.getSource()==btnPrint) {
    	  btnProcess.setEnabled(true);
    	  btnPrint.setEnabled(false);
    	  JFileChooser fileChooser = new JFileChooser();
          if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
              File file = fileChooser.getSelectedFile();
              try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                  writer.write(txtAreaDown.getText());
                  JOptionPane.showMessageDialog(this, "Report is saved to " + file.getName());
              } catch (IOException ex) {
                  JOptionPane.showMessageDialog(this, "Error saving the text: " + ex.getMessage());
              }
          }
      }
     }

    public void itemStateChanged(ItemEvent e) {
        int i = cboChoose.getSelectedIndex();
        int j = NTSSP.getSelectedIndex();
        int k = monthChoice.getSelectedIndex();
        if (i == 0) {	//add
            disable();
            enableAll();
            monthChoice.setEnabled(false);
            btnPrint.setEnabled(false);
        } else if (i == 1) {	//delete
            disableAll();
            btnProcess.setEnabled(false);
            btnPrint.setEnabled(false);
            enable();
        } else if (i == 2) { 	//replace
        	enableAll();
        	btnPrint.setEnabled(false);
        	enable();
        } else if (i == 3) {	//find
        	disableAll();
            btnProcess.setEnabled(false);
            btnPrint.setEnabled(false);
            enable();
        } else if (i == 4) {	//monthly
            disable();
            disableAll();
            monthChoice.setEnabled(true);
            btnProcess.setEnabled(true);
        } else if (i == 5) {	//yearly
        	disable();
            disableAll();
            monthChoice.setEnabled(true);
            btnProcess.setEnabled(true);
            monthChoice.setEnabled(false);
        } else if (i == 6) {	//end
            disableAll();
            disable();
            btnProcess.setEnabled(true);
        }
        
        if(j == 0 || j == 1) {
        	btnProcess.setEnabled(true);
        }
        if(k!=-1) {
        	btnProcess.setEnabled(true);
        }
    }

    public void enable() {
        txtDeleteVector.setEditable(true);
    }

    public void disable() {
        txtDeleteVector.setEditable(false);
    }
    public void disableAll() {
        txtVerFee.setEditable(false);
        txtRegFee.setEditable(false);
        txtPayor.setEditable(false);
        txtPart.setEditable(false);
        monthChoice.setEnabled(false);
    }
    public void enableAll() {
        txtVerFee.setEditable(true);
        txtRegFee.setEditable(true);
        txtPayor.setEditable(true);
        txtPart.setEditable(true);
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(txtVerFee) || e.getSource().equals(txtRegFee) || e.getSource().equals(txtPayor)
        		|| e.getSource().equals(txtPart) || e.getSource().equals(txtDeleteVector)) {
        	 	boolean allTextboxesHaveText = !txtVerFee.getText().isEmpty() &&
                     !txtRegFee.getText().isEmpty() &&
                     !txtPayor.getText().isEmpty() &&
                     !txtPart.getText().isEmpty();
        	 	btnProcess.setEnabled(allTextboxesHaveText);
        }
    }
    public void keyTyped(KeyEvent e) {
    }
    void display() {
    	txtAreaUp.setText("  TESDA AUDITING SYSTEM - By 2 // 3\n  De Castro, Justin Kyle\t\t\tVirtudazo, Stephanie Pearl");
    }
}