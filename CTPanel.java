import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.border.Border;
import java.io.IOException;

public class CTPanel extends JPanel {

    private Person activePerson;
    private JButton backButton;
    private MyPie pieGraph;
    private boolean init = false;

    public CTPanel() {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        backButton = new JButton("<html><span color=\"white\"></span></html>");
        backButton.setLocation(27, 600);
        backButton.setSize(50, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        add(backButton);

        setVisible(true);
    }

    public void initialize(UserManager uManager) {

        init = true;
        try {
            // create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
                    .deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);

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
            Calories.setFont(customFont);
            add(Calories);
            // calorie count label
            String calCount = Integer.toString(calculator.getCalories());
            JLabel calorieCountLabel = new JLabel(calCount);
            calorieCountLabel.setLocation(50, 170);
            calorieCountLabel.setSize(50, 50);
            calorieCountLabel.setFont(customFont);
            this.add(calorieCountLabel);

            // Protein label
            JLabel Protein = new JLabel("Daily Protein intake");
            Protein.setLocation(50, 210);
            Protein.setSize(150, 50);
            Protein.setFont(customFont);
            this.add(Protein);
            // protein count label
            String proteinCount = Integer.toString(calculator.getProtein());
            JLabel proteinCountLabel = new JLabel(proteinCount);
            proteinCountLabel.setLocation(50, 230);
            proteinCountLabel.setSize(50, 50);
            proteinCountLabel.setFont(customFont);
            this.add(proteinCountLabel);

            // carbs label
            JLabel Carbs = new JLabel("Daily Carbs intake");
            Carbs.setLocation(50, 270);
            Carbs.setSize(150, 50);
            Carbs.setFont(customFont);
            this.add(Carbs);
            // carbs count label
            String carbsCount = Integer.toString(calculator.getCarbs());
            JLabel carbsCountLabel = new JLabel(carbsCount);
            carbsCountLabel.setLocation(50, 290);
            carbsCountLabel.setSize(50, 50);
            carbsCountLabel.setFont(customFont);
            this.add(carbsCountLabel);

            // Fats label
            JLabel Fats = new JLabel("Daily Fat intake");
            Fats.setLocation(50, 330);
            Fats.setSize(150, 50);
            Fats.setFont(customFont);
            this.add(Fats);
            // fats count label
            String FatsCount = Integer.toString(calculator.getFats());
            JLabel fatsCountLabel = new JLabel(FatsCount);
            fatsCountLabel.setLocation(50, 350);
            fatsCountLabel.setSize(50, 50);
            fatsCountLabel.setFont(customFont);
            this.add(fatsCountLabel);

            // people change stuff
            JComboBox<String> peopleBox = new JComboBox<>(uManager.getPeopleNames());
            peopleBox.setLocation(100, 50);
            peopleBox.setSize(120, 35);
            peopleBox.setFont(customFont);
            this.add(peopleBox);

            JButton changeButton = new JButton("Change Person");
            changeButton.setLocation(250, 50);
            changeButton.setSize(90, 30);
            changeButton.setFont(customFont);
            changeButton.addActionListener((ActionEvent e) -> {
                activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
                changeLabels(activePerson, calculator, calorieCountLabel, proteinCountLabel, carbsCountLabel,
                        fatsCountLabel);
                pieGraph.changePerson(activePerson, calculator);
                this.repaint();
            });
            this.add(changeButton);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);

        pieGraph.drawPie((Graphics2D) g, new Rectangle(250, 200, 200, 200));
    }

    public JButton getBackButton() {
        return backButton;
    }

    public Person changePerson(UserManager um, int index) {
        return um.getPerson(index);

    }

    public boolean getInit() {
        return init;
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
