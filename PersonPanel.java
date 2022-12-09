import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.File;

public class PersonPanel extends JPanel {

    JButton backButton;

    public PersonPanel(UserManager uManager) {

        try {

            // create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
                    .deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);
            setBackground(Color.WHITE);
            setLayout(null);

            JLabel nameLabel = new JLabel("Name:");
            JTextField nameTField = new JTextField();

            // Name Label
            nameLabel.setLocation(50, 70);
            nameLabel.setSize(70, 40);
            nameLabel.setFont(customFont);
            add(nameLabel);

            // Name Text Field
            nameTField.setLocation(150, 70);
            nameTField.setSize(200, 40);
            nameTField.setFont(customFont);
            add(nameTField);

            JLabel ageLabel = new JLabel("Age:");
            JTextField ageTField = new JTextField();
            ageLabel.setFont(customFont);
            ageTField.setFont(customFont);

            // Age Label
            ageLabel.setLocation(50, 120);
            ageLabel.setSize(50, 40);
            ageLabel.setFont(customFont);
            add(ageLabel);

            // Age Text Field
            ageTField.setLocation(150, 120);
            ageTField.setSize(100, 40);
            ageTField.setFont(customFont);
            add(ageTField);

            // Weight label
            JLabel weightLabel = new JLabel("Weight:");
            JTextField weightTFLabel = new JTextField();

            // Weight Label
            weightLabel.setLocation(50, 170);
            weightLabel.setSize(100, 40);
            weightLabel.setFont(customFont);
            add(weightLabel);

            // Weight TF Label
            weightTFLabel.setLocation(150, 170);// weight text field is 280
            weightTFLabel.setSize(100, 40);
            weightTFLabel.setFont(customFont);
            add(weightTFLabel);

            // logic for calculating ft/inches
            Integer feet[] = { 4, 5, 6, 7 };
            Integer inches[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
            JLabel heightLabel = new JLabel("Height:");
            JLabel feetLabel = new JLabel("ft");
            JLabel inchLabel = new JLabel("in");
            JComboBox<Integer> feetCombo = new JComboBox<>(feet);
            JComboBox<Integer> inchCombo = new JComboBox<>(inches);

            // Height Label
            heightLabel.setLocation(50, 220);
            heightLabel.setSize(70, 40);
            heightLabel.setFont(customFont);
            add(heightLabel);

            // Feet drop down
            feetCombo.setLocation(150, 220);
            feetCombo.setSize(80, 45);
            feetCombo.setFont(customFont);
            add(feetCombo);
            // Feet Label
            feetLabel.setLocation(230, 220);
            feetLabel.setSize(40, 40);
            feetLabel.setFont(customFont);
            add(feetLabel);

            // Inch drop combo
            inchCombo.setLocation(290, 220);
            inchCombo.setSize(80, 45);
            inchCombo.setFont(customFont);
            add(inchCombo);
            // Inch
            inchLabel.setLocation(370, 220);
            inchLabel.setSize(40, 40);
            inchLabel.setFont(customFont);
            add(inchLabel);

            String activityLevelsOptions[] = { "Low (1 workout / week)", "Medium(2-3 workouts / week)",
                    "High (4-5 workouts / week)", "Extremely High (6+ workouts / week)" };
            JLabel actLevel = new JLabel("Activity:");
            JComboBox actCombo = new JComboBox(activityLevelsOptions);

            // Activity Label Label
            actLevel.setLocation(50, 270);
            actLevel.setSize(100, 40);
            actLevel.setFont(customFont);
            add(actLevel);

            // Activity Level Drop
            actCombo.setLocation(150, 270);
            actCombo.setSize(300, 45);
            actCombo.setFont(customFont);
            add(actCombo);

            String goalsOptions[] = { "Gain", "Maintain", "Lose" };
            JLabel goalsLabel = new JLabel("Goals:");
            JComboBox goalsCombo = new JComboBox(goalsOptions);

            // Goals Label
            goalsLabel.setLocation(50, 320);
            goalsLabel.setSize(70, 40);
            goalsLabel.setFont(customFont);
            add(goalsLabel);

            // Goals Combo
            goalsCombo.setLocation(150, 320);
            goalsCombo.setSize(150, 45);
            goalsCombo.setFont(customFont);
            add(goalsCombo);

            // back button
            backButton = new JButton("<-");
            backButton.setFont(customFont);
            backButton.setForeground(Color.WHITE);
            backButton.setLocation(27, 460);
            backButton.setSize(60, 50);
            backButton.setBackground(new Color(211, 96, 90));
            backButton.setOpaque(true);
            backButton.setBorderPainted(false);
            add(backButton);

            // submit button
            JButton submitButton = new JButton("<html><span color=\"white\">Submit</span></html>");
            submitButton.setBackground(new Color(211, 96, 90));
            submitButton.setOpaque(true);
            submitButton.setBorderPainted(false);
            submitButton.setLocation(150, 380);
            submitButton.setSize(160, 50);
            submitButton.setFont(customFont);
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

                    ConfirmationFrame confirmed = new ConfirmationFrame("Person succesfully added");
                    confirmed.setVisible(true);

                } catch (Exception exc) {

                    ErrorFrame personError = new ErrorFrame("Please fill out all the information");
                    personError.setVisible(true);

                }
            });

            setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }

    public JButton getBackButton() {
        return backButton;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);
    }
}
