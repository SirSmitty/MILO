import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DFTpanel extends JPanel {
    private JButton backButton;
    private int calorieSum = 0;
    private int proteinSum = 0;
    private int carbSum = 0;
    private int fatSum = 0;
    private Person activePerson;

    private boolean init = false;

    public DFTpanel() {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        backButton = new JButton("<-");
        backButton.setLocation(27, 600);
        backButton.setSize(50, 50);
        add(backButton);

        setVisible(true);
    }

    public void initialize(UserManager uManager) {

        init = true;

        activePerson = changePerson(uManager, 0);
        CalorieCalculator calculator = new CalorieCalculator();
        calculator.setPersonforCalc(activePerson);
        calculator.calculateMacros();

        Apiconnect api = new Apiconnect();
        DailyFoodTracker dft = new DailyFoodTracker();

        // Macro labels stuff
        JLabel totalCaloriesL = new JLabel(
                "Total Calories: " + activePerson.getCurrentCalories() + "/" + calculator.getCalories());
        totalCaloriesL.setLocation(270, 450);
        totalCaloriesL.setSize(150, 30);
        add(totalCaloriesL);

        JLabel totalCarbsL = new JLabel("Total Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
        totalCarbsL.setLocation(270, 480);
        totalCarbsL.setSize(150, 30);
        add(totalCarbsL);

        JLabel totalProteinL = new JLabel(
                "Total Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
        totalProteinL.setLocation(270, 510);
        totalProteinL.setSize(150, 30);
        add(totalProteinL);

        JLabel totalFatL = new JLabel("Total Fat: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
        totalFatL.setLocation(270, 540);
        totalFatL.setSize(150, 30);
        add(totalFatL);

        // Person changin stuff
        JComboBox<String> peopleBox = new JComboBox<>(uManager.getPeopleNames());
        peopleBox.setLocation(100, 50);
        peopleBox.setSize(120, 35);
        add(peopleBox);

        JButton changeButton = new JButton("Change Person");
        changeButton.setLocation(250, 50);
        changeButton.setSize(90, 30);
        changeButton.addActionListener((ActionEvent e) -> {

            activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
            calculator.setPersonforCalc(activePerson);
            calculator.calculateMacros();
            totalCaloriesL
                    .setText("Total Calories: " + activePerson.getCurrentCalories() + "/" + calculator.getCalories());
            totalProteinL.setText("Total Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
            totalCarbsL.setText("Total Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
            totalFatL.setText("Total Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());

        });
        add(changeButton);

        // add stuff

        JLabel addLabel = new JLabel("Type in food to add:");
        addLabel.setLocation(75, 160);
        addLabel.setSize(150, 40);
        add(addLabel);

        JTextField addingText = new JTextField();
        addingText.setLocation(100, 200);
        addingText.setSize(90, 30);
        add(addingText);

        JList list = new JList(); // data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(8);
        list.setLocation(50, 300);
        list.setSize(80, 80);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(list);
        add(listScroller);

        // ADD EXCEPTION FOR MISSPELLEDQUERIES
        JButton addButton = new JButton("Add Food");
        addButton.setLocation(100, 250);
        addButton.setSize(90, 30);
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
                        "Total Calories: " + activePerson.getCurrentCalories() + "/" + calculator.getCalories());
                totalProteinL
                        .setText("Total Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
                totalCarbsL.setText("Total Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
                totalFatL.setText("Total Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
            } catch (Exception addEx) {
                ErrorFrame addErrorFrame = new ErrorFrame("Invalid food item, please try again.");
                addErrorFrame.setVisible(true);
            }
        });
        add(addButton);

        // remove food

        JLabel removeLabel = new JLabel("Type in index of the list:");
        removeLabel.setLocation(300, 160);
        removeLabel.setSize(150, 40);
        add(removeLabel);

        JTextField removeText = new JTextField();
        removeText.setLocation(300, 200);
        removeText.setSize(90, 30);
        add(removeText);

        JButton removeButton = new JButton("Remove Item");
        removeButton.setLocation(300, 250);
        removeButton.setSize(90, 30);
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
                        .setText("Total Calories: " + activePerson.getCurrentCalories() + "/"
                                + calculator.getCalories());
                totalProteinL
                        .setText("Total Protein: " + activePerson.getCurrentProtein() + "/" + calculator.getProtein());
                totalCarbsL.setText("Total Carbs: " + activePerson.getCurrentCarbs() + "/" + calculator.getCarbs());
                totalFatL.setText("Total Fats: " + activePerson.getCurrentFats() + "/" + calculator.getFats());
            } catch (Exception removeExc) {
                ErrorFrame removeFrame = new ErrorFrame("Invalid index, please try again.");
                removeFrame.setVisible(true);
            }

        });
        add(removeButton);

        // creating listing of food items

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
}
