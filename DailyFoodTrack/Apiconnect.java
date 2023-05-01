package DailyFoodTrack;

import java.io.*;
import java.lang.Object;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

import org.json.*;

public class Apiconnect extends Object implements DFTService_IF {

    private String API_KEY;
    private List<FoodItem> foodList;
    private List<String> foodNames;

    public Apiconnect() {
        API_KEY = "3R9jgQ1YN5sjedHi54WfPDwGO1Pof3d1dAwr4NWQ";
        foodList = new LinkedList<FoodItem>();
        foodNames = new LinkedList<String>();
    }

    public String connectToApi(String foodString) {

        URL url = createURL(foodString);
        return createResponseString(url);
    }

    public URL createURL(String foodItem) {

        String keyString = "&api_key=" + API_KEY;
        try {
            URL url = new URL(
                    "https://api.nal.usda.gov/fdc/v1/foods/search?query=" + foodItem + "&pageSize=1" + keyString);
            return url;
        } catch (Exception e) {
            System.out.println("URL is invalid");
            return null;
        }
    }

    public String createResponseString(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            String readLine = null;

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                    response.append(System.lineSeparator());
                }
                in.close();
                return response.toString();
            } else {
                return "invalid r code";
            }

        } catch (Exception e) {
            return "invalid";
        }
    }

    public FoodItem getFoodItem(String foodString) {

        if (foodNames.contains(foodString)) {
            return foodList.get(foodNames.indexOf(foodString));
        } else {

            String responseString = connectToApi(foodString.toLowerCase());

            FoodItem food = new FoodItem(foodString, 0, 0, 0, 0);

            JSONObject obj = new JSONObject(responseString);
            JSONArray foodsArray = obj.getJSONArray("foods");
            JSONObject foodItem = foodsArray.getJSONObject(0);
            JSONArray foodNutrients = foodItem.getJSONArray("foodNutrients");
            String packageWeighString = foodItem.getString("packageWeight");
            packageWeighString = packageWeighString.substring(packageWeighString.lastIndexOf('/') + 1,
                    packageWeighString.lastIndexOf(" "));
            // this is in grams
            int packageWeight = Integer.parseInt(packageWeighString);
            int servingSize = foodItem.getInt("servingSize");

            int gramsPerServing = packageWeight / servingSize;
            food.setServingSize(gramsPerServing);

            String nutrient;

            for (int i = 0; i < foodNutrients.length(); i++) {

                nutrient = foodNutrients.getJSONObject(i).getString("nutrientName");
                switch (nutrient) {
                    case "Protein":
                        food.setProtein(foodNutrients.getJSONObject(i).getInt("value"));
                        break;
                    case "Total lipid (fat)":
                        food.setFats(foodNutrients.getJSONObject(i).getInt("value"));
                        break;
                    case "Carbohydrate, by difference":
                        food.setCarbs(foodNutrients.getJSONObject(i).getInt("value"));
                        break;
                    default:
                        break;
                }
            }

            food.calcCals();
            return food;
        }

    }

    public List<FoodItem> getFoodList() {
        return foodList;
    }

    public List<String> getFoodNameList() {
        return foodNames;

    }

    public void addFood(FoodItem food) {
        foodList.add(food);
        foodNames.add(food.getName());
    }

    public FoodItem removeFood(int foodIndex) {
        foodNames.remove(foodIndex - 1);
        return foodList.remove(foodIndex - 1);
    }

}