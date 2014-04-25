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
    private String url = "https://bitcoin-central.net/api/data/eur/depth";

    public void BitcoinCentral() throws IOException {

    }

    public boolean refresh_orderbook() throws IOException {
        JsonLoader orderbook = new JsonLoader(this.url);
        return orderbook.refresh();
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