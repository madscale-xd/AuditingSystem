import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;

public class testtest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text to Notepad");
        JTextArea textArea = new JTextArea();
        JButton saveButton = new JButton("Save to Notepad");
        JButton clearButton = new JButton("Clear Text");

        ActionListener buttonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButton) {
                    // Code to save text to a file
                    JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                            writer.write(textArea.getText());
                            JOptionPane.showMessageDialog(frame, "Text saved to " + file.getName());
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Error saving the text: " + ex.getMessage());
                        }
                    }
                } else if (e.getSource() == clearButton) {
                    // Code to clear the text area
                    textArea.setText("");
                }
            }
        };

        saveButton.addActionListener(buttonActionListener);
        clearButton.addActionListener(buttonActionListener);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
