package Prototype;

public class CreateWorkoutPanel extends WorkoutPanel {
    
    @Override
    public CreateWorkoutPanel clone() throws CloneNotSupportedException {
        CreateWorkoutPanel copyme = (CreateWorkoutPanel)super.clone();
        return copyme;
    }
}
