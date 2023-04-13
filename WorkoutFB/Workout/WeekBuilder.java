package WorkoutFB.Workout;

public class WeekBuilder {

    private final int weekNum;
    private String goals;
    private String activity;
    private int weight;

    public WeekBuilder(Integer weekNum){
        if (weekNum == null) {
            throw new IllegalArgumentException("weekNum can not be null");
          }
        this.weekNum = weekNum;
    }

    public WeekBuilder withGoals(String goals){
        this.goals = goals;
        return this;
    }

    public WeekBuilder withActivity(String activity){
        this.activity = activity;
        return this;
    }

    public WeekBuilder withWeight(int weight){
        this.weight = weight;
        return this;
    }

    public int getWeekNum(){
        return weekNum;
    }

    public String getGoals(){
        return goals;
    }

    public String getActivity(){
        return activity;
    }

    public int getWeight(){
        return weight;
    }



    
}

