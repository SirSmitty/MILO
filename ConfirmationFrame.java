import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

class ConfirmationFrame extends JFrame {

    public ConfirmationFrame(String confirmText) {

        setTitle("CONFIRMED");
        setSize(400, 100);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel confirmPanel = new JPanel();
        confirmPanel.setBackground(Color.WHITE);
        add(confirmPanel);

        JLabel confirmLabel = new JLabel(confirmText);
        confirmLabel.setLocation(0, 20);
        confirmLabel.setSize(100, 100);
        confirmLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        confirmPanel.add(confirmLabel);

        JButton okButton = new JButton("Thank you");
        okButton.setLocation(120, 150);
        okButton.setLocation(60, 30);
        okButton.addActionListener((ActionEvent e) -> {
            dispose();
        });
        confirmPanel.add(okButton);

    }
}