package WorkoutFB;

import PersonManagement.Person;


public class AbstractWorkoutFactory implements Factory_IF {

    private Person person;

    public AbstractWorkoutFactory(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout(String workoutType) {

        Workout_IF workout;

        switch (workoutType) {
            case "Low (1 workout / week)":
                workout = new LowWorkout(this.person);
                break;
            case "Medium(2-3 workouts / week)":
                workout = new MediumWorkout(this.person);
                break;
            case "High (4-5 workouts / week)":
                workout = new HighWorkout(this.person);
                break;
            case "Extremely High (6+ workouts / week)":
                workout = new ExtremelyHighWorkout(this.person);
                break;
            default:
                workout = new LowWorkout(this.person);
                break;
        }

        return workout;
    }
}
