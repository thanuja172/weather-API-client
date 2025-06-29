import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class  SimpleWeatherClient{
    public static void main(String[] args) {
        try {
            String city = "england"; // Change city name here
            String urlString = "https://wttr.in/" + city + "?format=3";

            // Create a connection to the URL
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine = in.readLine(); // Get the first line
            in.close();

            // Print the result
            System.out.println("Weather Info:");
            System.out.println(inputLine);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

