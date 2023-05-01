package WorkoutFB;

import

public class AbstractWorkoutFactory implements Factory_IF {

    private Person person;

    public AbstractWorkoutFactory(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout(String workoutType) {

        Workout_IF workout;

        switch (workoutType) {
            case "lowWorkout":
                workout = new LowWorkout(this.person);
                break;
            case "mediumWorkout":
                workout = new MediumWorkout(this.person);
                break;
            case "highWorkout":
                workout = new HighWorkout(this.person);
                break;
            case "extremelyHighWorkout":
                workout = new ExtremelyHighWorkout(this.person);
                break;
            default:
                workout = new LowWorkout(this.person);
                break;
        }

        return workout;
    }
}
