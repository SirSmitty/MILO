package Decorator;

import javax.swing.JPanel;

import CalculatorSingleton.CalorieCalculator;
import PersonManagement.UserManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;


//code that is not shared
public class CTPanelDecorator {


        public JLabel createCaloriesLabel(Font customFont){
                JLabel calorieLabel = new JLabel(
                        "<html><span bgcolor=\"white\" color=\"black\">Daily Calorie Count</span></html>");
                calorieLabel.setLocation(50, 150);
                calorieLabel.setSize(150, 50);
                calorieLabel.setFont(customFont);
                return calorieLabel;  
        }

        public JLabel createCalorieCountLabel(Font customFont, CalorieCalculator calculator){
                String calCount = Integer.toString(calculator.getCalories());
                JLabel calorieCountLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#000000\">" + calCount
                                                + "</span></html>");
                calorieCountLabel.setLocation(50, 180);
                calorieCountLabel.setSize(50, 50);
                calorieCountLabel.setFont(customFont);
                return calorieCountLabel;
        }


        public JLabel createProteinLabel(Font customFont){                        
                JLabel proteinLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#d3605a\">Daily Protein Intake</span></html>");
                proteinLabel.setLocation(50, 220);
                proteinLabel.setSize(150, 50);
                proteinLabel.setFont(customFont);
                return proteinLabel;
        }

        public JLabel createProteinCountLabel(Font customFont, CalorieCalculator calculator){
                // protein count label
                String proteinCount = Integer.toString(calculator.getProtein());
                JLabel proteinCountLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#d3605a\">" + proteinCount
                                                + "</span></html>");
                proteinCountLabel.setLocation(50, 250);
                proteinCountLabel.setSize(50, 50);
                proteinCountLabel.setFont(customFont);
                return proteinCountLabel;
        }          
        
        public JLabel createCarbsLabel(Font customFont){                        
                JLabel carbsLabel = new JLabel(
                                        "<html><span bgcolor=\"white\" color=\"#414444\">Daily Carb Intake</span></html>");
                carbsLabel.setLocation(50, 290);
                carbsLabel.setSize(150, 50);
                carbsLabel.setFont(customFont);
                return carbsLabel;
        }
        
        public JLabel createCarbsCountLabel(Font customFont, CalorieCalculator calculator){
                String carbsCount = Integer.toString(calculator.getCarbs());
                JLabel carbsCountLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#414444\">" + carbsCount
                                                + "</span></html>");
                carbsCountLabel.setLocation(50, 320);
                carbsCountLabel.setSize(50, 50);
                carbsCountLabel.setFont(customFont);
                return carbsCountLabel;
        }   

        public JLabel createFatsLabel(Font customFont){
                // Fats label
                JLabel fatsLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#8c8861\">Daily Fat Intake</span></html>");
                fatsLabel.setLocation(50, 360);
                fatsLabel.setSize(150, 50);
                fatsLabel.setFont(customFont);
                return fatsLabel;
        }

        public JLabel createFatsCountLabel(Font customFont, CalorieCalculator calculator){
                // fats count label
                String FatsCount = Integer.toString(calculator.getFats());
                JLabel fatsCountLabel = new JLabel(
                                "<html><span bgcolor=\"white\" color=\"#8c8861\">" + FatsCount
                                                + "</span></html>");
                fatsCountLabel.setLocation(50, 390);
                fatsCountLabel.setSize(50, 50);
                fatsCountLabel.setFont(customFont);
                return fatsCountLabel;
        }
        

        public JComboBox<String> createPeopleBox(Font customFont, UserManager UM){
                JComboBox<String> peopleBox = new JComboBox<>(UM.getPeopleNames());
                peopleBox.setLocation(50, 50);
                peopleBox.setSize(150, 45);
                peopleBox.setFont(customFont);
                return peopleBox;
        }

        public JButton createChangeButton(Font customFont){
                JButton changeButton = new JButton("<html><span color=\"white\">Change</span></html>");
                changeButton.setLocation(235, 50);
                changeButton.setSize(150, 45);
                changeButton.setFont(customFont);
                changeButton.setBackground(new Color(211, 96, 90));
                changeButton.setOpaque(true);
                changeButton.setBorderPainted(false);
                return changeButton;
        }

}
