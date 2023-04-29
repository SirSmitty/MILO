package Decorator;

import PersonManagement.UserManager;
import PersonManagement.Person;
import PopUpFrames.ConfirmationFrame;
import PopUpFrames.ErrorFrame;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PersonPanel extends CustomPanel {
    
    private PersonPanelDecorator decorator;
    
    private JLabel nameLabel;
    private JTextField nameTField;
    
    private JLabel ageLabel;
    private JTextField ageTField;

    private JLabel weightLabel;
    private JTextField weightTField;
    
    private JLabel heightLabel;
    private JComboBox<Integer> feetCombo;
    private JLabel feetLabel;
    private JComboBox<Integer> inchCombo;
    private JLabel inchLabel;

    private JLabel activityLabel;
    private JComboBox<String> activityCombo;
    
    private JLabel goalsLabel;
    private JComboBox<String> goalsCombo;

    private JButton submitButton;

    private Integer feet[] = { 4, 5, 6, 7 };
    private Integer inches[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    private String activityLevelsOptions[] = { "Low (1 workout / week)", "Medium(2-3 workouts / week)",
                    "High (4-5 workouts / week)", "Extremely High (6+ workouts / week)" };
    private String goalsOptions[] = { "Gain", "Maintain", "Lose" };


    public PersonPanel(UserManager UM, BasePanel deco) {

        super(UM, deco);
        decorator = new PersonPanelDecorator();
        initialize();
    }

    public void initialize(){

        nameLabel = decorator.createNameLabel(decoratee.getCustomFont());
        decoratee.add(nameLabel);
        
        nameTField = decorator.createNameField(decoratee.getCustomFont());
        decoratee.add(nameTField);

        ageLabel = decorator.createAgeLabel(decoratee.getCustomFont());
        decoratee.add(ageLabel);

        ageTField = decorator.createAgeField(decoratee.getCustomFont());
        decoratee.add(ageTField);
    
        weightLabel = decorator.createWeightLabel(decoratee.getCustomFont());
        decoratee.add(weightLabel);
        
        weightTField = decorator.createWeightField(decoratee.getCustomFont());
        decoratee.add(weightTField);
        
        heightLabel = decorator.createHeightLabel(decoratee.getCustomFont());
        decoratee.add(heightLabel);
        
        feetCombo = decorator.createFeetCombo(decoratee.getCustomFont(), feet);
        decoratee.add(feetCombo);
        
        feetLabel = decorator.createFeetLabel(decoratee.getCustomFont());
        decoratee.add(feetLabel);

        inchCombo = decorator.createInchCombo(decoratee.getCustomFont(), inches);
        decoratee.add(inchCombo);

        inchLabel = decorator.createInchLabel(decoratee.getCustomFont());
        decoratee.add(inchLabel);
    
        activityLabel = decorator.createActivityLabel(decoratee.getCustomFont());
        decoratee.add(activityLabel);

        activityCombo = decorator.createActivityCombo(decoratee.getCustomFont(),activityLevelsOptions);
        decoratee.add(activityCombo);

        goalsLabel = decorator.createGoalsLabel(decoratee.getCustomFont());
        decoratee.add(goalsLabel);

        goalsCombo = decorator.createGoalsCombo(decoratee.getCustomFont(), goalsOptions);
        decoratee.add(goalsCombo);
    
        submitButton = decorator.createSubmitButton(decoratee.getCustomFont());
        assignSubmitButtonLogic();
        decoratee.add(submitButton);

    }

    // public JPanel newPanel(){
    //     return decoratee;
    // }

    public void assignSubmitButtonLogic(){
        this.submitButton.addActionListener((ActionEvent e) -> {
            try {
                String personName = this.nameTField.getText();
                int personAge = Integer.parseInt(ageTField.getText());
                int personHeightFeet = feet[feetCombo.getSelectedIndex()];
                int personHeightInches = inches[inchCombo.getSelectedIndex()];
                int personWeight = Integer.parseInt(weightTField.getText());
                String personActivityLevel = activityLevelsOptions[activityCombo.getSelectedIndex()];
                String personGoals = goalsOptions[goalsCombo.getSelectedIndex()];

                Person newPerson = new Person(personName, personAge, personHeightFeet, personHeightInches,
                        personWeight,
                        personActivityLevel, personGoals);

                uManager.addPerson(newPerson);

                ConfirmationFrame confirmed = new ConfirmationFrame("Person succesfully added");
                confirmed.setVisible(true);

            } catch (Exception exc) {

                ErrorFrame personError = new ErrorFrame("Please fill out all the information");
                personError.setVisible(true);

            }
        });
    }

    public JButton getBackButton() {
        return decoratee.getBackButton();
    }

    @Override
    public boolean getInit() {
        return true;
    }

}
