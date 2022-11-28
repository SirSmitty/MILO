import java.util.*;

public class DailyFoodTracker {

    private List<FoodItem> foodList;

    public DailyFoodTracker(){

        foodList = new LinkedList<FoodItem>();

    }


    public List<FoodItem> getFoodList(){
        return foodList;
    }

    public void addFood(FoodItem food){
        foodList.add(food);
    }

    public void removeFood(String foodString){
        
        foodList.remove(foodString);
    }
    
}
