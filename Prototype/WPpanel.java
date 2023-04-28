package Prototype;
import javax.swing.JPanel;

import PersonManagement.UserManager;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class WPpanel extends CustomPanel{
    private boolean init = false;
    private JButton backButton;

    public WPpanel() {
        setBackground(Color.WHITE);
        setLayout(null);


        // sets up Back Button
        backButton = new JButton("<-");
        backButton.setLocation(27, 590);
        backButton.setSize(60, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        
    }
    
    public void initialize(UserManager uManager) {
        init = true;
        try{
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
            .deriveFont(18f);

            backButton.setFont(customFont);
            this.add(backButton);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e){
            e.printStackTrace();
        }
    }

    public JButton getBackButton() {
        return backButton;
    }

    public boolean getInit() {
        return init;
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
