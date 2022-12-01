import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;

public class PersonPanel extends JPanel {

    JButton backButton;
    private Timer timerLabel;

    public PersonPanel(UserManager uManager) {
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTField = new JTextField();

        // Age Label
        nameLabel.setLocation(105, 70);
        nameLabel.setSize(50, 40);
        add(nameLabel);

        // Age Text Field
        nameTField.setLocation(150, 70);
        nameTField.setSize(100, 40);
        add(nameTField);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTField = new JTextField();

        // Age Label
        ageLabel.setLocation(105, 120);
        ageLabel.setSize(50, 40);
        add(ageLabel);

        // Age Text Field
        ageTField.setLocation(135, 120);
        ageTField.setSize(100, 40);
        add(ageTField);

        // logic for calculating ft/inches
        Integer feet[] = { 4, 5, 6, 7 };
        Integer inches[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        JLabel heightLabel = new JLabel("Height:");
        JLabel feetLabel = new JLabel("ft");
        JLabel inchLabel = new JLabel("in");
        JComboBox<Integer> feetCombo = new JComboBox<>(feet);
        JComboBox<Integer> inchCombo = new JComboBox<>(inches);

        // Height Label
        heightLabel.setLocation(92, 200);
        heightLabel.setSize(50, 40);
        add(heightLabel);

        // Feet drop down
        feetCombo.setLocation(145, 200);
        feetCombo.setSize(60, 40);
        add(feetCombo);
        // Feet Label
        feetLabel.setLocation(205, 200);
        feetLabel.setSize(40, 40);
        add(feetLabel);

        // Inch drop combo
        inchCombo.setLocation(245, 200);
        inchCombo.setSize(70, 40);
        add(inchCombo);
        // Inch
        inchLabel.setLocation(315, 200);
        inchLabel.setSize(40, 40);
        add(inchLabel);

        // Weight label
        JLabel weightLabel = new JLabel("Weight:");
        JTextField weightTFLabel = new JTextField();

        // Weight Label
        weightLabel.setLocation(90, 280);
        weightLabel.setSize(50, 40);
        add(weightLabel);

        // Weight TF Label
        weightTFLabel.setLocation(140, 280);
        weightTFLabel.setSize(100, 40);
        add(weightTFLabel);

        String activityLevelsOptions[] = { "Low (1 workout / week)", "Medium(2-3 workouts / week)",
                "High (4-5 workouts / week)", "Extremely High (6+ workouts / week)" };
        JLabel actLevel = new JLabel("Activity Level:");
        JComboBox actCombo = new JComboBox(activityLevelsOptions);

        // ActivityLabelDrop
        actLevel.setLocation(50, 360);
        actLevel.setSize(100, 40);
        add(actLevel);

        // Activity Level Label
        actCombo.setLocation(150, 360);
        actCombo.setSize(100, 40);
        add(actCombo);

        String goalsOptions[] = { "Gain", "Maintain", "Lose" };
        JLabel goalsLabel = new JLabel("Goals:");
        JComboBox goalsCombo = new JComboBox(goalsOptions);

        // Goals Label
        goalsLabel.setLocation(100, 420);
        goalsLabel.setSize(50, 40);
        add(goalsLabel);

        // Goals Combo
        goalsCombo.setLocation(150, 420);
        goalsCombo.setSize(100, 40);
        add(goalsCombo);

        // back button
        backButton = new JButton("<-");
        backButton.setLocation(27, 600);
        backButton.setSize(50, 50);
        add(backButton);

        // submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setLocation(130, 500);
        submitButton.setSize(120, 50);
        add(submitButton);

        // add new person
        submitButton.addActionListener((ActionEvent e) -> {

            try {
                String personName = nameTField.getText();
                int personAge = Integer.parseInt(ageTField.getText());
                int personHeightFeet = feet[feetCombo.getSelectedIndex()];
                int personHeightInches = inches[inchCombo.getSelectedIndex()];
                int personWeight = Integer.parseInt(weightTFLabel.getText());
                String personActivityLevel = activityLevelsOptions[actCombo.getSelectedIndex()];
                String personGoals = goalsOptions[goalsCombo.getSelectedIndex()];

                Person newPerson = new Person(personName, personAge, personHeightFeet, personHeightInches,
                        personWeight,
                        personActivityLevel, personGoals);

                uManager.addPerson(newPerson);

            } catch (Exception exc) {

                ErrorFrame personError = new ErrorFrame("Please fill out all the information");
                personError.setVisible(true);

            }
        });

        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
