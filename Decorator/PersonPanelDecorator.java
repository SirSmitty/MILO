package Decorator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;


public class PersonPanelDecorator{



    public PersonPanelDecorator() {}

    public JLabel createNameLabel(Font customFont){
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setLocation(50, 70);
        nameLabel.setSize(70, 40);
        nameLabel.setFont(customFont);
        return nameLabel;
    }

    public JTextField createNameField(Font customFont){
        JTextField nameTField = new JTextField();
        nameTField.setLocation(150, 70);
        nameTField.setSize(200, 40);
        nameTField.setFont(customFont);
        return nameTField;
    }

    public JLabel createAgeLabel(Font customFont){
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(customFont);
        ageLabel.setLocation(50, 120);
        ageLabel.setSize(50, 40);
        ageLabel.setFont(customFont);
        return ageLabel;
    }

    public JTextField createAgeField(Font customFont){
        JTextField ageTField = new JTextField();
        ageTField.setFont(customFont);
        ageTField.setLocation(150, 120);
        ageTField.setSize(100, 40);
        ageTField.setFont(customFont);
        return ageTField;
    }

    public JLabel createWeightLabel(Font customFont){
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setLocation(50, 170);
        weightLabel.setSize(100, 40);
        weightLabel.setFont(customFont);
        return weightLabel;
    }

    public JTextField createWeightField(Font customFont){
        JTextField weightTField = new JTextField();
        weightTField.setLocation(150, 170);
        weightTField.setSize(100, 40);
        weightTField.setFont(customFont);
        return weightTField;
    }

    public JLabel createHeightLabel(Font customFont){
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setLocation(50, 220);
        heightLabel.setSize(70, 40);
        heightLabel.setFont(customFont);
        return heightLabel;
    }

    public JComboBox<Integer> createFeetCombo(Font customFont, Integer feet[]){
        JComboBox<Integer> feetCombo = new JComboBox<>(feet);
        feetCombo.setLocation(150, 220);
        feetCombo.setSize(80, 45);
        feetCombo.setFont(customFont);
        return feetCombo;
    }

    public JLabel createFeetLabel(Font customFont){
        JLabel feetLabel = new JLabel("ft");
        feetLabel.setLocation(230, 220);
        feetLabel.setSize(40, 40);
        feetLabel.setFont(customFont);
        return feetLabel;
    }

    public JComboBox<Integer> createInchCombo(Font customFont, Integer inches[]){
        JComboBox<Integer> inchCombo = new JComboBox<>(inches);
        inchCombo.setLocation(290, 220);
        inchCombo.setSize(80, 45);
        inchCombo.setFont(customFont);
        return inchCombo;
    }

    public JLabel createInchLabel(Font customFont){
        JLabel inchLabel = new JLabel("in");
        inchLabel.setLocation(370, 220);
        inchLabel.setSize(40, 40);
        inchLabel.setFont(customFont);
        return inchLabel;
    }

    public JLabel createActivityLabel(Font customFont){
        JLabel actLevel = new JLabel("Activity:");
        actLevel.setLocation(50, 270);
        actLevel.setSize(100, 40);
        actLevel.setFont(customFont);
        return actLevel;
    }

    public JComboBox<String> createActivityCombo(Font customFont, String activityLevelsOptions[]){
        JComboBox actCombo = new JComboBox(activityLevelsOptions);
        actCombo.setLocation(150, 270);
        actCombo.setSize(300, 45);
        actCombo.setFont(customFont);
        return actCombo;
    }

    public JLabel createGoalsLabel(Font customFont){
        JLabel goalsLabel = new JLabel("Goals:");
        goalsLabel.setLocation(50, 320);
        goalsLabel.setSize(70, 40);
        goalsLabel.setFont(customFont);
        return goalsLabel;
    }

    public JComboBox<String> createGoalsCombo(Font customFont, String goalsOptions[]){
        JComboBox goalsCombo = new JComboBox(goalsOptions);
        goalsCombo.setLocation(150, 320);
        goalsCombo.setSize(150, 45);
        goalsCombo.setFont(customFont);
        return goalsCombo;
    }

    public JButton createSubmitButton(Font customFont){
        JButton submitButton = new JButton("<html><span color=\"white\">Submit</span></html>");
        submitButton.setBackground(new Color(211, 96, 90));
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setLocation(150, 380);
        submitButton.setSize(160, 50);
        submitButton.setFont(customFont);
        return submitButton;
    }


}
