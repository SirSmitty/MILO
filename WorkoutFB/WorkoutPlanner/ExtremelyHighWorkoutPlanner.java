package WorkoutFB.WorkoutPlanner;

import PersonManagement.Person;
import WorkoutFB.Workout.ExtremelyHighWorkout;
import WorkoutFB.Workout.Workout_IF;

public class ExtremelyHighWorkoutPlanner implements WorkoutPlanner_IF {

    private Person person;

    public ExtremelyHighWorkoutPlanner(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout() {
        return new ExtremelyHighWorkout(this.person);
    }
}
