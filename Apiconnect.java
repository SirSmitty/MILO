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

public class Apiconnect extends Object {
    Apiconnect() {
        try {
            URL url = new URL("https://www.boredapi.com/api/activity");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


        } catch (

        Exception e) {
            System.out.println("URL is invalid");
        }

    }
}