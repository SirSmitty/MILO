import java.awt.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.border.Border;

// implements ActionListener 
class TitlePanel extends JPanel {

    JButton personInput;
    JButton calorieTracker;
    JButton dailyIntake;
    JButton workoutPlan;

    public TitlePanel() {

        int buttonX = 25;
        int buttonY = 400;
        int buttonWidth = 200;
        int buttonHeight = 50;
        // SETS BACKGROUD OF PANEL TO GRAY AND SETS THE LAYOUT OF THE PANEL
        setBackground(Color.WHITE);
        setLayout(null);
        // miloLabel.setVisible(true);
        personInput = new JButton("Person Input");
        calorieTracker = new JButton("Calorie Tracker");
        dailyIntake = new JButton("Daily Food Intake");
        workoutPlan = new JButton("Workout Plan");
        dailyIntake.setLocation(buttonX, buttonY);
        dailyIntake.setSize(buttonWidth, buttonHeight);
        buttonY -= 75;
        personInput.setLocation(buttonX, buttonY);
        personInput.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        buttonX += 250;
        workoutPlan.setLocation(buttonX, buttonY);
        workoutPlan.setSize(buttonWidth, buttonHeight);
        buttonY -= 75;
        calorieTracker.setLocation(buttonX, buttonY);
        calorieTracker.setSize(buttonWidth, buttonHeight);

        add(personInput);
        add(calorieTracker);
        add(dailyIntake);
        add(workoutPlan);
        // end title panel creating frames

    }

    public JButton getPersonButton() {
        return personInput;
    }

    public JButton getCTButton() {
        return calorieTracker;
    }

    public JButton getDFTButton() {
        return dailyIntake;
    }

    public JButton getWPButton() {
        return workoutPlan;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("miloC.png");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 550, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);
    }
}
