package Prototype;

public interface PanelFactory_IF {

    // panelCreator to seperate and make different panels based on DFT, CT, PP, etc.
    // public PrototypePanel
    CaloriePanel CreateCaloriePanel();

    DailyFoodPanel CreateDailyFoodPanel();

    WorkoutPanel CreateWorkoutPanel();

    PPanel CreatePPanel();

}
