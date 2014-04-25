package javamusic;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by jhess on 24.04.14.
 */
public class JsonLoader {

    private String url;

    public JsonLoader(String url) {
        this.url = url;
    }

    public boolean refresh() throws IOException {
        try{
        URL obj = new URL(this.url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

//					int responseCode = con.getResponseCode();
//					System.out.println("\nSending 'POST' request to URL : " + url);
//					System.out.println("Post parameters : " + urlParameters);
//					System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        String orderbook = response.toString();
        System.out.println(orderbook);

        return orderbook.contains("bids");
        }
        catch (Exception error){
            return false;
        }
    }
}
