public class Person {

    private int heightFeet;
    private int heightInches;
    private int weight;
    private String activityLevel;
    private String goals;

    private int bmr;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public Person() {

        setheightFeet(5);
        setheightInches(9);
        setWeight(165);
        setActivityLevel("Medium(2-3 workouts / week)");
        setGoals("Maintain");
    }

    public Person(int heightFeet, int heightInches, int weight, String activityLevel, String goals) {

        setheightFeet(heightFeet);
        setheightInches(heightInches);
        setWeight(weight);
        setActivityLevel(activityLevel);
        setGoals(goals);
    }

    public int getheightFeetInInches() {
        return heightFeet * 12;
    }

    public int getheightInches() {
        return heightInches;
    }

    public int getCmHeight() {
        return (int) ((getheightFeetInInches() + getheightInches()) * 2.54);
    }

    public int getWeight() {
        return weight;
    }

    public int getKbWeight() {
        return (int) (weight / 2.205);
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public String getGoals() {
        return goals;
    }

    public int getBMR() {
        return bmr;
    }

    public void setheightFeet(int hf) {
        heightFeet = hf;
    }

    public void setheightInches(int hi) {
        heightInches = hi;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public void setActivityLevel(String aL) {
        activityLevel = aL;
    }

    public void setGoals(String g) {
        goals = g;
    }

    public void setBMR(int b) {
        bmr = b;
    }

}