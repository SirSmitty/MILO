import java.awt.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;

// implements ActionListener 
class TitlePanel extends JPanel {

    JButton personInput;
    JButton calorieTracker;
    JButton dailyIntake;
    JButton workoutPlan;

    public TitlePanel() {

        int buttonX = 50;
        int buttonY = 500;
        int buttonWidth = 200;
        int buttonHeight = 50;
        // SETS BACKGROUD OF PANEL TO GRAY AND SETS THE LAYOUT OF THE PANEL
        setBackground(Color.WHITE);
        setLayout(null);
        // miloLabel.setVisible(true);
        personInput = new JButton("personInput");
        calorieTracker = new JButton("calorietracker");
        dailyIntake = new JButton("dailyintake");
        workoutPlan = new JButton("workout plan");
        personInput.setLocation(buttonX, buttonY);
        personInput.setSize(buttonWidth, buttonHeight);
        buttonY -= 75;
        calorieTracker.setLocation(buttonX, buttonY);
        calorieTracker.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        buttonX += 300;
        dailyIntake.setLocation(buttonX, buttonY);
        dailyIntake.setSize(buttonWidth, buttonHeight);
        buttonY += 75;
        workoutPlan.setLocation(buttonX, buttonY);
        workoutPlan.setSize(buttonWidth, buttonHeight);

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
        ImageIcon background = new ImageIcon("milo.JPG");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);
    }
}
