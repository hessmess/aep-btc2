package javamusic;


/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentral {

    private double trading_fee = 0.59;


    public void BitcoinCentral(){

    }

    public boolean refresh_orderbook(){



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