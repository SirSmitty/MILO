import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class CTPanel extends JPanel {

    private Person activePerson;
    private JButton backButton;
    private MyPie pieGraph;

    public CTPanel(UserManager uManager) {

        setBackground(Color.WHITE);
        setLayout(null);
        CalorieCalculator calculator = new CalorieCalculator();

        // for testing
        activePerson = changePerson(uManager, 0);
        pieGraph = new MyPie(activePerson);

        calculator.setPersonforCalc(activePerson);
        calculator.calculateMacros();
        // calories label
        JLabel Calories = new JLabel("Daily Calorie count");
        Calories.setLocation(50, 150);
        Calories.setSize(150, 50);
        add(Calories);
        // calorie count label
        String calCount = Integer.toString(calculator.getCalories());
        JLabel calorieCountLabel = new JLabel(calCount);
        calorieCountLabel.setLocation(50, 170);
        calorieCountLabel.setSize(50, 50);
        add(calorieCountLabel);

        // Protein label
        JLabel Protein = new JLabel("Daily Protein intake");
        Protein.setLocation(50, 210);
        Protein.setSize(150, 50);
        add(Protein);
        // protein count label
        String proteinCount = Integer.toString(calculator.getProtein());
        JLabel proteinCountLabel = new JLabel(proteinCount);
        proteinCountLabel.setLocation(50, 230);
        proteinCountLabel.setSize(50, 50);
        add(proteinCountLabel);

        // carbs label
        JLabel Carbs = new JLabel("Daily Carbs intake");
        Carbs.setLocation(50, 270);
        Carbs.setSize(150, 50);
        add(Carbs);
        // carbs count label
        String carbsCount = Integer.toString(calculator.getCarbs());
        JLabel carbsCountLabel = new JLabel(carbsCount);
        carbsCountLabel.setLocation(50, 290);
        carbsCountLabel.setSize(50, 50);
        add(carbsCountLabel);

        // Fats label
        JLabel Fats = new JLabel("Daily Fat intake");
        Fats.setLocation(50, 330);
        Fats.setSize(150, 50);
        add(Fats);
        // fats count label
        String FatsCount = Integer.toString(calculator.getFats());
        JLabel fatsCountLabel = new JLabel(FatsCount);
        fatsCountLabel.setLocation(50, 350);
        fatsCountLabel.setSize(50, 50);
        add(fatsCountLabel);

        //people change stuff
        JComboBox<String> peopleBox = new JComboBox<>(uManager.getPeopleNames());
        peopleBox.setLocation(100, 50);
        peopleBox.setSize(120, 35);
        add(peopleBox);

        JButton changeButton = new JButton("Change Person");
        changeButton.setLocation(250, 50);
        changeButton.setSize(90, 30);
        changeButton.addActionListener((ActionEvent e) -> {
            activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
            changeLabels(activePerson, calculator, calorieCountLabel, proteinCountLabel, carbsCountLabel,
                    fatsCountLabel);
            pieGraph.changePerson(activePerson, calculator);
            repaint();
        });
        add(changeButton);

        backButton = new JButton("<-");
        backButton.setLocation(27, 600);
        backButton.setSize(50, 50);
        add(backButton);

        setVisible(true);

    }

    public void paintComponent(Graphics g) {
        pieGraph.drawPie((Graphics2D) g, new Rectangle(250, 375, 200, 200));
    }

    public JButton getBackButton() {
        return backButton;
    }

    public Person changePerson(UserManager um, int index) {
        return um.getPerson(index);

    }

    public void changeLabels(Person person, CalorieCalculator calculator, JLabel cLabel, JLabel pLabel,
            JLabel carbLabel, JLabel fLabel) {
                
        calculator.setPersonforCalc(person);
        calculator.calculateMacros();
        cLabel.setText(Integer.toString(calculator.getCalories()));
        pLabel.setText(Integer.toString(calculator.getProtein()));
        carbLabel.setText(Integer.toString(calculator.getCarbs()));
        fLabel.setText(Integer.toString(calculator.getFats()));
    }

}
