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
        setBackground(Color.WHITE);
        setLayout(null);
        // Graphics g = new Graphics();
        // pieGraph = new MyPie(test);

        // pieGraph.drawPie(Graphics g, new Rectangle(150, 200, 200, 200));
        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
