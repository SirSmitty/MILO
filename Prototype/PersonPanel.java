package Prototype;

import PersonManagement.UserManager;

import java.awt.*;
import javax.swing.JButton;

public class PersonPanel extends CustomPanel {

    private PersonPanelDecorator decorator;

    public PersonPanel(UserManager uManager) {
        super();
        decorator = new PersonPanelDecorator(uManager);
    }

    public JButton getBackButton() {
        return decoratee.getBackButton();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        decorator.paintComponents(g);
        // ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        // Image backgroundImage = background.getImage(); // transform it
        // Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700,
        // java.awt.Image.SCALE_SMOOTH);
        // ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        // backgroundFinal.paintIcon(this, g, 0, 0);
    }
}
