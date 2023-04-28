package Prototype;

//similar to RedShapeDecorator

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

//call the functions of DFTPanel, CT, etc through basepanel
public class BasePanel extends JPanel implements Panel_IF {

    private JButton backButton;

    // panels that are copied

    public BasePanel() {
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

    // public BasePanel() {
    // this.setBackground(Color.WHITE);
    // this.setLayout(null);

    // backButton = new JButton("<-");
    // backButton.setForeground(Color.WHITE);
    // backButton.setLocation(27, 490);
    // backButton.setSize(60, 50);
    // backButton.setBackground(new Color(211, 96, 90));
    // backButton.setOpaque(true);
    // backButton.setBorderPainted(false);

    // add(backButton);

    // setVisible(true);
    // }

    // background and sizing 700x700
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        Image backgroundImage = background.getImage(); // transform it
        Image backgroundResizeImage = backgroundImage.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
        ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        backgroundFinal.paintIcon(this, g, 0, 0);

        // this.add(backButton);

    }

    // getfunction for back button
    public JButton getBackButton() {
        // createBackButton();
        return backButton;
    }
}