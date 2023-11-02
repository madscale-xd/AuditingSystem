import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AuditingSystem extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JLabel lblChoose, lblNTSSP, lblVerFee, lblRegFee, lblPayor, lblPart;
    private JTextField txtVerFee, txtRegFee, txtPayor, txtPart;
    private JComboBox cboChoose, NTSSP;
    private JTextArea txtAreaUp, txtAreaDown;
    private JButton btnProcess, btnClose;
    private Year yr2023;
    String hold = "", traversal = "";

    AuditingSystem() {
        yr2023 = new Year(); // Instantiation of a tree
        lblChoose = new JLabel("Choose");
        String menu[] = { "Add Receipt", "Delete Receipt", "Show Monthly Report", "Show Yearly Report", "End"};
        String menu2[] = {"National Treasury", "Sariling Sikap Program"};
        cboChoose = new JComboBox(menu);
        NTSSP = new JComboBox(menu2);
        txtAreaUp = new JTextArea();
        txtAreaDown = new JTextArea();
        btnProcess = new JButton("Process");
        btnClose = new JButton("Close");
        lblNTSSP = new JLabel("Division");
        lblVerFee = new JLabel("Verification Fee");
        lblRegFee = new JLabel("Registration Fee");
        lblPayor = new JLabel("Payor");
        lblPart = new JLabel("Particulars");
        txtVerFee = new JTextField();
        txtRegFee = new JTextField();
        txtPayor = new JTextField();
        txtPart = new JTextField();
        setTitle("TESDA NT and SSP Auditing System");
        setSize(1280, 720);
        getContentPane().setBackground(new Color(100, 50, 90, 80));
        setLayout(null);
        txtAreaUp.setEditable(false);
        txtAreaDown.setEditable(false);
        display();
        add(txtAreaUp).setBounds(20, 20, 1220, 40);
        add(new JScrollPane(txtAreaDown)).setBounds(20, 70, 1220, 420);
        add(lblChoose).setBounds(360, 530, 60, 20);
        add(cboChoose).setBounds(360, 560, 150, 20);
        add(btnProcess).setBounds(540, 505, 200, 120);
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
        cboChoose.addItemListener(this);
        txtVerFee.addKeyListener(this);
        txtRegFee.addKeyListener(this);
        txtPayor.addKeyListener(this);
        txtPart.addKeyListener(this);
        btnProcess.setEnabled(false);
    }

    public static void main(String[] args) {
        new AuditingSystem();
    }
    public void actionPerformed(ActionEvent e) {
        int i = cboChoose.getSelectedIndex();
        int j = NTSSP.getSelectedIndex();
        if (i == 0) {
        } else if (i == 1) {
        } else if (i == 2) {
        } else if (i == 3) {
        } else if (i == 4) {
            System.exit(0);
        }
        display();
        btnProcess.setEnabled(false);
    }

    public void itemStateChanged(ItemEvent e) {
        int i = cboChoose.getSelectedIndex();
        if (i == 0) {
            disable();
        } else if (i == 1) {
            disableAll();
            btnProcess.setEnabled(true);
        } else if (i == 2) {
            disable();
            btnProcess.setEnabled(true);
        } else if (i == 3) {
            disableAll();
            btnProcess.setEnabled(true);
        } else if (i == 4) {
            // disableAll();
            txtVerFee.setText("0");
            txtVerFee.setEditable(false);
            btnProcess.setEnabled(true);
        }
    }

    public void enable() {
        txtVerFee.setEditable(true);
    }

    public void disable() {
        txtVerFee.setEditable(true);
    }

    public void disableAll() {
        txtVerFee.setEditable(false);
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(txtVerFee)) {
            if (txtVerFee.getText().isEmpty()) {
                btnProcess.setEnabled(false);
            } else {
                btnProcess.setEnabled(true);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    void display() {
    	txtAreaUp.setText("TESDA AUDITING SYSTEM");
    }
}
