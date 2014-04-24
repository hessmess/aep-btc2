package javamusic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentral {

    private double trading_fee = 0.59;

    public static void main(String[] args) throws IOException {
        BitcoinCentral bitcoinCentral = new BitcoinCentral();
        bitcoinCentral.refresh_orderbook();
    }

    public void BitcoinCentral() throws IOException {

    }

    public boolean refresh_orderbook() throws IOException {


            String url = "https://bitcoin-central.net/api/data/eur/depth";
//			String url = "https://httpbin.org/get";

            URL obj = new URL(url);
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

    public double getTrading_fee(){
        return trading_fee;
    }
}

/*
oderbook: refresh
get bids
get asks
get bids eur
get asks eur
get comission rate

btc_above
btc below
*/