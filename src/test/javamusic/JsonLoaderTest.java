package javamusic;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class JsonLoaderTest {

    @Test
    public void ShouldSuccessfullyRetrieveOrderbookFromBC() throws IOException {
        JsonLoader bitcoincentral = new JsonLoader("https://bitcoin-central.net/api/data/eur/depth");
        assertTrue(bitcoincentral.refresh().contains("bids"));
    }


}