import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class TitleFrame extends JFrame {

    public TitleFrame() {
        Vector<Person> people = new Vector();
        people.add(new Person());

        setTitle("MILO");
        setSize(500, 700);

        Container container = getContentPane();

        CardLayout cards = new CardLayout();

        container.setLayout(cards);

        TitlePanel mainPanel = new TitlePanel();
        PersonPanel personPanel = new PersonPanel(people);
        CTPanel CTPanel = new CTPanel(people);
        DFTpanel DFTPanel = new DFTpanel();

        add(mainPanel, "main");
        add(personPanel, "person");
        add(CTPanel, "Calorie Tracker");
        add(DFTPanel, "Daily Intake");

        mainPanel.getPersonButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "person");
        });

        mainPanel.getCTButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Calorie Tracker");
        });

        mainPanel.getDFTButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "Daily Intake");
        });

        personPanel.getBackButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "main");
        });

        DFTPanel.getBackButton().addActionListener((ActionEvent e) -> {
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