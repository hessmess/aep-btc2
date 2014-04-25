package javamusic;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class BitcoinCentralTest {

    @Test
    public void shouldSuccessfullyRetrieveOrderbook() throws IOException {
        BitcoinCentral bitcoinCentral = new BitcoinCentral();
        assertTrue(bitcoinCentral.refresh_orderbook());
    }

    @Test
    public void tradingFeeShouldBeZeroPointFiveNine() throws IOException {
        BitcoinCentral bitcoinCentral = new BitcoinCentral();
        assertEquals(0.59, bitcoinCentral.getTrading_fee());
    }


    @Test
    public void ShouldNotRetrieveAnythingAndRespondFalse() throws IOException {
        JsonDummy bitcoincentral = new JsonDummy("https://blakjhasdhkjasd.com");
        assertFalse(bitcoincentral.refresh_orderbook());

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