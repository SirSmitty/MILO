import java.awt.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.border.Border;
import java.io.IOException;

// implements ActionListener 
class TitlePanel extends JPanel {

    JButton personInput;
    JButton calorieTracker;
    JButton dailyIntake;
    JButton workoutPlan;

    public TitlePanel() {

        try {
            // create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Objective-ExtraBoldSlanted.otf"))
                    .deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);

            int buttonX = 25;
            int buttonY = 400;
            int buttonWidth = 200;
            int buttonHeight = 50;
            // SETS BACKGROUD OF PANEL TO GRAY AND SETS THE LAYOUT OF THE PANEL
            setBackground(Color.WHITE);
            setLayout(null);
            // miloLabel.setVisible(true);
            personInput = new JButton("<html><span color=\"#D3605A\">Person Input</span></html>");
            personInput.setFont(customFont);
            calorieTracker = new JButton("<html><span color=\"#D3605A\">Calorie Tracker</span></html>");
            calorieTracker.setFont(customFont);
            dailyIntake = new JButton("<html><span color=\"#D3605A\">Daily Food Intake</span></html>");
            dailyIntake.setFont(customFont);
            workoutPlan = new JButton("<html><span color=\"#D3605A\">Workout Plan</span></html>");
            workoutPlan.setFont(customFont);
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

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
