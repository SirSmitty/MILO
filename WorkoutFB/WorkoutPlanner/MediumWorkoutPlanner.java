package WorkoutFB.WorkoutPlanner;

import PersonManagement.Person;
import WorkoutFB.Workout.MediumWorkout;
import WorkoutFB.Workout.Workout_IF;

public class MediumWorkoutPlanner implements WorkoutPlanner_IF {

    private Person person;

    public MediumWorkoutPlanner(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout() {
        return new MediumWorkout(this.person);
    }
}
