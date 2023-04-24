package Prototype;

import CalculatorSingleton.CalorieCalculator;
import DailyFoodTrack.Apiconnect;
import DailyFoodTrack.DailyFoodTracker;
import DailyFoodTrack.FoodItem;
import PersonManagement.Person;
import PersonManagement.UserManager;
import PopUpFrames.ErrorFrame;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public abstract class DailyFoodPanel extends JPanel implements PanelPrototype_IF {

    private Person activePerson;
    private boolean init = false;
    // create panels here for daily food tracker
    private JButton backButton;

    public DailyFoodPanel() {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        backButton = new JButton("<-");
        backButton.setForeground(Color.WHITE);
        backButton.setLocation(27, 590);
        backButton.setSize(60, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);

        setVisible(true);
    }

    public void initialize(UserManager uManager) {
        
    init = true;
    try {
        // create the font to use. Specify the size!
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
        .deriveFont(18f);
        backButton.setFont(customFont);
        add(backButton);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // register the font
        ge.registerFont(customFont);

        activePerson = changePerson(uManager, 0);
        CalorieCalculator calculator = CalorieCalculator.getCalc();
        calculator.setPersonforCalc(activePerson);
        calculator.calculateMacros();

        Apiconnect api = new Apiconnect();
        DailyFoodTracker dft = new DailyFoodTracker();

        // Macro labels stuff
        JLabel totalCaloriesL = new JLabel(
                "Calories: " + activePerson.getCurrentCalories() + "/" + calculator.getCalories());
        totalCaloriesL.setLocation(250, 350);
        totalCaloriesL.setSize(200, 30);
        add(totalCaloriesL);
        totalCaloriesL.setFont(customFont);
        JLabel totalCarbsL = new JLabel(
                "Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
        totalCarbsL.setLocation(250, 380);
        totalCarbsL.setSize(200, 30);
        add(totalCarbsL);
        totalCarbsL.setFont(customFont);

        JLabel totalProteinL = new JLabel(
                "Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
        totalProteinL.setLocation(250, 410);
        totalProteinL.setSize(200, 30);
        add(totalProteinL);
        totalProteinL.setFont(customFont);

        JLabel totalFatL = new JLabel("Fat: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
        totalFatL.setLocation(250, 440);
        totalFatL.setSize(200, 30);
        add(totalFatL);
        totalFatL.setFont(customFont);

        // Person changin stuff
        JComboBox<String> peopleBox = new JComboBox<>(uManager.getPeopleNames());
        peopleBox.setLocation(50, 50);
        peopleBox.setSize(120, 35);
        peopleBox.setFont(customFont);
        add(peopleBox);

        JButton changeButton = new JButton("<html><span color=\"white\">Change</span></html>");
        changeButton.setFont(customFont);
        changeButton.setLocation(200, 50);
        changeButton.setSize(120, 35);
        changeButton.setBackground(new Color(211, 96, 90));
        changeButton.setOpaque(true);
        changeButton.setBorderPainted(false);
        changeButton.addActionListener((ActionEvent e) -> {
        activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
        calculator.setPersonforCalc(activePerson);
        activePerson.setCurCal(0);
        activePerson.setCurCarbs(0);
        activePerson.setCurProtein(0);
        activePerson.setCurFats(0);
        calculator.calculateMacros();
        totalCaloriesL
                .setText("Calories: " + activePerson.getCurrentCalories() + "/"
                        + calculator.getCalories());
        totalProteinL
                .setText("Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
        totalCarbsL.setText("Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
        totalFatL.setText("Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());

        });
        add(changeButton);

        // add stuff

        JLabel addLabel = new JLabel("Food to add:");
        addLabel.setLocation(50, 160);
        addLabel.setSize(200, 40);
        addLabel.setFont(customFont);
        add(addLabel);

        JTextField addingText = new JTextField();
        addingText.setLocation(50, 200);
        addingText.setSize(150, 30);
        addingText.setFont(customFont);
        add(addingText);

        JList list = new JList(); // data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(10);
        list.setLocation(50, 300);
        list.setSize(150, 225);
        list.setBackground(Color.lightGray);
        list.setFont(customFont);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(list);
        add(listScroller);

        // ADD EXCEPTION FOR MISSPELLEDQUERIES
        JButton addButton = new JButton("Add");
        addButton.setLocation(50, 250);
        addButton.setSize(150, 30);
        addButton.setFont(customFont);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(211, 96, 90));
        addButton.addActionListener((ActionEvent e) -> {

            try {

                String addString = addingText.getText();

                FoodItem fItem = api.getFoodItem(addString);

                dft.addFood(fItem);

                list.setListData(dft.getFoodNameList().toArray());
                activePerson.addToCalories(fItem.getCalories());
                activePerson.addToProtein(fItem.getProtein());
                activePerson.addToCarbs(fItem.getCarbs());
                activePerson.addToFats(fItem.getFats());
                totalCaloriesL.setText(
                        "Calories: " + activePerson.getCurrentCalories() + "/" + calculator.getCalories());
                totalProteinL
                        .setText("Protein: " + activePerson.getCurrentProtein() + "/"
                                + calculator.getProtein());
                totalCarbsL.setText("Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
                totalFatL.setText("Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
            } catch (Exception addEx) {
                ErrorFrame addErrorFrame = new ErrorFrame("Invalid food item, please try again.");
                addErrorFrame.setVisible(true);
            }
        });
        add(addButton);

        // remove food

        JLabel removeLabel = new JLabel("# to remove:");
        removeLabel.setLocation(250, 160);
        removeLabel.setSize(150, 40);
        removeLabel.setFont(customFont);
        add(removeLabel);

        JTextField removeText = new JTextField();
        removeText.setLocation(250, 200);
        removeText.setSize(150, 30);
        removeText.setFont(customFont);
        add(removeText);

        JButton removeButton = new JButton("Remove");
        removeButton.setLocation(250, 250);
        removeButton.setSize(150, 30);
        removeButton.setFont(customFont);
        removeButton.setForeground(Color.white);
        removeButton.setBackground(new Color(211, 96, 90));
        removeButton.setOpaque(true);
        removeButton.setBorderPainted(false);
        removeButton.addActionListener((ActionEvent e) -> {

            try {
                int removeInt = Integer.parseInt(removeText.getText());

                FoodItem fItem = dft.removeFood(removeInt);

                list.setListData(dft.getFoodNameList().toArray());

                activePerson.subFromCalories(fItem.getCalories());
                activePerson.subFromProtein(fItem.getProtein());
                activePerson.subFromCarbs(fItem.getCarbs());
                activePerson.subFromFats(fItem.getFats());
                totalCaloriesL
                        .setText("Calories: " + activePerson.getCurrentCalories() + "/"
                                + calculator.getCalories());
                totalProteinL
                        .setText("Protein: " + activePerson.getCurrentProtein() + "/"
                                + calculator.getProtein());
                totalCarbsL.setText("Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
                totalFatL.setText("Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
            } catch (Exception removeExc) {
                ErrorFrame removeFrame = new ErrorFrame("Range out of list, please try again.");
                removeFrame.setVisible(true);
            }

        });
        add(removeButton);
        // creating listing of food items
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }

    public Person changePerson(UserManager um, int index) {
        return um.getPerson(index);

    }

    public boolean getInit() {
        return init;
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
