import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

public class PersonPanel extends JPanel {

    JButton backButton;

    PersonPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        // JLabel personLabel = new JLabel("This is the PersonPanel");
        // personLabel.setLocation(230, 120);
        // personLabel.setSize(250, 80);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTField = new JTextField();

        ageLabel.setLocation(100, 120);
        ageLabel.setSize(50, 40);
        add(ageLabel);

        ageTField.setLocation(150, 120);
        ageTField.setSize(100, 40);
        add(ageTField);

        Integer feet[] = { 4, 5, 6, 7 };
        Integer inches[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        JLabel heightLabel = new JLabel("Height:");
        JLabel feetLabel = new JLabel("ft");
        JLabel inchLabel = new JLabel("in");
        JComboBox<Integer> feetCombo = new JComboBox<>(feet);
        JComboBox<Integer> inchCombo = new JComboBox<>(inches);

        heightLabel.setLocation(100, 200);
        heightLabel.setSize(50, 40);
        add(heightLabel);

        feetCombo.setLocation(150, 200);
        feetCombo.setSize(60, 40);
        add(feetCombo);
        feetLabel.setLocation(210, 200);
        feetLabel.setSize(40, 40);
        add(feetLabel);

        inchCombo.setLocation(250, 200);
        inchCombo.setSize(70, 40);
        add(inchCombo);
        inchLabel.setLocation(320, 200);
        inchLabel.setSize(40, 40);
        add(inchLabel);

        JLabel weightLabel = new JLabel("Weight:");
        JTextField weightTFLabel = new JTextField();

        weightLabel.setLocation(100, 360);
        weightLabel.setSize(50, 40);
        add(weightLabel);

        weightTFLabel.setLocation(150, 360);
        weightTFLabel.setSize(100, 40);
        add(weightTFLabel);

        String activityLevelsOptions[] = { "low (1 workout / week)", "medium(2-3 workouts / week)",
                "high (4-5 workouts / week)", "extremely high (6+ workouts / week)" };
        JLabel actLevel = new JLabel("Activity Level:");
        JComboBox actCombo = new JComboBox(activityLevelsOptions);

        actLevel.setLocation(50, 440);
        actLevel.setSize(100, 40);
        add(actLevel);

        actCombo.setLocation(150, 440);
        actCombo.setSize(100, 40);
        add(actCombo);

        String goalsOptions[] = { "Gain", "Maintain", "Lose" };
        JLabel goalsLabel = new JLabel("Goals:");
        JComboBox goalsCombo = new JComboBox(goalsOptions);

        goalsLabel.setLocation(100, 520);
        goalsLabel.setSize(50, 40);
        add(goalsLabel);

        goalsCombo.setLocation(200, 520);
        goalsCombo.setSize(100, 40);
        add(goalsCombo);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);

        // add(personLabel);
        add(backButton);
        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
