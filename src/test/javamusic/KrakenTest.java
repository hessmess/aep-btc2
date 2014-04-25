package javamusic;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class KrakenTest {

    @Test
    public void shouldSuccessfullyRetrieveOrderbook() throws IOException {
        Kraken Kraken = new Kraken();
        assertTrue(Kraken.refresh_orderbook());
    }

    @Test
    public void tradingFeeShouldBeZeroPointFiveNine() throws IOException {
        Kraken Kraken = new Kraken();
        assertEquals(0.16, Kraken.getTrading_fee());
    }

}
