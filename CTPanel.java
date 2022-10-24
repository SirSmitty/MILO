import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CTPanel extends JPanel {

    JButton backButton;
    MyPie pieGraph;

    CTPanel(Vector<Person> p) {
        setBackground(Color.WHITE);
        setLayout(null);
        Person test = p.get(0);
        // Graphics g = new Graphics();
        // pieGraph = new MyPie(test);

        // pieGraph.drawPie(Graphics g, new Rectangle(150, 200, 200, 200));
        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

        setVisible(true);

        // calories label
        JLabel Calories = new JLabel("Daily Calorie count");
        Calories.setLocation(100, 200);
        Calories.setSize(150, 50);
        add(Calories);
        // calorie count label
        String calCount = Integer.toString(test.getCalories());
        JLabel calorieCountLabel = new JLabel(calCount);
        calorieCountLabel.setLocation(100, 190);
        calorieCountLabel.setSize(50, 100);
        add(calorieCountLabel);

        // Protein label
        JLabel Protein = new JLabel("Daily Protein intake");
        Protein.setLocation(100, 260);
        Protein.setSize(150, 50);
        add(Protein);
        // protein count label
        String proteinCount = Integer.toString(test.getProtein());
        JLabel proteinCountLabel = new JLabel(proteinCount);
        proteinCountLabel.setLocation(100, 250);
        proteinCountLabel.setSize(50, 100);
        add(proteinCountLabel);

        // carbs label
        JLabel Carbs = new JLabel("Daily Carbs intake");
        Carbs.setLocation(100, 320);
        Carbs.setSize(150, 50);
        add(Carbs);
        // carbs count label
        String carbsCount = Integer.toString(test.getCarbs());
        JLabel carbsCountLabel = new JLabel(carbsCount);
        carbsCountLabel.setLocation(100, 310);
        carbsCountLabel.setSize(50, 100);
        add(carbsCountLabel);

        // Fats label
        JLabel Fats = new JLabel("Daily Fat intake");
        Fats.setLocation(100, 380);
        Fats.setSize(150, 50);
        add(Fats);
        // fats count label
        String FatsCount = Integer.toString(test.getFats());
        JLabel fatsCountLabel = new JLabel(FatsCount);
        fatsCountLabel.setLocation(100, 370);
        fatsCountLabel.setSize(50, 100);
        add(fatsCountLabel);

        // test.getProtein();
        // test.getCarbs();
        // test.calculateFats();

    }

    public JButton getBackButton() {
        return backButton;
    }

}
