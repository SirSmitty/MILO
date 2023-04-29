package Decorator;
import javax.swing.JPanel;

import CalculatorSingleton.CalorieCalculator;
import CalculatorSingleton.MyPie;
import PersonManagement.Person;
import PersonManagement.UserManager;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;


public class CTPanel extends CustomPanel {

        private CTPanelDecorator decorator;


        private Person activePerson;
        private MyPie pieGraph;
        private boolean init = false;
        private CalorieCalculator calculator;

        private JLabel caloriesLabel;
        private JLabel calorieCountLabel;
        private JLabel proteinLabel;
        private JLabel proteinCountLabel;
        private JLabel carbsLabel;
        private JLabel carbsCountLabel;
        private JLabel fatsLabel;
        private JLabel fatsCountLabel;
        private JComboBox<String> peopleBox;
        private JButton changeButton;



        public CTPanel(UserManager UM, BasePanel deco) {
                super(UM, deco);
                calculator = CalorieCalculator.getCalc();
                decorator = new CTPanelDecorator();

        }

        public void initialize() {

                init = true;

                activePerson = changePerson(uManager, 0);
                pieGraph = new MyPie(activePerson);
                decoratee.setPieGraph(pieGraph);

                calculator.setPersonforCalc(activePerson);
                calculator.calculateMacros();

                caloriesLabel = decorator.createCaloriesLabel(decoratee.getCustomFont());
                decoratee.add(caloriesLabel);
                
                calorieCountLabel = decorator.createCalorieCountLabel(decoratee.getCustomFont(), calculator);
                decoratee.add(calorieCountLabel);
        
                proteinLabel = decorator.createProteinLabel(decoratee.getCustomFont());
                decoratee.add(proteinLabel);
        
                proteinCountLabel = decorator.createProteinCountLabel(decoratee.getCustomFont(), calculator);
                decoratee.add(proteinCountLabel);
            
                carbsLabel = decorator.createCarbsLabel(decoratee.getCustomFont());
                decoratee.add(carbsLabel);
                
                carbsCountLabel = decorator.createCarbsCountLabel(decoratee.getCustomFont(), calculator);
                decoratee.add(carbsCountLabel);
                
                fatsLabel = decorator.createFatsLabel(decoratee.getCustomFont());
                decoratee.add(fatsLabel);
                
                fatsCountLabel = decorator.createFatsCountLabel(decoratee.getCustomFont(), calculator);
                decoratee.add(fatsCountLabel);
                
                peopleBox = decorator.createPeopleBox(decoratee.getCustomFont(), uManager);
                decoratee.add(peopleBox);
                
            
                changeButton = decorator.createChangeButton(decoratee.getCustomFont());
                assignChangeButtonLogic();
                decoratee.add(changeButton);

        }

        // public void paintComponent(Graphics g) {
        //         super.paintComponent(g);
        //         ImageIcon background = new ImageIcon("assets/milo_blank.jpg");
        //         Image backgroundImage = background.getImage(); // transform it
        //         Image backgroundResizeImage = backgroundImage.getScaledInstance(500, 700, java.awt.Image.SCALE_SMOOTH);
        //         ImageIcon backgroundFinal = new ImageIcon(backgroundResizeImage);
        //         backgroundFinal.paintIcon(this, g, 0, 0);

        //         pieGraph.drawPie((Graphics2D) g, new Rectangle(250, 200, 200, 200));
        // }

        public void assignChangeButtonLogic(){
                changeButton.addActionListener((ActionEvent e) -> {
                        activePerson = changePerson(uManager, peopleBox.getSelectedIndex());
                        changeLabels(activePerson, calculator, calorieCountLabel, proteinCountLabel,
                                        carbsCountLabel,
                                        fatsCountLabel);
                        pieGraph.changePerson(activePerson, calculator);
                        decoratee.setPieGraph(pieGraph);
                        decoratee.repaint();
                });
        }

        public Person changePerson(UserManager um, int index) {
                return um.getPerson(index);

        }

        public boolean getInit() {
                return init;
        }

        public void changeLabels(Person person, CalorieCalculator calculator, JLabel cLabel, JLabel pLabel,
                        JLabel carbLabel, JLabel fLabel) {

                calculator.setPersonforCalc(person);
                calculator.calculateMacros();
                cLabel.setText(Integer.toString(calculator.getCalories()));
                pLabel.setText(Integer.toString(calculator.getProtein()));
                carbLabel.setText(Integer.toString(calculator.getCarbs()));
                fLabel.setText(Integer.toString(calculator.getFats()));
        }

}
