import javax.swing.*;

import org.json.CookieList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

class ErrorFrame extends JFrame {

    public ErrorFrame(String errorText) {

        setTitle("ERROR");
        setSize(400, 100);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel errorPanel = new JPanel();
        errorPanel.setBackground(Color.BLACK);
        add(errorPanel);

        JLabel errorLabel = new JLabel("<html><span bgcolor=\"red\">" + errorText + "</span></html>");
        errorLabel.setLocation(0, 0);
        errorLabel.setSize(100, 100);
        errorLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        errorPanel.add(errorLabel);

        JButton okButton = new JButton("Go Back");
        okButton.setLocation(120, 150);
        okButton.setLocation(60, 30);
        okButton.addActionListener((ActionEvent e) -> {
            dispose();
        });
        errorPanel.add(okButton);

    }
}