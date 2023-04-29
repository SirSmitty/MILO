package Decorator;

//similar to RedShapeDecorator

import javax.swing.JPanel;

import CalculatorSingleton.MyPie;

import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

//call the functions of DFTPanel, CT, etc through basepanel
public class BasePanel extends JPanel implements Panel_IF {

    private JButton backButton;
    private Font customFont;
    private MyPie pieGraph = null;


    // panels that are copied

    public BasePanel() {
        initialize();
    }

    public void initialize(){
        try {
            // create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Objective-ExtraBoldSlanted.otf"))
                    .deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        backButton = new JButton("<-");
        backButton.setForeground(Color.WHITE);
        backButton.setLocation(27, 490);
        backButton.setSize(60, 50);
        backButton.setBackground(new Color(211, 96, 90));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);

        add(backButton);
        setVisible(true);
    }

    public boolean getInit(){return true;}

    public Font getCustomFont(){
        return customFont;
    }

    public void setPieGraph(MyPie p){
        pieGraph = p;
    }

   
    // background and sizing 700x700
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);

        if(pieGraph != null){
            pieGraph.drawPie((Graphics2D) g, new Rectangle(250, 200, 200, 200));
        }


    }

    // getfunction for back button
    public JButton getBackButton() {
        return backButton;
    }
}