package Prototype;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public abstract class WorkoutPanel extends JPanel implements PanelPrototype_IF {

    private JButton backButton;

    // create panels here for workout
    public WorkoutPanel() {
        setBackground(Color.WHITE);
        setLayout(null);

        // sets up Back Button
        backButton = new JButton("<-");
        backButton.setLocation(27, 590);
        backButton.setSize(60, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);

        setVisible(true);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
