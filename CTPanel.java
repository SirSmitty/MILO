import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CTPanel extends JPanel {

    JButton backButton;

    CTPanel(Vector<Person> p) {

        Person test = p.get(0);

        test.calculateCalories();
        test.calculateProtein();
        test.calculateCarbs();
        test.calculateFats();

        setBackground(Color.WHITE);
        setLayout(null);

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
