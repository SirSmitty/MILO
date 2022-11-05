public class Person {

    private String name;
    private int age;
    private int heightFeet;
    private int heightInches;
    private int weight;
    private String activityLevel;
    private String goals;


    public Person() {

        setName("N/A");
        setAge(23);
        setheightFeet(5);
        setheightInches(9);
        setWeight(195);
        setActivityLevel("High (4-5 workouts / week)");
        setGoals("Maintain");

    }

    public Person(String name, int age, int heightFeet, int heightInches, int weight, String activityLevel,
            String goals) {

        setName(name);
        setAge(age);
        setheightFeet(heightFeet);
        setheightInches(heightInches);
        setWeight(weight);
        setActivityLevel(activityLevel);
        setGoals(goals);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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


    public void setName(String n) {
        name = n;
    }

    public void setAge(int a) {
        age = a;
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

}