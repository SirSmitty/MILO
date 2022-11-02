public class CalorieCalculator{

    private Person person;

    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public CalorieCalculator(Person p){
        person = p;
        calculateMacros();
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
        int calories = (int) ((10 * person.getKbWeight()) + (6.25 * person.getCmHeight()) - (5 * person.getAge()) - 161);
        switch (person.getActivityLevel()) {
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

        switch (person.getGoals()) {
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
        if (person.getGoals() == "Gain" || person.getGoals() == "Lose") {
            multiplier = .45;
        }
        int protein = (int) (multiplier * getCalories());
        protein /= 4;
        setProtein(protein);
    }

    public void calculateCarbs() {
        double multiplier = .3;
        if (person.getGoals() == "Gain") {
            multiplier = .35;
        }
        int carbs = (int) (multiplier * getCalories());
        carbs /= 4;
        setCarbs(carbs);
    }

    public void calculateFats() {
        double multiplier = .3;
        if (person.getGoals() == "Gain" || person.getGoals() == "Lose") {
            multiplier = .25;
        }
        int fats = (int) (multiplier * getCalories());
        fats /= 9;
        setFats(fats);
    }

    public void calculateMacros(){
        calculateCalories();
        calculateProtein();
        calculateCarbs();
        calculateFats();
    }

}