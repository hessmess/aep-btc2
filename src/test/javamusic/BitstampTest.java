package javamusic;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class BitstampTest {

    @Test
    public void shouldSuccessfullyRetrieveOrderbook() throws IOException {
        Bitstamp bitstamp = new Bitstamp();
        assertTrue(bitstamp.refresh_orderbook());
    }

    @Test
    public void tradingFeeShouldBeZeroPointFiveNine() throws IOException {
        Bitstamp bitstamp = new Bitstamp();
        assertEquals(0.32, bitstamp.getTrading_fee());
    }

}
