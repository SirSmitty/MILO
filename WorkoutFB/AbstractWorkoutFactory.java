package WorkoutFB;

public class AbstractWorkoutFactory implements Factory_IF{

    private Person p;

    public AbstractWorkoutFactory(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout(String workoutType) {

        switch(workoutType){       
            case "lowWorkout":
                return new LowWorkout(this.person);
                break;
            case "mediumWorkout":
                return new MediumWorkout(this.person);
                break;
            case "HighWorkout":
                return new HighWorkout(this.person);
                break;
            case "extremelyHighWorkout":
                return new ExtremelyHighWorkout(this.person);
                break;
            default:
                return new LowWorkout(this.person);
                break;
        }
    }
}
