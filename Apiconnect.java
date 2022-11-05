// import javax.swing.JPanel;
// import javax.xml.transform.URIResolver;

// import java.awt.*;
// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.*;
// import javax.swing.BorderFactory;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.*;
// import java.lang.Object;
// import java.net.URLConnection;
// import java.net.http.HttpClient;

// public class Apiconnect extends Object {
//     Apiconnect() {
//         var client = HttpClient.newHttpClient();

//         var request = HttpClient.newBuilder(
//                 URIResolver.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
//                 .header("accept", "application/json")
//                 .build();

//         // use the client to send the request
//         var response = client.send(request, new JsonBodyHandler<>(APOD.class));

//         // the response:
//         System.out.println(response.body().get().title);
//     }
// }
