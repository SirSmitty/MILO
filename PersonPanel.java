import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PersonPanel extends JPanel {
    PersonPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        JLabel personLabel = new JLabel("TEST TEST TEWST");
        personLabel.setLocation(230, 120);
        personLabel.setSize(250, 80);
        add(personLabel);
        setVisible(false);
    }

}
