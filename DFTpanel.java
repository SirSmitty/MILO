import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DFTpanel extends JPanel {
    JButton backButton;

    DFTpanel() {

        Apiconnect apiTest = new Apiconnect();

        setBackground(Color.WHITE);
        setLayout(null);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

        JButton aPIButton = new JButton("connect");
        aPIButton.setLocation(250, 50);
        aPIButton.setSize(90, 30);
        aPIButton.addActionListener((ActionEvent e) -> {
            apiTest.connectToApi();
        });
        add(aPIButton);

        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
