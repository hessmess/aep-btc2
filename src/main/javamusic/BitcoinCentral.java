package javamusic;

import java.io.IOException;

/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentral {

    private double trading_fee = 0.59;
    private String url = "https://bitcoin-central.net/api/data/eur/depth";

    public BitcoinCentral() throws IOException {

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