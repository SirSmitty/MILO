package Prototype;

import javax.swing.JPanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class CustomPanel extends JPanel implements Panel_IF {

    protected BasePanel decoratee;

    public CustomPanel() {
        decoratee = new BasePanel();
    }

    // public void createBackButton() {
    // decoratee.createBackButton();
    // };

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        decoratee.paintComponent(g);
    };

    public JButton getBackButton() {
        return decoratee.getBackButton();
    };
}
