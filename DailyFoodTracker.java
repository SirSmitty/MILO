import java.util.*;

public class DailyFoodTracker {

    private List<FoodItem> foodList;

    public DailyFoodTracker() {

        foodList = new LinkedList<FoodItem>();

    }

    public List<FoodItem> getFoodList() {
        return foodList;
    }

    public List<String> getFoodNameList() {
        List<String> names = new LinkedList<String>();
        for (int i = 0; i < foodList.size(); i++) {
            names.add(foodList.get(i).getName());
        }
        return names;

    }

    public void addFood(FoodItem food) {
        foodList.add(food);
    }

    public FoodItem removeFood(int foodIndex) {

        return foodList.remove(foodIndex - 1);
    }

}
