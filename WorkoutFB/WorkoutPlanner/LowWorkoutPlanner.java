package WorkoutFB.WorkoutPlanner;

import PersonManagement.Person;
import WorkoutFB.Workout.LowWorkout;
import WorkoutFB.Workout.Workout_IF;

public class LowWorkoutPlanner implements WorkoutPlanner_IF {

    private Person person;

    public LowWorkoutPlanner(Person p) {
        this.person = p;
    }

    public Workout_IF createWorkout() {
        return new LowWorkout(this.person);
    }

}
