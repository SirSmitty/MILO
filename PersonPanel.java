import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PersonPanel extends JPanel {

    JButton backButton;

    PersonPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        JLabel personLabel = new JLabel("This is the PersonPanel");
        personLabel.setLocation(230, 120);
        personLabel.setSize(250, 80);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);

        add(personLabel);
        add(backButton);
        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
