package Prototype;

import javax.swing.*;

import PersonManagement.UserManager;
import PopUpFrames.ErrorFrame;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TitleFrame extends JFrame {

    public TitleFrame() {

        UserManager uManager = new UserManager();
        // uManager.addPerson(new Person());

        setTitle("MILO");
        setSize(500, 500);

        Container container = getContentPane();

        CardLayout cards = new CardLayout();

        container.setLayout(cards);

        TitlePanel mainPanel = new TitlePanel();
        PersonPanel personPanel = new PersonPanel(uManager);
        CTPanel CTPanel = new CTPanel();
        DFTpanel DFTpanel = new DFTpanel();
        WPpanel WPpanel = new WPpanel();

        add(mainPanel, "main");
        add(personPanel, "person");
        add(CTPanel, "Calorie Tracker");
        add(DFTpanel, "Daily Intake");
        add(WPpanel, "Workout Plan");

        mainPanel.getPersonButton().addActionListener((ActionEvent e) -> {
            cards.show(container, "person");
            setSize(500, 570);

        });

        mainPanel.getCTButton().addActionListener((ActionEvent e) -> {
            if (uManager.getPeople().size() >= 1) {
                if (!CTPanel.getInit()) {
                    CTPanel.initialize(uManager);
                }
                cards.show(container, "Calorie Tracker");
                setSize(500, 600);
            } else {
                ErrorFrame noPersonError = new ErrorFrame("You have not added a person, please do so");
                noPersonError.setVisible(true);
            }
        });

        mainPanel.getDFTButton().addActionListener((ActionEvent e) -> {

            if (uManager.getPeople().size() >= 1) {
                if (!DFTpanel.getInit()) {
                    DFTpanel.initialize(uManager);
                }

                cards.show(container, "Daily Intake");
                setSize(500, 700);
            } else {
                ErrorFrame noPersonError = new ErrorFrame("You have not added a person, please do so");
                noPersonError.setVisible(true);
            }
        });

        mainPanel.getWPButton().addActionListener((ActionEvent e) -> {
            if (uManager.getPeople().size() >= 1) {
                if (!WPpanel.getInit()) {
                    WPpanel.initialize(uManager);
                }

                cards.show(container, "Workout Plan");
                setSize(500, 700);
            } else {
                ErrorFrame noPersonError = new ErrorFrame("You have not added a person, please do so");
                noPersonError.setVisible(true);
            }
        });

        personPanel.getBackButton().addActionListener((ActionEvent e) -> {
            setSize(500, 500);
            cards.show(container, "main");
        });

        DFTpanel.getBackButton().addActionListener((ActionEvent e) -> {
            setSize(500, 500);
            cards.show(container, "main");
        });

        CTPanel.getBackButton().addActionListener((ActionEvent e) -> {
            setSize(500, 500);
            cards.show(container, "main");
        });

        WPpanel.getBackButton().addActionListener((ActionEvent e) -> {
            setSize(500, 500);
            cards.show(container, "main");
        });

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}