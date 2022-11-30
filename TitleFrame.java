import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        DFTpanel DFTpanel = new DFTpanel(uManager);
        WPpanel WPpanel = new WPpanel();

        add(mainPanel, "main");
        add(personPanel, "person");
        add(CTPanel, "Calorie Tracker");
        add(DFTpanel, "Daily Intake");
        add(WPpanel, "Workout Plan");

        mainPanel.getPersonButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "person");
        });

        mainPanel.getCTButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Calorie Tracker");
        });

        mainPanel.getDFTButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Daily Intake");
        });

        mainPanel.getWPButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Workout Plan");
        });

        personPanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        DFTpanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        CTPanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        WPpanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}