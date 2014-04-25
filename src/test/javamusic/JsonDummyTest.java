package javamusic;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;

/**
 * Created by jhess on 24.04.14.
 */
public class JsonDummyTest {
    @Test
    public void ShouldNotRetrieveAnythingAndRespondFalse() throws IOException {
        JsonDummy bitcoincentral = new JsonDummy("https://blakjhasdhkjasd.com");
        assertFalse(bitcoincentral.refresh_orderbook());

    }
}
