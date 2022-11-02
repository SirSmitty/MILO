import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class TitleFrame extends JFrame {

    public TitleFrame() {
        UserManager uManager = new UserManager();
        uManager.addPerson(new Person());

        setTitle("MILO");
        setSize(500, 700);

        Container container = getContentPane();

        CardLayout cards = new CardLayout();

        container.setLayout(cards);

        TitlePanel mainPanel = new TitlePanel();
        PersonPanel personPanel = new PersonPanel(uManager);
        CTPanel CTPanel = new CTPanel(uManager);

        add(mainPanel, "main");
        add(personPanel, "person");
        add(CTPanel, "Calorie Tracker");

        mainPanel.getPersonButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "person");
        });

        mainPanel.getCTButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Calorie Tracker");
        });

        personPanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        CTPanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PersonPanel PIFrame = new PersonPanel();
    }

}