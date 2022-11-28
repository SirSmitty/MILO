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

    DFTpanel(UserManager uManager) {

        Person person = uManager.getPerson(0);
        CalorieCalculator calculator = new CalorieCalculator();
        calculator.setPersonforCalc(person);
        calculator.calculateMacros();

        Apiconnect api = new Apiconnect();
        DailyFoodTracker dft = new DailyFoodTracker();

        setBackground(Color.WHITE);
        setLayout(null);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

        JLabel totalCaloriesL = new JLabel("Total Calories: " + calorieSum + "/" + calculator.getCalories());
        totalCaloriesL.setLocation(270, 450);
        totalCaloriesL.setSize(150, 30);
        add(totalCaloriesL);

        JLabel totalCarbsL = new JLabel("Total Carbs: " + carbSum + "/" + calculator.getCarbs());
        totalCarbsL.setLocation(270, 480);
        totalCarbsL.setSize(150, 30);
        add(totalCarbsL);

        JLabel totalProteinL = new JLabel("Total Protein: " + proteinSum + "/" + calculator.getProtein());
        totalProteinL.setLocation(270, 510);
        totalProteinL.setSize(150, 30);
        add(totalProteinL);

        JLabel totalFatL = new JLabel("Total Fat: " + fatSum + "/" + calculator.getFats());
        totalFatL.setLocation(270, 540);
        totalFatL.setSize(150, 30);
        add(totalFatL);

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

            String addString = addingText.getText();

            FoodItem fItem = api.getFoodItem(addString);

            dft.addFood(fItem);

            list.setListData(dft.getFoodNameList().toArray());
            calorieSum += fItem.getCalories();
            proteinSum += fItem.getProtein();
            carbSum += fItem.getCarbs();
            fatSum += fItem.getFats();
            totalCaloriesL.setText("Total Calories: " + calorieSum + "/" + calculator.getCalories());
            totalProteinL.setText("Total Protein: " + proteinSum + "/" + calculator.getProtein());
            totalCarbsL.setText("Total Carbs: " + carbSum + "/" + calculator.getCarbs());
            totalFatL.setText("Total Fats: " + fatSum + "/" + calculator.getFats());
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

            int removeInt = Integer.parseInt(removeText.getText());

            FoodItem fItem = dft.removeFood(removeInt);

            list.setListData(dft.getFoodNameList().toArray());
            calorieSum -= fItem.getCalories();
            proteinSum -= fItem.getProtein();
            carbSum -= fItem.getCarbs();
            fatSum -= fItem.getFats();
            totalCaloriesL.setText("Total Calories: " + calorieSum + "/" + calculator.getCalories());
            totalProteinL.setText("Total Protein: " + proteinSum + "/" + calculator.getProtein());
            totalCarbsL.setText("Total Carbs: " + carbSum + "/" + calculator.getCarbs());
            totalFatL.setText("Total Fats: " + fatSum + "/" + calculator.getFats());

        });
        add(removeButton);

        // creating listing of food items

        setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
