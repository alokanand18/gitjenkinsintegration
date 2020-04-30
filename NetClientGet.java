import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {

// http://localhost:8080/RESTfulExample/json/product/get
public static void main(String[] args) {

try {

URL url = new URL("https://anz.connect.boomi.com/ws/rest/getData/v1/prospects/?type=Prospect");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setRequestProperty("Accept", "application/json");
conn.setRequestProperty("Authorization", "Basic dHJhaW5pbmdhbG9rYW5hbmQtNFRLVUVNLlJESlhPQTowODU2NjQ0Mi1jNjU2LTRhZTItYjhlZi1kYWM3MDE2NzQ3NGU=");


if (conn.getResponseCode() != 200) {
throw new RuntimeException("Failed : HTTP error code : "
+ conn.getResponseCode());
}

BufferedReader br = new BufferedReader(new InputStreamReader(
(conn.getInputStream())));

String output;
System.out.println("Output from Server .... \n");
while ((output = br.readLine()) != null) {
System.out.println(output);
}

conn.disconnect();

} catch (MalformedURLException e) {

e.printStackTrace();

} catch (IOException e) {

e.printStackTrace();

}

}

}