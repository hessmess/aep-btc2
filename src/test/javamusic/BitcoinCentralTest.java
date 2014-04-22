package javamusic;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentralTest {

    @Test
    public void shouldSuccessfullyRetrieveOrderbook(){
        BitcoinCentral bitcoinCentral = new BitcoinCentral();
        assertTrue(bitcoinCentral.refresh_orderbook());
    }

    @Test
    public void tradingFeeShouldBeZeroPointFiveNine(){
        BitcoinCentral bitcoinCentral = new BitcoinCentral();
        assertEquals(0.59, bitcoinCentral.getTrading_fee());
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