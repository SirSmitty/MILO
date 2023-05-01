package WorkoutFB;

import java.util.List;

public class Week {

    private final int weekNum;
    private final String goals;
    private final int weight;
    private final String activity;
    private List<Day> days;

    public Week(WeekBuilder wb){
        this.weekNum = wb.getWeekNum();
        this.goals = wb.getGoals();
        this.weight = wb.getWeight();
        this.activity = wb.getActivity();
    }

    public int getWeekNum(){
        return weekNum;
    }

    public String getGoals(){
        return goals;
    }

    public int getWeight(){
        return weight;
    }

    public String getActivity(){
        return activity;
    }

    public List<Day> getDays(){
        return days;
    }

    public List<Day> generateWorkoutWeek(){

        switch(getActivity()){
            case "Low (1 workout / week)":
                days.add(new Day("Wednesday", getGoals(), getWeight(), "Full Body"));
                break;
            case "Medium(2-3 workouts / week)":
                days.add(new Day("Monday", getGoals(), getWeight(), "Push"));
                days.add(new Day("Wednesday", getGoals(), getWeight(), "Pull"));
                days.add(new Day("Friday", getGoals(), getWeight(), "Legs"));
                break;
            case "High (4-5 workouts / week)":
                days.add(new Day("Sunday", getGoals(), getWeight(), "Push"));
                days.add(new Day("Tuesday", getGoals(), getWeight(), "Pull"));
                days.add(new Day("Thursday", getGoals(), getWeight(), "Legs"));
                days.add(new Day("Saturday", getGoals(), getWeight(), "Full Body"));
                break;
            case "Extremely High (6+ workouts / week)":
                days.add(new Day("Monday", getGoals(), getWeight(), "Push"));
                days.add(new Day("Tuesday", getGoals(), getWeight(), "Pull"));
                days.add(new Day("Wednesday", getGoals(), getWeight(), "Legs"));
                days.add(new Day("Thursday", getGoals(), getWeight(), "Push"));
                days.add(new Day("Friday", getGoals(), getWeight(), "Pull"));
                days.add(new Day("Saturday", getGoals(), getWeight(), "Legs"));
                break;
            }

        return days;
    }
    
}
