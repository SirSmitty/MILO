package Prototype;

public class CreateCaloriePanel extends CaloriePanel {
    
    @Override
    public CreateCaloriePanel clone() throws CloneNotSupportedException {
        CreateCaloriePanel copyme = (CreateCaloriePanel)super.clone();
        return copyme;
    }
    
}
