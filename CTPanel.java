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

    }

    public void calculateCalories(Person test) {
        int calories = (int) ((10 * test.getWeight()) + (6.25 * test.getCmHeight()) - (5 * test.getAge()) - 161);
        test.setCalories(calories);
    }

    public void calculateProtein(Person test) {
        int protein = (int) (.4 * test.getCalories());

    }

    public JButton getBackButton() {
        return backButton;
    }

}
