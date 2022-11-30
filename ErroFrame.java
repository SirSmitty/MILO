import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

class ErrorFrame extends JFrame {

    public ErrorFrame(String errorText) {

        setTitle("ERROR");
        setSize(350, 200);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel errorPanel = new JPanel();
        add(errorPanel);

        JLabel errorLabel = new JLabel(errorText);
        errorLabel.setLocation(100, 100);
        errorLabel.setSize(150, 20);
        errorLabel.setFont(new Font("Ariel", Font.BOLD, 30));
        errorPanel.add(errorLabel);

        JButton okButton = new JButton("Okay");
        okButton.setLocation(120, 150);
        okButton.setLocation(60, 30);
        okButton.addActionListener((ActionEvent e) -> {
            dispose();
        });
        errorPanel.add(okButton);

    }
}