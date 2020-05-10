import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionExample {


	private static final String POST_URL = "https://api.boomi.com/api/rest/v1/trainingalokanand-4TKUEM/DeployedPackage/";

	private static final String POST_PARAMS = "{\n" + "\"environmentId\" : \"4d444c97-d19c-4bb6-8839-f0dbfc04bf24\",\r\n" + "\"packageId\" : \"541560ad-c9c4-4060-b632-dd5c7c15c133\",\r\n" + "\"notes\" : \"Package deployment via Jenkins Production User\"" + "\n}";

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
