package Prototype;

public class CreateDailyFoodPanel extends DailyFoodPanel{
    
    @Override
    public CreateDailyFoodPanel clone() throws CloneNotSupportedException {
        CreateDailyFoodPanel copyme = (CreateDailyFoodPanel)super.clone();
        return copyme;
    }
}
