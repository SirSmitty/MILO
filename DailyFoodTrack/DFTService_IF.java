package DailyFoodTrack;

import java.net.URL;
import java.util.List;


public interface DFTService_IF {
    
    //api functions

    public String connectToApi(String foodString);

    public URL createURL(String foodItem);

    public String createResponseString(URL url);

    public FoodItem getFoodItem(String foodString);

    //Dft functions
    public FoodItem removeFood(int foodIndex);

    public List<FoodItem> getFoodList();

    public List<String> getFoodNameList();

    public void addFood(FoodItem food);


}
