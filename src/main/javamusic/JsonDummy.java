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
public class JsonDummy {

    private String url = "https://lkjdfgjadgkljhsadhlf.de";

    public JsonDummy(String url) throws IOException {
        this.url = url;
    }

    public boolean refresh_orderbook() throws IOException {
        JsonLoader orderbook = new JsonLoader(this.url);

        try{
            return orderbook.refresh().contains("bids");
        }
        catch (Exception error){
            System.out.println("Exception: " + error);
            return false;
        }
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