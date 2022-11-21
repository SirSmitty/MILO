import javax.swing.JPanel;
import javax.xml.transform.URIResolver;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.Object;
import java.net.*;
import java.net.URLConnection;
import java.net.http.HttpClient;
import org.json.*;

public class Apiconnect extends Object {

    private String API_KEY;

    public Apiconnect() {
        API_KEY = "3R9jgQ1YN5sjedHi54WfPDwGO1Pof3d1dAwr4NWQ";
    }

    public void connectToApi() {
        
        URL url = createURL("chicken");
        String responseString = createResponseString(url);
        getFoodNutrients(responseString);
        
        // try {
            // String keyString = "&api_key=" + API_KEY;
            // URL url = new URL(
            //         "https://api.nal.usda.gov/fdc/v1/foods/search?query=chicken&pageSize=1" + keyString);

            // HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // con.setRequestMethod("GET");

            // int responseCode = con.getResponseCode();
            // String readLine = null;

            // if (responseCode == HttpURLConnection.HTTP_OK) {
            //     System.out.println("URL is valid");

            //     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //     StringBuffer response = new StringBuffer();
            //     while ((readLine = in.readLine()) != null) {
            //         response.append(readLine);
            //         response.append(System.lineSeparator());
            //     }
            //     in.close();
                // print result
                // JSONObject obj = new JSONObject(responseString);
                // JSONArray foodsArray = obj.getJSONArray("foods");
                // JSONObject foodItem = foodsArray.getJSONObject(0);
                // JSONArray foodNutrients = foodItem.getJSONArray("foodNutrients");
                // for (int i = 0; i < foodNutrients.length(); i++) {

                //     System.out.println(foodNutrients.getJSONObject(i).getString("nutrientName"));
                //     System.out.println(foodNutrients.getJSONObject(i).getInt("value"));
                // }
                
                // } else {
                    //     System.out.println("GET NOT WORKED");
            // }

        // } catch (Exception e) {
        //     System.out.println("URL is invalid");
        // }
    }

    public URL createURL(String foodItem){

        String keyString = "&api_key=" + API_KEY;
        try{
            URL url = new URL("https://api.nal.usda.gov/fdc/v1/foods/search?query=" + foodItem + "&pageSize=1" + keyString);
            return url;
        }
        catch(Exception e) {
            System.out.println("URL is invalid");
            return null;
        }     
    } 
    
    
    public String createResponseString(URL url){
        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
    
                int responseCode = con.getResponseCode();
                String readLine = null;
    
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("URL is valid");
    
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuffer response = new StringBuffer();
                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                        response.append(System.lineSeparator());
                    }
                    in.close();
                    return response.toString();
                }
                else{
                    return "invalid r code";
                }
            
        }catch(Exception e){
            return "invalid";
        }
    }

    public FoodItem getFoodNutrients(String responseString){

        FoodItem food = new FoodItem(0, 0, 0);

        JSONObject obj = new JSONObject(responseString);
        JSONArray foodsArray = obj.getJSONArray("foods");
        JSONObject foodItem = foodsArray.getJSONObject(0);
        JSONArray foodNutrients = foodItem.getJSONArray("foodNutrients");

        String nutrient;

        for (int i = 0; i < foodNutrients.length(); i++) {

    
            nutrient = foodNutrients.getJSONObject(i).getString("nutrientName");
            switch(nutrient){
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