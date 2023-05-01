package WorkoutFB;

import java.util.List;

import PersonManagement.Person;

public class HighWorkout implements Workout_IF{

    private List<Week> workoutWeeks;

    private String goals;
    private String activity;
    private int weight;

    public HighWorkout(Person p){
        this.goals = p.getGoals();
        this.activity = p.getActivityLevel();
        this.weight = p.getWeight();
    }

    @Override
    public void calculateWorkouts() {
        for(int i = 0; i < 4; i++){
            workoutWeeks.add(new Week(new WeekBuilder(i+1)
            .withGoals(goals)
            .withActivity(activity)
            .withWeight(weight)
            ));
        }
    }

    @Override
    public List<Week> getMonth() {
        return workoutWeeks;
    }
    
}
