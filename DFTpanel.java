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
    JButton backButton;

    DFTpanel() {

        Apiconnect api = new Apiconnect();
        DailyFoodTracker dft = new DailyFoodTracker();

        setBackground(Color.WHITE);
        setLayout(null);

        backButton = new JButton("<-");
        backButton.setLocation(50, 600);
        backButton.setSize(50, 50);
        add(backButton);

        JButton addButton = new JButton("Add Food");
        addButton.setLocation(250, 50);
        addButton.setSize(90, 30);
        addButton.addActionListener((ActionEvent e) -> {
            //test with chicken
            FoodItem fItem = api.getFoodItem("chicken");

            dft.addFood(fItem);

        });
        add(addButton);
        
        // JButton removeButton = new JButton("Remove Food");
        // removeButton.setLocation(250, 50);
        // removeButton.setSize(90, 30);
        // removeButton.addActionListener((ActionEvent e) -> {
        //     //test with chicken
        //     FoodItem fItem = api.getFoodItem("chicken");

        //     dft.removeFood(fItem);

        // });
        // add(removeButton);

        setVisible(true);
    }

    public JButton getBackButton(){
        return backButton;
    }
}
