import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class WPpanel extends JPanel {
    JButton backButton;

    WPpanel() {
        setBackground(Color.WHITE);
        setLayout(null);

        Schedule schedule = new Schedule();

        // sets up Back Button
        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

    }

    public JButton getBackButton() {
        return backButton;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);
    }
}
