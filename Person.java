public class Person {

    private String name;
    private int age;
    private int heightFeet;
    private int heightInches;
    private int weight;
    private String activityLevel;
    private String goals;

    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public Person() {

        setName("N/A");
        setAge(23);
        setheightFeet(5);
        setheightInches(9);
        setWeight(195);
        setActivityLevel("High (4-5 workouts / week)");
        setGoals("Maintain");
        calculateCalories();
        calculateProtein();
        calculateCarbs();
        calculateFats();
    }

    public Person(int age, int heightFeet, int heightInches, int weight, String activityLevel, String goals) {

        setAge(age);
        setheightFeet(heightFeet);
        setheightInches(heightInches);
        setWeight(weight);
        setActivityLevel(activityLevel);
        setGoals(goals);
        calculateCalories();
        calculateProtein();
        calculateCarbs();
        calculateFats();
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

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFats() {
        return fats;
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

    public void setCalories(int c) {
        calories = c;
    }

    public void setProtein(int p) {
        protein = p;
    }

    public void setCarbs(int c) {
        carbs = c;
    }

    public void setFats(int f) {
        fats = f;
    }

    public void calculateCalories() {
        int calories = (int) ((10 * getKbWeight()) + (6.25 * getCmHeight()) - (5 * getAge()) - 161);
        switch (getActivityLevel()) {
            case ("Low (1 workout / week)"):
                calories *= 1.4;
                break;
            case ("Medium(2-3 workouts / week)"):
                calories *= 1.7;
                break;
            case ("High (4-5 workouts / week)"):
                calories *= 2.0;
                break;
            case ("Extremely High (6+ workouts / week)"):
                calories *= 2.3;
                break;
        }

        switch (getGoals()) {
            case ("Gain"):
                calories *= 1.2;
                break;
            case ("Lose"):
                calories *= .8;
                break;
            default:
                break;

        }

        setCalories(calories);
    }

    public void calculateProtein() {
        double multiplier = .4;
        if (getGoals() == "Gain" || getGoals() == "Lose") {
            multiplier = .45;
        }
        int protein = (int) (multiplier * getCalories());
        protein /= 4;
        setProtein(protein);
    }

    public void calculateCarbs() {
        double multiplier = .3;
        if (getGoals() == "Gain") {
            multiplier = .35;
        }
        int carbs = (int) (multiplier * getCalories());
        carbs /= 4;
        setCarbs(carbs);
    }

    public void calculateFats() {
        double multiplier = .3;
        if (getGoals() == "Gain" || getGoals() == "Lose") {
            multiplier = .25;
        }
        int fats = (int) (multiplier * getCalories());
        fats /= 9;
        setFats(fats);
    }

}