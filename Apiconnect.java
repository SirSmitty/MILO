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
    Apiconnect() {

    }

    public void connectToApi() {
        try {
            URL url = new URL("https://www.boredapi.com/api/activity");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println("URL is valid");

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
                // print result
                String responseString = response.toString();
                JSONObject obj = new JSONObject(responseString);
                String post_id = obj.getString("type");
                System.out.println(post_id);
                // System.out.println(post_id);

                // GetAndPost.POSTRequest(response.toString());
            } else {
                System.out.println("GET NOT WORKED");
            }

        } catch (Exception e) {
            System.out.println("URL is invalid");
        }
    }
}