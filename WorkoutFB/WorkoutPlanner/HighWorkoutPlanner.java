package WorkoutFB.WorkoutPlanner;

import PersonManagement.Person;
import WorkoutFB.Workout.HighWorkout;
import WorkoutFB.Workout.Workout_IF;

public class HighWorkoutPlanner implements WorkoutPlanner_IF {

    private Person person;

    public HighWorkoutPlanner(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout() {
        return new HighWorkout(this.person);
    }
}
