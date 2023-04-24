package Prototype;

public class PanelCreator_Factory implements PanelFactory_IF {

    // change name of PrototypePanel to actual panels needed via DFT,CT,Person,
    // Workout
    // change name of Activity_prototype to DFT,CT, Person, workout protype

    // private PrototypePanel Activity_prototype;
    private CaloriePanel calorie_prototype;
    private DailyFoodPanel daily_food_prototype;
    private WorkoutPanel workout_prototype;
    private PPanel person_prototype;

    public PanelCreator_Factory() {

        this.calorie_prototype = new CreateCaloriePanel();// change CopyPanel name based on Panel to be created
        this.daily_food_prototype = new CreateDailyFoodPanel();
        this.workout_prototype = new CreateWorkoutPanel();
        this.person_prototype = new CreatePPanel();
    }

    // make copies of these for other panels such as dtf, person , workout
    public CaloriePanel CreateCaloriePanel() {
        try {
            return (CaloriePanel) calorie_prototype.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public DailyFoodPanel CreateDailyFoodPanel() {
        try {
            return (DailyFoodPanel) daily_food_prototype.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public WorkoutPanel CreateWorkoutPanel() {
        try {
            return (WorkoutPanel) workout_prototype.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public PPanel CreatePPanel() {
        try {
            return (PPanel) person_prototype.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
