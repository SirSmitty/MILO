import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// implements ActionListener 
class TitlePanel extends JPanel {
    public TitlePanel() {

        int buttonX = 150;
        int buttonY = 275;
        int buttonWidth = 200;
        int buttonHeight = 50;
        // SETS BACKGROUD OF PANEL TO GRAY AND SETS THE LAYOUT OF THE PANEL
        setBackground(Color.WHITE);
        setLayout(null);
        JLabel miloLabel = new JLabel("MILO");
        miloLabel.setLocation(230, 120);
        miloLabel.setSize(250, 80);
        // miloLabel.setVisible(true);
        JButton personInput = new JButton("personInput");
        JButton calorieTracker = new JButton("calorietracker");
        JButton dailyIntake = new JButton("dailyintake");
        JButton workoutPlan = new JButton("workout plan");
        personInput.setLocation(buttonX, buttonY);
        personInput.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        calorieTracker.setLocation(buttonX, buttonY);
        calorieTracker.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        dailyIntake.setLocation(buttonX, buttonY);
        dailyIntake.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        workoutPlan.setLocation(buttonX, buttonY);
        workoutPlan.setSize(buttonWidth, buttonHeight);

        add(miloLabel);

        add(personInput);
        add(calorieTracker);
        add(dailyIntake);
        add(workoutPlan);
        // end title panel creating frames
        JFrame topFrame = (JFrame) SwingUtilities.getUnwrappedParent(this);

    }
}
