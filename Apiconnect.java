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

    Apiconnect() {
        API_KEY = "3R9jgQ1YN5sjedHi54WfPDwGO1Pof3d1dAwr4NWQ";
    }

    public void connectToApi() {
        try {
            String keyString = "&api_key=" + API_KEY;
            URL url = new URL(
                    "https://api.nal.usda.gov/fdc/v1/foods/search?query=chicken&pageSize=1" + keyString);
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
                // print result
                String responseString = response.toString();
                JSONObject obj = new JSONObject(responseString);
                JSONArray foodsArray = obj.getJSONArray("foods");
                JSONObject foodItem = foodsArray.getJSONObject(0);
                JSONArray foodNutrients = foodItem.getJSONArray("foodNutrients");
                for (int i = 0; i < foodNutrients.length(); i++) {

                    System.out.println(foodNutrients.getJSONObject(i).getString("nutrientName"));
                    System.out.println(foodNutrients.getJSONObject(i).getInt("value"));
                }

            } else {
                System.out.println("GET NOT WORKED");
            }

        } catch (Exception e) {
            System.out.println("URL is invalid");
        }
    }
}