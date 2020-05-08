import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionExample1 {


	private static final String POST_URL = "https://api.boomi.com/api/rest/v1/trainingalokanand-4TKUEM/DeployedPackage/";

	private static final String POST_PARAMS = "{\n" + "\"environmentId\" : \"e48c5198-b700-49af-b4e4-8860af313c4f\",\r\n" + "\"packageId\" : \"6d464414-8ec1-43ac-9657-d59a7897a3a1\",\r\n" +  "\"notes\" : \"Package deployment via Jenkins Test user\"" + "\n}";

	public static void main(String[] args) throws IOException {

		
		sendPOST();
		System.out.println("POST DONE");
	}

	private static void sendPOST() throws IOException {
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Basic YWxvay5hbmFuZEBuZW9zYWxwaGEuY29tOmRlbGwxMjM0");

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}

}
