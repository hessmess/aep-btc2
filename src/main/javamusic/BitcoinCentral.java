package javamusic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentral {

    private double trading_fee = 0.59;


    public void BitcoinCentral(){

    }

    public boolean refresh_orderbook(){

        boolean noerror_OB_BC = false;
        int counter_OB_BC = 0;

        JSONObject orderbook_bitcoincentral = new JSONObject("{}");

        do{

            try {
                //		Ruft das Orderbook von Bitcoin-Central als JSON ab
                orderbook_bitcoincentral = readJsonFromUrl("https://bitcoin-central.net/api/data/eur/depth");
                //	    System.out.println(orderbook_bitcoincentral.toString());
                noerror_OB_BC = true;
            }
            catch (Exception OB_BC){
                if(counter_OB_BC < 50) {
                    counter_OB_BC++;
                    System.out.println( "Could not retrieve Orderbook from Bitcoin-Central, retrying (" + counter_OB_BC + "/50)");
                }
                else {
                    System.out.println("He's dead Jim... Sending out error report and restarting program...");
                    Mailgun errormail_OB_BC = new Mailgun("jonas.hess.w8ing@gmail.com", "Error: BC Orderbook (" + counter_OB_BC + "/50)", "No worries, everything is gonna be alright!");
                    errormail_OB_BC.sendmail();
                    return null;
                }

            }
        } while(noerror_OB_BC == false);

        if(counter_OB_BC > 0){
            System.out.println("Sending out error report...");
            Mailgun errormail_OB_BC = new Mailgun("jonas.hess.w8ing@gmail.com", "Error: BC Orderbook (" + counter_OB_BC + "/50)", "No worries, everything is gonna be alright!");
            errormail_OB_BC.sendmail();
        }


        //  Ruft aus dem Orderbook die "asks" ab und wandelt sie in einen String um
        Object BC_ask = orderbook_bitcoincentral.get("asks");
        String BC_ask_string = BC_ask.toString();

        //  Teilt den String in seine Bestandteile und entfernt alles nicht-numerische
        String[] asks_BC = BC_ask_string.split(",");

        for (int i = 0; i< asks_BC.length; i++){
            asks_BC[i] = asks_BC[i].replaceAll("[^\\d.]", "");	}

        //  Wandelt Price- und Amount-Strings in doubles um und ordnet sie in die Arrays ask_prices_BC und ask_amounts_BC
        double[] ask_prices_BC = new double[asks_BC.length/4];
        double[] ask_amounts_BC = new double[asks_BC.length/4];

        for (int i = 0; i< asks_BC.length/4; i++){
            ask_amounts_BC[i] = Double.valueOf(asks_BC[i*4]);
            ask_prices_BC[i] = Double.valueOf(asks_BC[i*4+2]);	}
        //  Asks sind aufsteigend sortiert!

        double[] ask_prices_15 = new double[15];
        double[] ask_amounts_15 = new double[15];

        for(int i = 0; i<ask_prices_15.length; i++){
            ask_prices_15[i] = ask_prices_BC[i];
            ask_amounts_15[i] = ask_amounts_BC[i];
        }

        //  ===========================================


        //  Ruft aus dem Orderbook von Bitcoin-Central die "bids" ab und wandelt sie in einen String um
        Object BC_bid = orderbook_bitcoincentral.get("bids");
        String BC_bid_string = BC_bid.toString();

        //  Teilt den String in seine Bestandteile und entfernt alles nicht-numerische
        String[] bids_BC = BC_bid_string.split(",");

        for (int i = 0; i< bids_BC.length; i++){
            bids_BC[i] = bids_BC[i].replaceAll("[^\\d.]", "");	}

        //  Wandelt Price- und Amount-Strings in doubles um und ordnet sie in die Arrays bid_prices_BC und bid_amounts_BC
        double[] bid_prices_BC = new double[bids_BC.length/4];
        double[] bid_amounts_BC = new double[bids_BC.length/4];

        for (int i = 0; i< bids_BC.length/4; i++){
            bid_amounts_BC[i] = Double.valueOf(bids_BC[i*4]);
            bid_prices_BC[i] = Double.valueOf(bids_BC[i*4+2]);	}

        //  Bids sind AUFSTEIGEND sortiert!!

        double[] bid_prices_15 = new double[15];
        double[] bid_amounts_15 = new double[15];

        for(int i = 0; i<bid_prices_15.length; i++){
            bid_prices_15[i] = bid_prices_BC[bid_prices_BC.length -1 -i];
            bid_amounts_15[i] = bid_amounts_BC[bid_prices_BC.length -1 -i];
        }

        return true;
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