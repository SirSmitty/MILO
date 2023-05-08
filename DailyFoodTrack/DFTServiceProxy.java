package DailyFoodTrack;
import java.net.URL;
import java.util.List;

public class DFTServiceProxy implements DFTService_IF{

    private DFTService_IF api;

    public DFTServiceProxy() {
    }

    public void newInstance(){
        api = new DFTService();
    }

    public String connectToApi(String foodString){
        return api.connectToApi(foodString);
    }

    public URL createURL(String foodItem){
        return api.createURL(foodItem);
    }

    public String createResponseString(URL url){
        return api.createResponseString(url);
    }

    public FoodItem getFoodItem(String foodString){
        return api.getFoodItem(foodString);
    }

    public List<FoodItem> getFoodList() {
        return api.getFoodList();
    }

    public List<String> getFoodNameList() {
        return api.getFoodNameList();
    }

    public void addFood(FoodItem food) {
        api.addFood(food);
    }

    public FoodItem removeFood(int foodIndex) {
        return api.removeFood(foodIndex);
    }


}
